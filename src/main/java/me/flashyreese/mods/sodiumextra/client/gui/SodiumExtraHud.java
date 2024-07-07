package me.flashyreese.mods.sodiumextra.client.gui;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod;
import me.flashyreese.mods.sodiumextra.mixin.gui.MinecraftClientAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.LayeredDrawer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class SodiumExtraHud implements LayeredDrawer.Layer {

    public static SodiumExtraHud INSTANCE = new SodiumExtraHud();

    private static final List<Text> textList = new ObjectArrayList<>();

    private static final MinecraftClient client = MinecraftClient.getInstance();

    private SodiumExtraHud() {}

    @SubscribeEvent
    public static void onStartTick(ClientTickEvent.Pre event) {
        // Clear the textList to start fresh (this might not be ideal but hey it's still better than whatever the fuck debug hud is doing)
        textList.clear();
        if (SodiumExtraClientMod.options().extraSettings.showFps) {
            int currentFPS = MinecraftClientAccessor.getCurrentFPS();

            Text text = Text.translatable("sodium-extra.overlay.fps", currentFPS);

            if (SodiumExtraClientMod.options().extraSettings.showFPSExtended)
                text = Text.literal(String.format("%s %s", text.getString(), Text.translatable("sodium-extra.overlay.fps_extended", SodiumExtraClientMod.getClientTickHandler().getHighestFps(), SodiumExtraClientMod.getClientTickHandler().getAverageFps(),
                        SodiumExtraClientMod.getClientTickHandler().getLowestFps()).getString()));

            textList.add(text);
        }

        if (SodiumExtraClientMod.options().extraSettings.showCoords && !client.hasReducedDebugInfo() && client.player != null) {
            Vec3d pos = client.player.getPos();

            Text text = Text.translatable("sodium-extra.overlay.coordinates", String.format("%.2f", pos.x), String.format("%.2f", pos.y), String.format("%.2f", pos.z));
            textList.add(text);
        }

        if (!SodiumExtraClientMod.options().renderSettings.lightUpdates) {
            Text text = Text.translatable("sodium-extra.overlay.light_updates");
            textList.add(text);
        }
    }

    @Override
    public void render(DrawContext context, RenderTickCounter tickCounter) {
        if (!client.getDebugHud().shouldShowDebugHud() && !client.options.hudHidden) {
            SodiumExtraGameOptions.OverlayCorner overlayCorner = SodiumExtraClientMod.options().extraSettings.overlayCorner;
            // Calculate starting position based on the overlay corner
            int x;
            int y = overlayCorner == SodiumExtraGameOptions.OverlayCorner.BOTTOM_LEFT || overlayCorner == SodiumExtraGameOptions.OverlayCorner.BOTTOM_RIGHT ?
                    client.getWindow().getScaledHeight() - client.textRenderer.fontHeight - 2 : 2;
            // Render each text in the list
            for (Text text : textList) {
                if (overlayCorner == SodiumExtraGameOptions.OverlayCorner.TOP_RIGHT || overlayCorner == SodiumExtraGameOptions.OverlayCorner.BOTTOM_RIGHT) {
                    x = client.getWindow().getScaledWidth() - client.textRenderer.getWidth(text) - 2;
                } else {
                    x = 2;
                }
                this.drawString(context, text, x, y);
                if (overlayCorner == SodiumExtraGameOptions.OverlayCorner.BOTTOM_LEFT || overlayCorner == SodiumExtraGameOptions.OverlayCorner.BOTTOM_RIGHT) {
                    y -= client.textRenderer.fontHeight + 2;
                } else {
                    y += client.textRenderer.fontHeight + 2; // Increase the y-position for the next text
                }
            }
        }
    }

    private void drawString(DrawContext drawContext, Text text, int x, int y) {
        int textColor = 0xffffffff; // Default text color

        if (SodiumExtraClientMod.options().extraSettings.textContrast == SodiumExtraGameOptions.TextContrast.BACKGROUND) {
            drawContext.fill(x - 1, y - 1, x + client.textRenderer.getWidth(text) + 1, y + client.textRenderer.fontHeight + 1, -1873784752);
        }

        drawContext.drawText(client.textRenderer, text, x, y, textColor, SodiumExtraClientMod.options().extraSettings.textContrast == SodiumExtraGameOptions.TextContrast.SHADOW);
    }
}

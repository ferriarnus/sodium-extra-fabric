package me.flashyreese.mods.sodiumextra.client.gui;

import me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod;
import me.flashyreese.mods.sodiumextra.client.gui.options.control.SliderControlExtended;
import me.flashyreese.mods.sodiumextra.common.util.ControlValueFormatterExtended;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.VideoMode;
import net.minecraft.client.util.Window;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.embeddedt.embeddium.api.OptionGroupConstructionEvent;
import org.embeddedt.embeddium.api.OptionPageConstructionEvent;
import org.embeddedt.embeddium.api.options.OptionIdentifier;
import org.embeddedt.embeddium.api.options.control.ControlValueFormatter;
import org.embeddedt.embeddium.api.options.control.CyclingControl;
import org.embeddedt.embeddium.api.options.control.SliderControl;
import org.embeddedt.embeddium.api.options.storage.MinecraftOptionsStorage;
import org.embeddedt.embeddium.api.options.structure.OptionGroup;
import org.embeddedt.embeddium.api.options.structure.OptionImpact;
import org.embeddedt.embeddium.api.options.structure.OptionImpl;
import org.embeddedt.embeddium.api.options.structure.StandardOptions;

import java.util.Optional;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class SodiumExtraSodiumOptions {
    static final MinecraftOptionsStorage vanillaOpts = MinecraftOptionsStorage.INSTANCE;

    //Options
    public static final Identifier SCREEN_SCALE = Identifier.of("screen_scale");
    public static final Identifier FOV_SCALE = Identifier.of("fov_scale");
    public static final Identifier FULL_SCREEN_RES = Identifier.of("full_screen_res");
    public static final Identifier VSYNC = Identifier.of(SodiumExtraClientMod.MODID, "full_screen_res");

    //Groups
    public static final Identifier ACCESSIBILITY = Identifier.of(SodiumExtraClientMod.MODID, "accessibility");
    public static final Identifier RESOLUTION = Identifier.of(SodiumExtraClientMod.MODID, "resolution");

    static OptionGroup accessibility() {
        return OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(int.class, vanillaOpts)
                        .setId(SCREEN_SCALE)
                        .setName(Text.translatable("options.screenEffectScale"))
                        .setTooltip(Text.translatable("options.screenEffectScale.tooltip"))
                        .setControl(option -> new SliderControl(option, 0, 100, 1,ControlValueFormatter.percentage()))
                        .setBinding((opts, value) -> opts.getDistortionEffectScale().setValue((double) value / 100.0F), (opts) -> Math.toIntExact(Math.round(opts.getDistortionEffectScale().getValue() * 100.0F)))
                        .setImpact(OptionImpact.LOW)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, vanillaOpts)
                        .setId(FOV_SCALE)
                        .setName(Text.translatable("options.fovEffectScale"))
                        .setTooltip(Text.translatable("options.fovEffectScale.tooltip"))
                        .setControl(option -> new SliderControl(option, 0, 100, 1, ControlValueFormatter.percentage()))
                        .setBinding((opts, value) -> opts.getFovEffectScale().setValue(Math.sqrt(value / 100.0F)), (opts) -> (int) Math.round(Math.pow(opts.getFovEffectScale().getValue(), 2.0D) * 100.0F))
                        .setImpact(OptionImpact.LOW)
                        .build()
                )
                .setId(ACCESSIBILITY)
                .build();
    }

    static OptionGroup resolution() {
        Window window = MinecraftClient.getInstance().getWindow();
        return OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(int.class, vanillaOpts)
                        .setId(FULL_SCREEN_RES)
                        .setName(Text.translatable("options.fullscreen.resolution"))
                        .setTooltip(Text.translatable("sodium-extra.option.resolution.tooltip"))
                        .setControl(option -> new SliderControlExtended(option, 0, window.getMonitor() != null ? window.getMonitor().getVideoModeCount() : 0, 1, ControlValueFormatterExtended.resolution(), false))
                        .setBinding((options, value) -> {
                            if (window.getMonitor() != null) {
                                if (value == 0) {
                                    window.setVideoMode(Optional.empty());
                                } else {
                                    window.setVideoMode(Optional.of(window.getMonitor().getVideoMode(value - 1)));
                                }
                            }
                            window.applyVideoMode();
                        }, options -> {
                            if (window.getMonitor() == null) {
                                return 0;
                            } else {
                                Optional<VideoMode> optional = window.getVideoMode();
                                return optional.map((videoMode) -> window.getMonitor().findClosestVideoModeIndex(videoMode) + 1).orElse(0);
                            }
                        })
                        .setImpact(OptionImpact.HIGH)
                        .build())
                .setId(RESOLUTION)
                .build();
    }

    static OptionImpl<SodiumExtraGameOptions, SodiumExtraGameOptions.VerticalSyncOption> vsync() {
        return OptionImpl.createBuilder(SodiumExtraGameOptions.VerticalSyncOption.class, SodiumExtraGameOptionPages.sodiumExtraOpts)
                .setId(VSYNC)
                .setName(Text.translatable("options.vsync"))
                .setTooltip(Text.literal(Text.translatable("sodium.options.v_sync.tooltip").getString() + "\n- " + Text.translatable("sodium-extra.option.use_adaptive_sync.name").getString() + ": " + Text.translatable("sodium-extra.option.use_adaptive_sync.tooltip").getString()))
                .setControl((opt) -> new CyclingControl<>(opt, SodiumExtraGameOptions.VerticalSyncOption.class,
                        SodiumExtraGameOptions.VerticalSyncOption.getAvailableOptions()))
                .setBinding((opts, value) -> {
                    switch (value) {
                        case OFF -> {
                            opts.extraSettings.useAdaptiveSync = false;
                            vanillaOpts.getData().getEnableVsync().setValue(false);
                        }
                        case ON -> {
                            opts.extraSettings.useAdaptiveSync = false;
                            vanillaOpts.getData().getEnableVsync().setValue(true);
                        }
                        case ADAPTIVE -> {
                            opts.extraSettings.useAdaptiveSync = true;
                            vanillaOpts.getData().getEnableVsync().setValue(true);
                        }
                    }
                    vanillaOpts.save();
                }, opts -> {
                    if (vanillaOpts.getData().getEnableVsync().getValue() && !opts.extraSettings.useAdaptiveSync) {
                        return SodiumExtraGameOptions.VerticalSyncOption.ON;
                    } else if (!vanillaOpts.getData().getEnableVsync().getValue() && !opts.extraSettings.useAdaptiveSync) {
                        return SodiumExtraGameOptions.VerticalSyncOption.OFF;
                    } else {
                        return SodiumExtraGameOptions.VerticalSyncOption.ADAPTIVE;
                    }
                })
                .setImpact(OptionImpact.VARIES)
                .build();
    }

    @SubscribeEvent
    public static void registerGroups(OptionPageConstructionEvent event) {
        if (event.getId().equals(StandardOptions.Pages.GENERAL)) {
            event.addGroup(resolution());
        } else if (event.getId().equals(StandardOptions.Pages.QUALITY)) {
            event.addGroup(accessibility());
        }
    }

    @SubscribeEvent
    public static void registerOption(OptionGroupConstructionEvent event) {
        if (event.getId().matches(StandardOptions.Group.WINDOW)) {
            int i = -1;
            for (var option: event.getOptions()) {
                if (option.getId().matches(StandardOptions.Option.VSYNC)) {
                    if (option.getTooltip().getString().equals(Text.translatable("sodium.options.v_sync.tooltip").getString())) {
                        i = event.getOptions().indexOf(option);
                    }
                }
            }

            if (i > -1) {
                event.getOptions().set(i, vsync());
            }
        }
    }

}

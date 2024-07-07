package me.flashyreese.mods.sodiumextra;

import me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.embeddedt.embeddium.api.render.clouds.ModifyCloudRenderingEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class EmbeddiumEvents {

    @SubscribeEvent
    public static void cloudDistance(ModifyCloudRenderingEvent event) {
        event.setCloudRenderDistance(event.getCloudRenderDistance() * SodiumExtraClientMod.options().extraSettings.cloudDistance / 100);
    }
}

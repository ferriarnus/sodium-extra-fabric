package me.flashyreese.mods.sodiumextra.client;

import com.google.common.collect.EvictingQueue;
import me.flashyreese.mods.sodiumextra.mixin.gui.MinecraftClientAccessor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

import java.util.Comparator;
import java.util.Queue;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ClientTickHandler {
    private static final Queue<Integer> fpsQueue = EvictingQueue.create(200);
    private static int averageFps, lowestFps, highestFps;

    @SubscribeEvent
    public static void onClientInitialize(ClientTickEvent.Post event) {
        int currentFPS = MinecraftClientAccessor.getCurrentFPS();
        fpsQueue.add(currentFPS);
        averageFps = (int) fpsQueue.stream().mapToInt(Integer::intValue).average().orElse(0);
        lowestFps = fpsQueue.stream().min(Comparator.comparingInt(e -> e)).orElse(0);
        highestFps = fpsQueue.stream().max(Comparator.comparingInt(e -> e)).orElse(0);
    }

    public int getAverageFps() {
        return averageFps;
    }

    public int getLowestFps() {
        return lowestFps;
    }

    public int getHighestFps() {
        return highestFps;
    }
}

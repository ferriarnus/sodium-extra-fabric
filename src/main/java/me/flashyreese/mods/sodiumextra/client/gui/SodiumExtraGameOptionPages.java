package me.flashyreese.mods.sodiumextra.client.gui;

import com.google.common.collect.ImmutableList;
import me.flashyreese.mods.sodiumextra.client.gui.options.control.SliderControlExtended;
import me.flashyreese.mods.sodiumextra.client.gui.options.storage.SodiumExtraOptionsStorage;
import me.flashyreese.mods.sodiumextra.common.util.ControlValueFormatterExtended;
import me.jellysquid.mods.sodium.client.gui.options.*;
import me.jellysquid.mods.sodium.client.gui.options.control.ControlValueFormatter;
import me.jellysquid.mods.sodium.client.gui.options.control.CyclingControl;
import me.jellysquid.mods.sodium.client.gui.options.control.SliderControl;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import me.jellysquid.mods.sodium.client.gui.options.storage.MinecraftOptionsStorage;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.TranslatableText;

import java.util.ArrayList;
import java.util.List;

public class SodiumExtraGameOptionPages {
    private static final MinecraftOptionsStorage vanillaOpts = new MinecraftOptionsStorage();
    public static final SodiumExtraOptionsStorage sodiumExtraOpts = new SodiumExtraOptionsStorage();

    public static OptionPage animation() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("gui.socialInteractions.tab_all").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.animations_all.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.animation = value, opts -> opts.animationSettings.animation)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("block.minecraft.water").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.animate_water.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.water = value, opts -> opts.animationSettings.water)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("block.minecraft.lava").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.animate_lava.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.lava = value, opts -> opts.animationSettings.lava)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("block.minecraft.fire").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.animate_fire.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.fire = value, opts -> opts.animationSettings.fire)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("block.minecraft.nether_portal").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.animate_portal.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.portal = value, opts -> opts.animationSettings.portal)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.block_animations").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.block_animations.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.animationSettings.blockAnimations = value, options -> options.animationSettings.blockAnimations)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .build());
        return new OptionPage(new TranslatableText("sodium-extra.option.animations").getString(), ImmutableList.copyOf(groups));
    }

    public static OptionPage particle() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("gui.socialInteractions.tab_all").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.particles_all.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.particles = value, opts -> opts.particleSettings.particles)
                        .build()
                )
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("subtitles.entity.generic.splash").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.rain_splash.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.rainSplash = value, opts -> opts.particleSettings.rainSplash)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("subtitles.entity.generic.explode").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.explosions.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.explosion = value, opts -> opts.particleSettings.explosion)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("block.minecraft.water").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.water.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.water = value, opts -> opts.particleSettings.water)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.smoke").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.smoke.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.smoke = value, opts -> opts.particleSettings.smoke)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("item.minecraft.potion").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.potions.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.potion = value, opts -> opts.particleSettings.potion)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("block.minecraft.nether_portal").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.portal.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.portal = value, opts -> opts.particleSettings.portal)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("itemGroup.redstone").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.redstone.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.redstone = value, opts -> opts.particleSettings.redstone)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.dripping_particles").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.dripping_particles.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.drip = value, opts -> opts.particleSettings.drip)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("subtitles.entity.firework_rocket.blast").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.fireworks.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.firework = value, opts -> opts.particleSettings.firework)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("block.minecraft.bubble_column").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.bubbles.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.bubble = value, opts -> opts.particleSettings.bubble)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("soundCategory.ambient").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.environment.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.environment = value, opts -> opts.particleSettings.environment)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("entity.minecraft.villager").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.villagers.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.villagers = value, opts -> opts.particleSettings.villagers)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("block.minecraft.composter").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.composter.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.composter = value, opts -> opts.particleSettings.composter)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("subtitles.block.generic.break").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.block_break.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.blockBreak = value, opts -> opts.particleSettings.blockBreak)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("subtitles.block.generic.hit").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.block_breaking.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.blockBreaking = value, opts -> opts.particleSettings.blockBreaking)
                        .build()
                )
                .build());
        return new OptionPage(new TranslatableText("options.particles").getString(), ImmutableList.copyOf(groups));
    }

    public static OptionPage detail() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.sky").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.sky.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.detailSettings.sky = value, opts -> opts.detailSettings.sky)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.stars").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.stars.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.detailSettings.stars = value, opts -> opts.detailSettings.stars)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.sun_moon").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.sun_moon.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.detailSettings.sunMoon = value, opts -> opts.detailSettings.sunMoon)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("soundCategory.weather").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.rain_snow.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.detailSettings.rainSnow = value, opts -> opts.detailSettings.rainSnow)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.biome_colors").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.biome_colors.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.detailSettings.biomeColors = value, options -> options.detailSettings.biomeColors)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.sky_colors").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.sky_colors.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.detailSettings.skyColors = value, options -> options.detailSettings.skyColors)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .build());
        return new OptionPage(new TranslatableText("sodium-extra.option.details").getString(), ImmutableList.copyOf(groups));
    }

    public static OptionPage render() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(int.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.fog").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.fog.tooltip").getString())
                        .setControl(option -> new SliderControlExtended(option, 0, 33, 1, ControlValueFormatterExtended.fogDistance(), false))
                        .setBinding((options, value) -> options.renderSettings.fogDistance = value, options -> options.renderSettings.fogDistance)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.light_updates").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.light_updates.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.lightUpdates = value, options -> options.renderSettings.lightUpdates)
                        .build()
                )
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("entity.minecraft.item_frame").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.item_frames.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderSettings.itemFrame = value, opts -> opts.renderSettings.itemFrame)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("entity.minecraft.armor_stand").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.armor_stands.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.armorStand = value, options -> options.renderSettings.armorStand)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("entity.minecraft.painting").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.paintings.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.painting = value, options -> options.renderSettings.painting)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("block.minecraft.piston").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.piston.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.piston = value, options -> options.renderSettings.piston)
                        .build()
                )
                .build());
        return new OptionPage(new TranslatableText("sodium-extra.option.render").getString(), ImmutableList.copyOf(groups));
    }

    public static OptionPage extra() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, vanillaOpts)
                        .setName(new TranslatableText("sodium-extra.option.gl_debug_verbosity").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.gl_debug_verbosity.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.glDebugVerbosity = value ? 1 : 0, options -> options.glDebugVerbosity == 1)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, SodiumExtraGameOptionPages.sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.use_fast_random").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.use_fast_random.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.useFastRandom = value, options -> options.extraSettings.useFastRandom)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.reduce_resolution_on_mac").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.reduce_resolution_on_mac.tooltip").getString())
                        .setEnabled(MinecraftClient.IS_SYSTEM_MAC)
                        .setImpact(OptionImpact.HIGH)
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.extraSettings.reduceResolutionOnMac = value, opts -> opts.extraSettings.reduceResolutionOnMac)
                        .build()
                ).build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(SodiumExtraGameOptions.OverlayCorner.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.overlay_corner").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.overlay_corner.tooltip").getString())
                        .setControl(option -> new CyclingControl<>(option, SodiumExtraGameOptions.OverlayCorner.class))
                        .setBinding((opts, value) -> opts.extraSettings.overlayCorner = value, opts -> opts.extraSettings.overlayCorner)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.show_fps").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.show_fps.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.extraSettings.showFps = value, opts -> opts.extraSettings.showFps)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.show_fps_extended").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.show_fps_extended.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.extraSettings.showFPSExtended = value, opts -> opts.extraSettings.showFPSExtended)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.show_coordinates").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.show_coordinates.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.extraSettings.showCoords = value, opts -> opts.extraSettings.showCoords)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.cloud_height").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.cloud_height.tooltip").getString())
                        .setControl(option -> new SliderControl(option, 0, 255, 1, ControlValueFormatter.number()))
                        .setBinding((options, value) -> options.extraSettings.cloudHeight = value, options -> options.extraSettings.cloudHeight)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.toasts").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.toasts.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.toasts = value, options -> options.extraSettings.toasts)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.instant_sneak").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.instant_sneak.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.instantSneak = value, options -> options.extraSettings.instantSneak)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName(new TranslatableText("sodium-extra.option.prevent_shaders").getString())
                        .setTooltip(new TranslatableText("sodium-extra.option.prevent_shaders.tooltip").getString())
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.preventShaders = value, options -> options.extraSettings.preventShaders)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .build());

        return new OptionPage(new TranslatableText("sodium-extra.option.extras").getString(), ImmutableList.copyOf(groups));
    }
}

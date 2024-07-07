package me.flashyreese.mods.sodiumextra.client.gui;

import com.google.common.collect.ImmutableList;
import me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod;
import me.flashyreese.mods.sodiumextra.client.gui.options.control.SliderControlExtended;
import me.flashyreese.mods.sodiumextra.client.gui.options.storage.SodiumExtraOptionsStorage;
import me.flashyreese.mods.sodiumextra.common.util.ControlValueFormatterExtended;
import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionOptionsRegistryHolder;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.embeddedt.embeddium.api.OptionGUIConstructionEvent;
import org.embeddedt.embeddium.api.options.OptionIdentifier;
import org.embeddedt.embeddium.api.options.control.ControlValueFormatter;
import org.embeddedt.embeddium.api.options.control.CyclingControl;
import org.embeddedt.embeddium.api.options.control.SliderControl;
import org.embeddedt.embeddium.api.options.control.TickBoxControl;
import org.embeddedt.embeddium.api.options.storage.MinecraftOptionsStorage;
import org.embeddedt.embeddium.api.options.structure.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class SodiumExtraGameOptionPages {
    public static final SodiumExtraOptionsStorage sodiumExtraOpts = new SodiumExtraOptionsStorage();
    public static final MinecraftOptionsStorage vanillaOpts = MinecraftOptionsStorage.INSTANCE;

    //Options
    public static final Identifier ALL_ANIMATIONS = Identifier.of(SodiumExtraClientMod.MODID, "all_animations");
    public static final Identifier WATER = Identifier.of(SodiumExtraClientMod.MODID, "water");
    public static final Identifier LAVA = Identifier.of(SodiumExtraClientMod.MODID, "lava");
    public static final Identifier FIRE = Identifier.of(SodiumExtraClientMod.MODID, "fire");
    public static final Identifier NETHER_PORTAL = Identifier.of(SodiumExtraClientMod.MODID, "nether_portal");
    public static final Identifier BLOCK_ANIMATION = Identifier.of(SodiumExtraClientMod.MODID, "block_animation");
    public static final Identifier SCULK = Identifier.of(SodiumExtraClientMod.MODID, "sculk");

    public static final Identifier ALL_PARTICLES = Identifier.of(SodiumExtraClientMod.MODID, "all_particles");
    public static final Identifier RAIN = Identifier.of(SodiumExtraClientMod.MODID, "rain");
    public static final Identifier BLOCK_BREAK = Identifier.of(SodiumExtraClientMod.MODID, "block_break");
    public static final Identifier BLOCK_HIT = Identifier.of(SodiumExtraClientMod.MODID, "block_hit");

    public static final Identifier SKY = Identifier.of(SodiumExtraClientMod.MODID, "sky");
    public static final Identifier STARS = Identifier.of(SodiumExtraClientMod.MODID, "stars");
    public static final Identifier SUN_MOON = Identifier.of(SodiumExtraClientMod.MODID, "sun_moon");
    public static final Identifier WEATHER = Identifier.of(SodiumExtraClientMod.MODID, "weather");
    public static final Identifier BIOME = Identifier.of(SodiumExtraClientMod.MODID, "biome");
    public static final Identifier SKY_COLOR = Identifier.of(SodiumExtraClientMod.MODID, "sky_color");

    public static final Identifier DIM_FOG_CONTROL = Identifier.of(SodiumExtraClientMod.MODID, "dim_fog_control");
    public static final Identifier FOG_START = Identifier.of(SodiumExtraClientMod.MODID, "fog_start");
    public static final Identifier FOG = Identifier.of(SodiumExtraClientMod.MODID, "fog");
    public static final Identifier LIGHT_UPDATE = Identifier.of(SodiumExtraClientMod.MODID, "light_update");
    public static final Identifier ITEM_FRAME = Identifier.of(SodiumExtraClientMod.MODID, "item_frame");
    public static final Identifier ARMOR_STAND = Identifier.of(SodiumExtraClientMod.MODID, "armor_stand");
    public static final Identifier PAINTING = Identifier.of(SodiumExtraClientMod.MODID, "painting");
    public static final Identifier BEACON_BEAM = Identifier.of(SodiumExtraClientMod.MODID, "beacon_beam");
    public static final Identifier BEACON_HEIGHT = Identifier.of(SodiumExtraClientMod.MODID, "beacon_height");
    public static final Identifier ENCHANTING_BOOK = Identifier.of(SodiumExtraClientMod.MODID, "enchanting_book");
    public static final Identifier PISTON = Identifier.of(SodiumExtraClientMod.MODID, "piston");
    public static final Identifier ITEM_FRAME_NAME = Identifier.of(SodiumExtraClientMod.MODID, "item_frame_name");
    public static final Identifier PLAYER_NAME = Identifier.of(SodiumExtraClientMod.MODID, "player_name");

    public static final Identifier REDUCE_RESOLUTION = Identifier.of(SodiumExtraClientMod.MODID, "reduce_resolution");
    public static final Identifier OVERLAY_CORNER = Identifier.of(SodiumExtraClientMod.MODID, "overlay_corner");
    public static final Identifier TEXT_CONTRAST = Identifier.of(SodiumExtraClientMod.MODID, "text_contrast");
    public static final Identifier SHOW_FPS = Identifier.of(SodiumExtraClientMod.MODID, "show_fps");
    public static final Identifier FPS_EXT = Identifier.of(SodiumExtraClientMod.MODID, "fps_ext");
    public static final Identifier SHOW_COORDINATES = Identifier.of(SodiumExtraClientMod.MODID, "show_coordinates");
    public static final Identifier CLOUD_HEIGHT = Identifier.of(SodiumExtraClientMod.MODID, "cloud_height");
    public static final Identifier CLOUD_DISTANCE = Identifier.of(SodiumExtraClientMod.MODID, "cloud_distance");
    public static final Identifier ADVANCED_TOOLTIPS = Identifier.of("advanced_tooltips");
    public static final Identifier ALL_TOASTS = Identifier.of(SodiumExtraClientMod.MODID, "all_toasts");
    public static final Identifier ADVANCEMENT_TOASTS = Identifier.of(SodiumExtraClientMod.MODID, "advancement_toasts");
    public static final Identifier RECIPE_TOASTS = Identifier.of(SodiumExtraClientMod.MODID, "recipe_toasts");
    public static final Identifier SYSTEM_TOASTS = Identifier.of(SodiumExtraClientMod.MODID, "system_toasts");
    public static final Identifier TUTORIAL_TOASTS = Identifier.of(SodiumExtraClientMod.MODID, "tutorial_toasts");
    public static final Identifier SNEAK = Identifier.of(SodiumExtraClientMod.MODID, "sneak");
    public static final Identifier SHADERS = Identifier.of(SodiumExtraClientMod.MODID, "shaders");
    public static final Identifier DEBUG_HUD = Identifier.of(SodiumExtraClientMod.MODID, "debug_hud");
    public static final Identifier DEBUG_HUD_REFRESH = Identifier.of(SodiumExtraClientMod.MODID, "debug_hud_refresh");

    //Groups
    public static final Identifier ANIMATION_ALL = Identifier.of(SodiumExtraClientMod.MODID, "animation_all");
    public static final Identifier ANIMATION_OTHER = Identifier.of(SodiumExtraClientMod.MODID, "animation_other");

    public static final Identifier PARTICLES_ALL = Identifier.of(SodiumExtraClientMod.MODID, "particles_all");
    public static final Identifier PARTICLES_OTHER = Identifier.of(SodiumExtraClientMod.MODID, "particles_other");
    public static final Identifier PARTICLES_AUTO = Identifier.of(SodiumExtraClientMod.MODID, "particles_auto");

    public static final Identifier DETAIL_ALL = Identifier.of(SodiumExtraClientMod.MODID, "detail_all");

    public static final Identifier RENDER_FOG = Identifier.of(SodiumExtraClientMod.MODID, "render_fog");
    public static final Identifier RENDER_FOG_DIM = Identifier.of(SodiumExtraClientMod.MODID, "render_fog_dim");
    public static final Identifier RENDER_FOG_SINGLE = Identifier.of(SodiumExtraClientMod.MODID, "render_fog_single");
    public static final Identifier LIGHT = Identifier.of(SodiumExtraClientMod.MODID, "light");
    public static final Identifier STATIC_BLOCK_ENTITIES = Identifier.of(SodiumExtraClientMod.MODID, "static_block_entities");
    public static final Identifier DYNAMIC_BLOCK_ENTITIES = Identifier.of(SodiumExtraClientMod.MODID, "dynamic_block_entities");
    public static final Identifier NAME_TAGS = Identifier.of(SodiumExtraClientMod.MODID, "name_tags");
    public static final Identifier RESOLUTION = Identifier.of(SodiumExtraClientMod.MODID, "resolution");
    public static final Identifier OVERLAY = Identifier.of(SodiumExtraClientMod.MODID, "overlay");
    public static final Identifier TOOLTIPS = Identifier.of(SodiumExtraClientMod.MODID, "tooltips");
    public static final Identifier TOASTS = Identifier.of(SodiumExtraClientMod.MODID, "toasts");
    public static final Identifier VARIA = Identifier.of(SodiumExtraClientMod.MODID, "varia");
    public static final Identifier DEBUG = Identifier.of(SodiumExtraClientMod.MODID, "debug");

    //Pages
    public static final OptionIdentifier<Void> ANIMATION = OptionIdentifier.create(SodiumExtraClientMod.MODID, "animation");

    public static final OptionIdentifier<Void> PARTICLE = OptionIdentifier.create(SodiumExtraClientMod.MODID, "particle");
    public static final OptionIdentifier<Void> DETAIL = OptionIdentifier.create(SodiumExtraClientMod.MODID, "detail");
    public static final OptionIdentifier<Void> RENDER = OptionIdentifier.create(SodiumExtraClientMod.MODID, "render");
    public static final OptionIdentifier<Void> EXTRA = OptionIdentifier.create(SodiumExtraClientMod.MODID, "extra");

    private static Text parseVanillaString(String key) {
        return Text.literal((Text.translatable(key).getString()).replaceAll("§.", ""));
    }

    public static OptionPage animation() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(ALL_ANIMATIONS)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.animation").isEnabled())
                        .setName(parseVanillaString("gui.socialInteractions.tab_all"))
                        .setTooltip(Text.translatable("sodium-extra.option.animations_all.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.animation = value, opts -> opts.animationSettings.animation)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .setId(ANIMATION_ALL)
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(WATER)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.animation").isEnabled())
                        .setName(parseVanillaString("block.minecraft.water"))
                        .setTooltip(Text.translatable("sodium-extra.option.animate_water.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.water = value, opts -> opts.animationSettings.water)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(LAVA)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.animation").isEnabled())
                        .setName(parseVanillaString("block.minecraft.lava"))
                        .setTooltip(Text.translatable("sodium-extra.option.animate_lava.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.lava = value, opts -> opts.animationSettings.lava)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(FIRE)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.animation").isEnabled())
                        .setName(parseVanillaString("block.minecraft.fire"))
                        .setTooltip(Text.translatable("sodium-extra.option.animate_fire.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.fire = value, opts -> opts.animationSettings.fire)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(NETHER_PORTAL)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.animation").isEnabled())
                        .setName(parseVanillaString("block.minecraft.nether_portal"))
                        .setTooltip(Text.translatable("sodium-extra.option.animate_portal.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.portal = value, opts -> opts.animationSettings.portal)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(BLOCK_ANIMATION)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.animation").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.block_animations"))
                        .setTooltip(Text.translatable("sodium-extra.option.block_animations.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.animationSettings.blockAnimations = value, options -> options.animationSettings.blockAnimations)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(SCULK)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.animation").isEnabled())
                        .setName(parseVanillaString("block.minecraft.sculk_sensor"))
                        .setTooltip(Text.translatable("sodium-extra.option.animate_sculk_sensor.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.animationSettings.sculkSensor = value, options -> options.animationSettings.sculkSensor)
                        .setFlags(OptionFlag.REQUIRES_ASSET_RELOAD)
                        .build()
                )
                .setId(ANIMATION_OTHER)
                .build());
        return new OptionPage(ANIMATION, Text.translatable("sodium-extra.option.animations"), ImmutableList.copyOf(groups));
    }

    public static OptionPage particle() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(ALL_PARTICLES)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.particle").isEnabled())
                        .setName(parseVanillaString("gui.socialInteractions.tab_all"))
                        .setTooltip(Text.translatable("sodium-extra.option.particles_all.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.particles = value, opts -> opts.particleSettings.particles)
                        .build()
                )
                .setId(PARTICLES_ALL)
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(RAIN)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.particle").isEnabled())
                        .setName(parseVanillaString("subtitles.entity.generic.splash"))
                        .setTooltip(Text.translatable("sodium-extra.option.rain_splash.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.rainSplash = value, opts -> opts.particleSettings.rainSplash)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(BLOCK_BREAK)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.particle").isEnabled())
                        .setName(parseVanillaString("subtitles.block.generic.break"))
                        .setTooltip(Text.translatable("sodium-extra.option.block_break.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.blockBreak = value, opts -> opts.particleSettings.blockBreak)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(BLOCK_HIT)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.particle").isEnabled())
                        .setName(parseVanillaString("subtitles.block.generic.hit"))
                        .setTooltip(Text.translatable("sodium-extra.option.block_breaking.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.blockBreaking = value, opts -> opts.particleSettings.blockBreaking)
                        .build()
                )
                .setId(PARTICLES_OTHER)
                .build());

        Map<String, List<Identifier>> otherParticles = Registries.PARTICLE_TYPE.getIds().stream()
                .collect(Collectors.groupingBy(Identifier::getNamespace));
        otherParticles.forEach((namespace, identifiers) -> groups.add(identifiers.stream()
                .map(identifier -> OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(Identifier.of(SodiumExtraClientMod.MODID, identifier.getNamespace() + "_" + identifier.getPath()))
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.particle").isEnabled())
                        .setName(translatableName(identifier, "particles"))
                        .setTooltip(translatableTooltip(identifier, "particles"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, val) -> opts.particleSettings.otherMap.put(identifier, val),
                                opts -> opts.particleSettings.otherMap.getOrDefault(identifier, true))
                        .build())
                .sorted(Comparator.comparing(o -> o.getName().getString()))
                .collect(
                        OptionGroup::createBuilder,
                        OptionGroup.Builder::add,
                        (b1, b2) -> {
                        }
                )
                .setId(PARTICLES_AUTO)
                .build()
        ));

        return new OptionPage(PARTICLE, parseVanillaString("options.particles"), ImmutableList.copyOf(groups));
    }

    public static OptionPage detail() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(SKY)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.sky").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.sky"))
                        .setTooltip(Text.translatable("sodium-extra.option.sky.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.detailSettings.sky = value, opts -> opts.detailSettings.sky)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(STARS)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.stars").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.stars"))
                        .setTooltip(Text.translatable("sodium-extra.option.stars.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.detailSettings.stars = value, opts -> opts.detailSettings.stars)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(SUN_MOON)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.sun_moon").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.sun_moon"))
                        .setTooltip(Text.translatable("sodium-extra.option.sun_moon.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.detailSettings.sunMoon = value, opts -> opts.detailSettings.sunMoon)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(WEATHER)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.particle").isEnabled())
                        .setName(parseVanillaString("soundCategory.weather"))
                        .setTooltip(Text.translatable("sodium-extra.option.rain_snow.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.detailSettings.rainSnow = value, opts -> opts.detailSettings.rainSnow)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(BIOME)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.biome_colors").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.biome_colors"))
                        .setTooltip(Text.translatable("sodium-extra.option.biome_colors.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.detailSettings.biomeColors = value, options -> options.detailSettings.biomeColors)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(SKY_COLOR)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.sky_colors").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.sky_colors"))
                        .setTooltip(Text.translatable("sodium-extra.option.sky_colors.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.detailSettings.skyColors = value, options -> options.detailSettings.skyColors)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .setId(DETAIL_ALL)
                .build());
        return new OptionPage(DETAIL, Text.translatable("sodium-extra.option.details"), ImmutableList.copyOf(groups));
    }

    public static OptionPage render() {
        List<OptionGroup> groups = new ArrayList<>();

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(DIM_FOG_CONTROL)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.fog").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.multi_dimension_fog"))
                        .setTooltip(Text.translatable("sodium-extra.option.multi_dimension_fog.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.multiDimensionFogControl = value, options -> options.renderSettings.multiDimensionFogControl)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, sodiumExtraOpts)
                        .setId(FOG_START)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.fog_falloff").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.fog_start"))
                        .setTooltip(Text.translatable("sodium-extra.option.fog_start.tooltip"))
                        .setControl(option -> new SliderControlExtended(option, 20, 100, 1, ControlValueFormatter.percentage(), false))
                        .setBinding((options, value) -> options.renderSettings.fogStart = value, options -> options.renderSettings.fogStart)
                        .build()
                )
                .setId(RENDER_FOG)
                .build());

        if (SodiumExtraClientMod.options().renderSettings.multiDimensionFogControl) {
            DimensionOptionsRegistryHolder
                    .streamAll(Stream.empty())
                    .filter(dim -> !SodiumExtraClientMod.options().renderSettings.dimensionFogDistanceMap.containsKey(dim.getValue()))
                    .forEach(dim -> SodiumExtraClientMod.options().renderSettings.dimensionFogDistanceMap.put(dim.getValue(), 0));
            groups.add(SodiumExtraClientMod.options().renderSettings.dimensionFogDistanceMap.keySet().stream()
                    .map(identifier -> OptionImpl.createBuilder(int.class, sodiumExtraOpts)
                            .setId(Identifier.of(SodiumExtraClientMod.MODID, identifier.getNamespace() + "_" + identifier.getPath() + "_fog"))
                            .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.fog").isEnabled())
                            .setName(Text.translatable("sodium-extra.option.fog", translatableName(identifier, "dimensions").getString()))
                            .setTooltip(Text.translatable("sodium-extra.option.fog.tooltip"))
                            .setControl(option -> new SliderControlExtended(option, 0, 33, 1, ControlValueFormatterExtended.fogDistance(), false))
                            .setBinding((opts, val) -> opts.renderSettings.dimensionFogDistanceMap.put(identifier, val),
                                    opts -> opts.renderSettings.dimensionFogDistanceMap.getOrDefault(identifier, 0))
                            .build()
                    ).collect(
                            OptionGroup::createBuilder,
                            OptionGroup.Builder::add,
                            (b1, b2) -> {
                            }
                    )
                    .setId(RENDER_FOG_DIM)
                    .build()
            );
        } else {
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(int.class, sodiumExtraOpts)
                            .setId(FOG)
                            .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.fog").isEnabled())
                            .setName(Text.translatable("sodium-extra.option.single_fog"))
                            .setTooltip(Text.translatable("sodium-extra.option.single_fog.tooltip"))
                            .setControl(option -> new SliderControlExtended(option, 0, 33, 1, ControlValueFormatterExtended.fogDistance(), false))
                            .setBinding((options, value) -> options.renderSettings.fogDistance = value, options -> options.renderSettings.fogDistance)
                            .build()
                    )
                    .setId(RENDER_FOG_SINGLE)
                    .build());
        }

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(LIGHT_UPDATE)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.light_updates").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.light_updates"))
                        .setTooltip(Text.translatable("sodium-extra.option.light_updates.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.lightUpdates = value, options -> options.renderSettings.lightUpdates)
                        .build()
                )
                .setId(LIGHT)
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(ITEM_FRAME)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.render.entity").isEnabled())
                        .setName(parseVanillaString("entity.minecraft.item_frame"))
                        .setTooltip(Text.translatable("sodium-extra.option.item_frames.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderSettings.itemFrame = value, opts -> opts.renderSettings.itemFrame)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(ARMOR_STAND)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.render.entity").isEnabled())
                        .setName(parseVanillaString("entity.minecraft.armor_stand"))
                        .setTooltip(Text.translatable("sodium-extra.option.armor_stands.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.armorStand = value, options -> options.renderSettings.armorStand)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(PAINTING)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.render.entity").isEnabled())
                        .setName(parseVanillaString("entity.minecraft.painting"))
                        .setTooltip(Text.translatable("sodium-extra.option.paintings.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.painting = value, options -> options.renderSettings.painting)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .setId(STATIC_BLOCK_ENTITIES)
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(BEACON_BEAM)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.render.block.entity").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.beacon_beam"))
                        .setTooltip(Text.translatable("sodium-extra.option.beacon_beam.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderSettings.beaconBeam = value, opts -> opts.renderSettings.beaconBeam)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(BEACON_HEIGHT)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.render.block.entity").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.limit_beacon_beam_height"))
                        .setTooltip(Text.translatable("sodium-extra.option.limit_beacon_beam_height.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderSettings.limitBeaconBeamHeight = value, opts -> opts.renderSettings.limitBeaconBeamHeight)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(ENCHANTING_BOOK)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.render.block.entity").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.enchanting_table_book"))
                        .setTooltip(Text.translatable("sodium-extra.option.enchanting_table_book.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderSettings.enchantingTableBook = value, opts -> opts.renderSettings.enchantingTableBook)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(PISTON)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.render.block.entity").isEnabled())
                        .setName(parseVanillaString("block.minecraft.piston"))
                        .setTooltip(Text.translatable("sodium-extra.option.piston.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.piston = value, options -> options.renderSettings.piston)
                        .build()
                )
                .setId(DYNAMIC_BLOCK_ENTITIES)
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(ITEM_FRAME_NAME)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.render.entity").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.item_frame_name_tag"))
                        .setTooltip(Text.translatable("sodium-extra.option.item_frame_name_tag.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderSettings.itemFrameNameTag = value, opts -> opts.renderSettings.itemFrameNameTag)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(PLAYER_NAME)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.render.entity").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.player_name_tag"))
                        .setTooltip(Text.translatable("sodium-extra.option.player_name_tag.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.playerNameTag = value, options -> options.renderSettings.playerNameTag)
                        .build()
                )
                .setId(NAME_TAGS)
                .build());
        return new OptionPage(RENDER, Text.translatable("sodium-extra.option.render"), ImmutableList.copyOf(groups));
    }

    public static OptionPage extra() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(REDUCE_RESOLUTION)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.reduce_resolution_on_mac").isEnabled() && MinecraftClient.IS_SYSTEM_MAC)
                        .setName(Text.translatable("sodium-extra.option.reduce_resolution_on_mac"))
                        .setTooltip(Text.translatable("sodium-extra.option.reduce_resolution_on_mac.tooltip"))
                        .setEnabled(MinecraftClient.IS_SYSTEM_MAC)
                        .setImpact(OptionImpact.HIGH)
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.extraSettings.reduceResolutionOnMac = value, opts -> opts.extraSettings.reduceResolutionOnMac)
                        .build()
                )
                .setId(RESOLUTION)
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(SodiumExtraGameOptions.OverlayCorner.class, sodiumExtraOpts)
                        .setId(OVERLAY_CORNER)
                        .setName(Text.translatable("sodium-extra.option.overlay_corner"))
                        .setTooltip(Text.translatable("sodium-extra.option.overlay_corner.tooltip"))
                        .setControl(option -> new CyclingControl<>(option, SodiumExtraGameOptions.OverlayCorner.class))
                        .setBinding((opts, value) -> opts.extraSettings.overlayCorner = value, opts -> opts.extraSettings.overlayCorner)
                        .build()
                )
                .add(OptionImpl.createBuilder(SodiumExtraGameOptions.TextContrast.class, sodiumExtraOpts)
                        .setId(TEXT_CONTRAST)
                        .setName(Text.translatable("sodium-extra.option.text_contrast"))
                        .setTooltip(Text.translatable("sodium-extra.option.text_contrast.tooltip"))
                        .setControl(option -> new CyclingControl<>(option, SodiumExtraGameOptions.TextContrast.class))
                        .setBinding((opts, value) -> opts.extraSettings.textContrast = value, opts -> opts.extraSettings.textContrast)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(SHOW_FPS)
                        .setName(Text.translatable("sodium-extra.option.show_fps"))
                        .setTooltip(Text.translatable("sodium-extra.option.show_fps.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.extraSettings.showFps = value, opts -> opts.extraSettings.showFps)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(FPS_EXT)
                        .setName(Text.translatable("sodium-extra.option.show_fps_extended"))
                        .setTooltip(Text.translatable("sodium-extra.option.show_fps_extended.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.extraSettings.showFPSExtended = value, opts -> opts.extraSettings.showFPSExtended)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(SHOW_COORDINATES)
                        .setName(Text.translatable("sodium-extra.option.show_coordinates"))
                        .setTooltip(Text.translatable("sodium-extra.option.show_coordinates.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.extraSettings.showCoords = value, opts -> opts.extraSettings.showCoords)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, sodiumExtraOpts)
                        .setId(CLOUD_HEIGHT)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.cloud").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.cloud_height"))
                        .setTooltip(Text.translatable("sodium-extra.option.cloud_height.tooltip"))
                        .setControl(option -> new SliderControl(option, -64, 319, 1, ControlValueFormatter.number()))
                        .setBinding((options, value) -> options.extraSettings.cloudHeight = value, options -> options.extraSettings.cloudHeight)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, sodiumExtraOpts)
                        .setId(CLOUD_DISTANCE)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.sodium.cloud").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.cloud_distance"))
                        .setTooltip(Text.translatable("sodium-extra.option.cloud_distance.tooltip"))
                        .setControl(option -> new SliderControl(option, 100, 300, 10, ControlValueFormatter.percentage()))
                        .setBinding((options, value) -> options.extraSettings.cloudDistance = value, options -> options.extraSettings.cloudDistance)
                        .build()
                )
                .setId(OVERLAY)
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, vanillaOpts)
                        .setId(ADVANCED_TOOLTIPS)
                        .setName(Text.translatable("sodium-extra.option.advanced_item_tooltips"))
                        .setTooltip(Text.translatable("sodium-extra.option.advanced_item_tooltips.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.advancedItemTooltips = value, opts -> opts.advancedItemTooltips)
                        .build()
                )
                .setId(TOOLTIPS)
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(ALL_TOASTS)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.toasts").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.toasts"))
                        .setTooltip(Text.translatable("sodium-extra.option.toasts.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.toasts = value, options -> options.extraSettings.toasts)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(ADVANCEMENT_TOASTS)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.toasts").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.advancement_toast"))
                        .setTooltip(Text.translatable("sodium-extra.option.advancement_toast.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.advancementToast = value, options -> options.extraSettings.advancementToast)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(RECIPE_TOASTS)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.toasts").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.recipe_toast"))
                        .setTooltip(Text.translatable("sodium-extra.option.recipe_toast.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.recipeToast = value, options -> options.extraSettings.recipeToast)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(SYSTEM_TOASTS)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.toasts").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.system_toast"))
                        .setTooltip(Text.translatable("sodium-extra.option.system_toast.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.systemToast = value, options -> options.extraSettings.systemToast)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(TUTORIAL_TOASTS)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.toasts").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.tutorial_toast"))
                        .setTooltip(Text.translatable("sodium-extra.option.tutorial_toast.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.tutorialToast = value, options -> options.extraSettings.tutorialToast)
                        .build()
                )
                .setId(TOASTS)
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(SNEAK)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.instant_sneak").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.instant_sneak"))
                        .setTooltip(Text.translatable("sodium-extra.option.instant_sneak.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.instantSneak = value, options -> options.extraSettings.instantSneak)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(SHADERS)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.prevent_shaders").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.prevent_shaders"))
                        .setTooltip(Text.translatable("sodium-extra.option.prevent_shaders.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.preventShaders = value, options -> options.extraSettings.preventShaders)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .setId(VARIA)
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setId(DEBUG_HUD)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.steady_debug_hud").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.steady_debug_hud"))
                        .setTooltip(Text.translatable("sodium-extra.option.steady_debug_hud.tooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.steadyDebugHud = value, options -> options.extraSettings.steadyDebugHud)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, sodiumExtraOpts)
                        .setId(DEBUG_HUD_REFRESH)
                        .setEnabled(SodiumExtraClientMod.mixinConfig().getOptions().get("mixin.steady_debug_hud").isEnabled())
                        .setName(Text.translatable("sodium-extra.option.steady_debug_hud_refresh_interval"))
                        .setTooltip(Text.translatable("sodium-extra.option.steady_debug_hud_refresh_interval.tooltip"))
                        .setControl(option -> new SliderControlExtended(option, 1, 20, 1, ControlValueFormatterExtended.ticks(), false))
                        .setBinding((options, value) -> options.extraSettings.steadyDebugHudRefreshInterval = value, options -> options.extraSettings.steadyDebugHudRefreshInterval)
                        .build()
                )
                .setId(DEBUG)
                .build());

        return new OptionPage(EXTRA, Text.translatable("sodium-extra.option.extras"), ImmutableList.copyOf(groups));
    }

    private static Text translatableName(Identifier identifier, String category) {
        String key = identifier.toTranslationKey("options.".concat(category));

        Text translatable = Text.translatable(key);
        if (!Texts.hasTranslation(translatable)) {
            translatable = Text.literal(
                    Arrays.stream(key.substring(key.lastIndexOf('.') + 1).split("_"))
                            .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                            .collect(Collectors.joining(" "))
            );
        }
        return translatable;
    }

    private static Text translatableTooltip(Identifier identifier, String category) {
        String key = identifier.toTranslationKey("options.".concat(category)).concat(".tooltip");

        Text translatable = Text.translatable(key);
        if (!Texts.hasTranslation(translatable)) {
            translatable = Text.translatable(
                    "sodium-extra.option.".concat(category).concat(".tooltips"),
                    translatableName(identifier, category)
            );
        }
        return translatable;
    }

    @SubscribeEvent
    public static void registerPages(OptionGUIConstructionEvent event){
        event.addPage(animation());
        event.addPage(particle());
        event.addPage(detail());
        event.addPage(render());
        event.addPage(extra());
    }
}

package me.flashyreese.mods.sodiumextra.client.render.vertex.formats;

import net.minecraft.client.render.VertexFormats;
import org.embeddedt.embeddium.api.vertex.attributes.common.ColorAttribute;
import org.embeddedt.embeddium.api.vertex.attributes.common.LightAttribute;
import org.embeddedt.embeddium.api.vertex.attributes.common.PositionAttribute;
import org.embeddedt.embeddium.api.vertex.attributes.common.TextureAttribute;
import org.embeddedt.embeddium.api.vertex.format.VertexFormatDescription;
import org.embeddedt.embeddium.api.vertex.format.VertexFormatRegistry;
import org.lwjgl.system.MemoryUtil;

public final class WeatherVertex {
    public static final VertexFormatDescription FORMAT = VertexFormatRegistry.instance().get(VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
    public static final int STRIDE = 28;
    private static final int OFFSET_POSITION = 0;
    private static final int OFFSET_TEXTURE = 12;
    private static final int OFFSET_COLOR = 20;
    private static final int OFFSET_LIGHT = 24;

    public static void put(long ptr, float x, float y, float z, float u, float v, int color, int light) {
        PositionAttribute.put(ptr + OFFSET_POSITION, x, y, z);
        TextureAttribute.put(ptr + OFFSET_TEXTURE, u, v);
        ColorAttribute.set(ptr + OFFSET_COLOR, color);
        LightAttribute.set(ptr + OFFSET_LIGHT, light);
    }

    public static void put(long ptr, float x, float y, float z, float u, float v, int color, int lightU, int lightV) {
        PositionAttribute.put(ptr + OFFSET_POSITION, x, y, z);
        TextureAttribute.put(ptr + OFFSET_TEXTURE, u, v);
        ColorAttribute.set(ptr + OFFSET_COLOR, color);
        MemoryUtil.memPutShort(ptr + OFFSET_LIGHT, (short) lightU);
        MemoryUtil.memPutShort(ptr + OFFSET_LIGHT + 2, (short) lightV);
    }
}

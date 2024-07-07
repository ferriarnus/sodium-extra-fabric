package me.flashyreese.mods.sodiumextra.client.gui.options.control;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import org.apache.commons.lang3.Validate;
import org.embeddedt.embeddium.api.math.Dim2i;
import org.embeddedt.embeddium.api.options.control.Control;
import org.embeddedt.embeddium.api.options.control.ControlElement;
import org.embeddedt.embeddium.api.options.control.ControlValueFormatter;
import org.embeddedt.embeddium.api.options.structure.Option;

public class SliderControlExtended implements Control<Integer> {
    private final Option<Integer> option;

    private final int min, max, interval;

    private final ControlValueFormatter mode;

    private final boolean displayIntValueWhileSliding;

    public SliderControlExtended(Option<Integer> option, int min, int max, int interval, ControlValueFormatter mode, boolean displayIntValueWhileSliding) {
        Validate.isTrue(max > min, "The maximum value must be greater than the minimum value");
        Validate.isTrue(interval > 0, "The slider interval must be greater than zero");
        Validate.isTrue(((max - min) % interval) == 0, "The maximum value must be divisable by the interval");
        Validate.notNull(mode, "The slider mode must not be null");

        this.option = option;
        this.min = min;
        this.max = max;
        this.interval = interval;
        this.mode = mode;
        this.displayIntValueWhileSliding = displayIntValueWhileSliding;
    }

    @Override
    public ControlElement<Integer> createElement(Dim2i dim) {
        return new Slider(this.option, dim, this.min, this.max, this.interval, this.mode, this.displayIntValueWhileSliding);
    }

    @Override
    public Option<Integer> getOption() {
        return this.option;
    }

    @Override
    public int getMaxWidth() {
        return 130;
    }

    private static class Slider extends ControlElement<Integer> {
        private static final int THUMB_WIDTH = 2, TRACK_HEIGHT = 1;

        private final ControlValueFormatter formatter;
        private final boolean displayIntValueWhileSliding;

        private final int min;
        private final int range;
        private final int interval;

        private double thumbPosition;

        public Slider(Option<Integer> option, Dim2i dim, int min, int max, int interval, ControlValueFormatter formatter, boolean displayIntValueWhileSliding) {
            super(option, dim);

            this.min = min;
            this.range = max - min;
            this.interval = interval;
            this.thumbPosition = this.getThumbPositionForValue(option.getValue());
            this.formatter = formatter;
            this.displayIntValueWhileSliding = displayIntValueWhileSliding;
        }

        public Dim2i getSliderBounds() {
            return new Dim2i(dim.getLimitX() - 96, dim.getCenterY() - 5, 90, 10);
        }

        @Override
        public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
            super.render(drawContext, mouseX, mouseY, delta);

            if (this.option.isAvailable() && this.hovered) {
                this.renderSlider(drawContext);
            } else {
                this.renderStandaloneValue(drawContext);
            }
        }

        private void renderStandaloneValue(DrawContext drawContext) {
            int sliderX = this.getSliderBounds().x();
            int sliderY = this.getSliderBounds().y();
            int sliderWidth = this.getSliderBounds().width();
            int sliderHeight = this.getSliderBounds().height();

            Text label = this.formatter.format(this.option.getValue());
            int labelWidth = this.font.getWidth(label);

            this.drawString(drawContext, label, sliderX + sliderWidth - labelWidth, sliderY + (sliderHeight / 2) - 4, 0xFFFFFFFF);
        }

        private void renderSlider(DrawContext drawContext) {
            int sliderX = this.getSliderBounds().x();
            int sliderY = this.getSliderBounds().y();
            int sliderWidth = this.getSliderBounds().width();
            int sliderHeight = this.getSliderBounds().height();

            this.thumbPosition = this.getThumbPositionForValue(option.getValue());

            double thumbOffset = MathHelper.clamp((double) (this.getIntValue() - this.min) / this.range * sliderWidth, 0, sliderWidth);

            double thumbX = sliderX + thumbOffset - THUMB_WIDTH;
            double trackY = sliderY + (sliderHeight / 2) - ((double) TRACK_HEIGHT / 2);

            this.drawRect(drawContext, (int) thumbX, sliderY, (int) (thumbX + (THUMB_WIDTH * 2)), sliderY + sliderHeight, 0xFFFFFFFF);
            this.drawRect(drawContext, sliderX, (int) trackY, sliderX + sliderWidth, (int) (trackY + TRACK_HEIGHT), 0xFFFFFFFF);

            Text label = this.displayIntValueWhileSliding ? Text.of(String.valueOf(this.getIntValue())) : this.formatter.format(this.option.getValue());

            int labelWidth = this.font.getWidth(label);

            this.drawString(drawContext, label, sliderX - labelWidth - 6, sliderY + (sliderHeight / 2) - 4, 0xFFFFFFFF);
        }

        public int getIntValue() {
            return this.min + (this.interval * (int) Math.round(this.getSnappedThumbPosition() / this.interval));
        }

        public double getSnappedThumbPosition() {
            return this.thumbPosition / (1.0D / this.range);
        }

        public double getThumbPositionForValue(int value) {
            return (value - this.min) * (1.0D / this.range);
        }

        @Override
        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            if (this.option.isAvailable() && button == 0 && this.getSliderBounds().containsCursor(mouseX, mouseY)) {
                this.setValueFromMouse(mouseX);

                return true;
            }

            return false;
        }

        private void setValueFromMouse(double d) {
            this.setValue((d - (double) this.getSliderBounds().x()) / (double) this.getSliderBounds().width());
        }

        private void setValue(double d) {
            this.thumbPosition = MathHelper.clamp(d, 0.0D, 1.0D);

            int value = this.getIntValue();

            if (this.option.getValue() != value) {
                this.option.setValue(value);
            }
        }

        @Override
        public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
            if (this.option.isAvailable() && button == 0) {
                this.setValueFromMouse(mouseX);

                return true;
            }

            return false;
        }
    }

}

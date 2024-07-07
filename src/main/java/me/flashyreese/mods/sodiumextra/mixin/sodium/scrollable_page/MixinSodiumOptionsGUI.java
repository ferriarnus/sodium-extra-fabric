//package me.flashyreese.mods.sodiumextra.mixin.sodium.scrollable_page;
//
//import me.flashyreese.mods.sodiumextra.client.gui.scrollable_page.OptionPageScrollFrame;
//import net.minecraft.client.gui.DrawContext;
//import net.minecraft.client.gui.screen.Screen;
//import net.minecraft.text.Text;
//import org.embeddedt.embeddium.api.math.Dim2i;
//import org.embeddedt.embeddium.api.options.control.ControlElement;
//import org.embeddedt.embeddium.api.options.structure.OptionPage;
//import org.jetbrains.annotations.Nullable;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(value = SodiumOptionsGUI.class, remap = false)
//public abstract class MixinSodiumOptionsGUI extends Screen {
//
//    @Shadow
//    private OptionPage currentPage;
//
//    @Shadow
//    private @Nullable ScreenPrompt prompt;
//
//    protected MixinSodiumOptionsGUI(Text title) {
//        super(title);
//    }
//
//    @Inject(method = "rebuildGUIOptions", at = @At(value = "HEAD"), cancellable = true)
//    private void rebuildGUIOptions(CallbackInfo ci) {
//        int x = 6;
//        int y = 28;
//
//        OptionPageScrollFrame optionPageScrollFrame = new OptionPageScrollFrame(new Dim2i(x, y, /*this.width - x * 2*/200, this.height - y - 10 /*- 64*/), this.currentPage);
//        this.addDrawableChild(optionPageScrollFrame);
//        ci.cancel();
//    }
//
//    @Inject(method = "renderOptionTooltip", at = @At(value = "HEAD"), cancellable = true)
//    private void renderOptionTooltip(DrawContext drawContext, ControlElement<?> element, CallbackInfo ci) {
//        ci.cancel();
//    }
//
//    // Fixme:
//    // Fixes issue introduce with Sodium 20006a85fb7a64889f507eb13521e55693ae0d7e
//    // This override prevents focused element from staying focused because we are using a ParentElement for scroll frames
//    @Override
//    public boolean mouseClicked(double mouseX, double mouseY, int button) {
//        if (this.prompt != null) {
//            return this.prompt.mouseClicked(mouseX, mouseY, button);
//        }
//        return super.mouseClicked(mouseX, mouseY, button);
//    }
//}

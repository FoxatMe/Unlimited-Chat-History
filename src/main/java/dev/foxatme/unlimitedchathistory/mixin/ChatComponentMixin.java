package dev.foxatme.unlimitedchathistory.mixin;

import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ChatComponent.class)
public class ChatComponentMixin {

    private static final int CHAT_LIMIT = 1 << 15;

    @ModifyConstant(
            method = "<init>",
            constant = @Constant(intValue = 100)
    )
    private int modifyConstructorLimit(int constant) {
        return CHAT_LIMIT;
    }

    @ModifyConstant(
            method = {
                    "addMessageToDisplayQueue",
                    "addMessageToQueue",
                    "addRecentChat"
            },
            constant = @Constant(intValue = 100)
    )
    private int modifyChatLimit(int constant) {
        return CHAT_LIMIT;
    }
}
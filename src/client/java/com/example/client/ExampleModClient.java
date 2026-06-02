package com.example.client;[cite: 10]

import net.fabricmc.api.ClientModInitializer;[cite: 10]
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;[cite: 10]
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;[cite: 10]
import net.minecraft.client.MinecraftClient;[cite: 10]
import net.minecraft.client.font.TextRenderer;[cite: 10]
import net.minecraft.text.Text;[cite: 10]

public class ExampleModClient implements ClientModInitializer {[cite: 10]
    private static int ticksActive = 0;[cite: 10]
    private static boolean wasInWorld = false;[cite: 10]

    @Override
    public void onInitializeClient() {[cite: 10]
        // عداد يحسب الوقت بدقة طالما أنت داخل العالم واللعبة مش متوقفة
        ClientTickEvents.END_CLIENT_TICK.register(client -> {[cite: 10]
            if (client.world != null && !client.isPaused()) {[cite: 10]
                if (!wasInWorld) {[cite: 10]
                    wasInWorld = true;[cite: 10]
                    ticksActive = 0; [cite: 10]
                }[cite: 10]
                ticksActive++;[cite: 10]
            } else if (client.world == null) {[cite: 10]
                wasInWorld = false;[cite: 10]
            }[cite: 10]
        });[cite: 10]

        // رسم الوقت الصافي فقط على الشاشة
        HudRenderCallback.EVENT.register((drawContext, tickCounter) -> {[cite: 10]
            MinecraftClient client = MinecraftClient.getInstance();[cite: 10]
            if (client.world == null) return;[cite: 10]

            TextRenderer textRenderer = client.textRenderer;[cite: 10]
            
            int totalSeconds = ticksActive / 20;[cite: 10]
            int hours = totalSeconds / 3600;[cite: 10]
            int minutes = (totalSeconds % 3600) / 60;[cite: 10]
            int seconds = totalSeconds % 60;[cite: 10]

            // يعرض الوقت فقط كأرقام نقية مثل (00:00:00) أعلى الشاشة
            String timeDisplay = String.format("%02d:%02d:%02d", hours, minutes, seconds);[cite: 10]
            
            // رسم النص في أعلى اليسار بلون أبيض واضح وظل خلفي
            drawContext.drawText(textRenderer, Text.literal(timeDisplay), 10, 10, 0xFFFFFF, true);[cite: 10]
        });[cite: 10]
    }[cite: 10]
}[cite: 10]

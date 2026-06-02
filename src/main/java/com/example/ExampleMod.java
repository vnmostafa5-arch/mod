package com.example;[cite: 14]

import net.fabricmc.api.ModInitializer;[cite: 14]
import org.slf4j.Logger;[cite: 14]
import org.slf4j.LoggerFactory;[cite: 14]

public class ExampleMod implements ModInitializer {[cite: 14]
    public static final String MOD_ID = "worldtimer";[cite: 14]
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);[cite: 14]

    @Override
    public void onInitialize() {[cite: 14]
        LOGGER.info("World Timer Mod has been successfully initialized!");[cite: 14]
    }[cite: 14]
}[cite: 14]

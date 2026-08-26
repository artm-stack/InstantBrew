    package artm.instantbrew.client;

    import artm.instantbrew.InstantBrew;
    import artm.instantbrew.config.InstantBrewConfig;
    import me.shedaniel.clothconfig2.api.ConfigBuilder;
    import me.shedaniel.clothconfig2.api.ConfigCategory;
    import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
    import net.minecraft.client.gui.screens.Screen;
    import net.minecraft.network.chat.Component;

    public class InstantBrewConfigScreen {

        public static Screen createScreen(Screen parent) {
            InstantBrewConfig config = InstantBrew.CONFIG;

            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Component.literal("InstantBrew Config"));

            ConfigCategory general = builder.getOrCreateCategory(Component.literal("General"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            // Enabled toggle
            general.addEntry(entryBuilder.startBooleanToggle(Component.literal("Enabled"), config.enabled)
                    .setDefaultValue(true)
                    .setSaveConsumer(newValue -> config.enabled = newValue)
                    .build()
            );

            // Brew Time input field (1–400 ticks)
            general.addEntry(entryBuilder.startIntField(Component.literal("Brew Time (ticks)"), config.brewTime)
                    .setDefaultValue(20)
                    .setMin(1)
                    .setMax(400)
                    .setSaveConsumer(newValue -> config.brewTime = newValue)
                    .build()
            );
            // Save handler – writes the config file and reloads it in memory
            builder.setSavingRunnable(() -> {
                config.save(InstantBrewConfig.getConfigPath());
                InstantBrew.CONFIG = InstantBrewConfig.load(InstantBrewConfig.getConfigPath());
            });

            return builder.build();
        }
    }
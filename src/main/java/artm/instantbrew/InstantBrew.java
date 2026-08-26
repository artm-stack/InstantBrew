package artm.instantbrew;

import artm.instantbrew.config.InstantBrewConfig;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class InstantBrew implements ModInitializer {
	public static final String MOD_ID = "instantbrew";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static InstantBrewConfig CONFIG;

	@Override
	public void onInitialize() {
		Path configPath = FabricLoader.getInstance()
				.getConfigDir()
				.resolve(MOD_ID + ".json");

		CONFIG = InstantBrewConfig.load(configPath);

		String version = FabricLoader.getInstance()
				.getModContainer(MOD_ID)
				.orElseThrow()
				.getMetadata()
				.getVersion()
				.getFriendlyString();

		LOGGER.info(
				"Initialized {} v{} | Enabled: {} | Brew Time: {} ticks",
				MOD_ID,
				version,
				CONFIG.enabled,
				CONFIG.brewTime
		);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}

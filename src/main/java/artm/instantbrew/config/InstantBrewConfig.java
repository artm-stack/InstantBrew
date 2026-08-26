package artm.instantbrew.config;

import artm.instantbrew.InstantBrew;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InstantBrewConfig {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public boolean enabled = true;
    public int brewTime = 20;

    public static Path getConfigPath() {
        return FabricLoader.getInstance().getConfigDir().resolve(InstantBrew.MOD_ID + ".json");
    }

    public static InstantBrewConfig load(Path configPath) {
        try {
            if (!Files.exists(configPath)) {
                InstantBrewConfig config = new InstantBrewConfig();
                config.save(configPath);
                return config;
            }

            String json = Files.readString(configPath);
            InstantBrewConfig config = GSON.fromJson(json, InstantBrewConfig.class);

            if (config == null) {
                config = new InstantBrewConfig();
            }

            if (config.brewTime < 1) {
                config.brewTime = 1;
            }

            return config;

        } catch (IOException | RuntimeException e) {
            return new InstantBrewConfig();
        }
    }

    public void save(Path configPath) {
        try {
            Files.createDirectories(configPath.getParent());
            Files.writeString(configPath, GSON.toJson(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
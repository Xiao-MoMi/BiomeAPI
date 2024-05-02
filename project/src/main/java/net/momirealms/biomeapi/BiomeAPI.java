package net.momirealms.biomeapi;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public class BiomeAPI {

    /**
     * The biome would be null if the server version is not supported
     *
     * @param location location
     * @return biome
     */
    @Nullable
    public static String getBiomeAt(Location location) {
        return SingletonHolder.INSTANCE.getBiomeAt(location);
    }

    private static class SingletonHolder {
        private static final CustomBiome INSTANCE = init();

        private static CustomBiome init() {
            String bukkitVersion = Bukkit.getServer().getBukkitVersion().split("-")[0];
            switch (bukkitVersion + (isMojMap() ? "-Mojmap" : "")) {
                case "1.20.5", "1.20.6" -> {
                    return new CustomBiome1_20_R4();
                }
                case "1.20.3", "1.20.4" -> {
                    return new CustomBiome1_20_R3();
                }
                case "1.20.2" -> {
                    return new CustomBiome1_20_R2();
                }
                case "1.20", "1.20.1" -> {
                    return new CustomBiome1_20_R1();
                }
                case "1.19.4" -> {
                    return new CustomBiome1_19_R3();
                }
                case "1.19.3" -> {
                    return new CustomBiome1_19_R2();
                }
                case "1.19", "1.19.1", "1.19.2" -> {
                    return new CustomBiome1_19_R1();
                }
                case "1.18.2" -> {
                    return new CustomBiome1_18_R2();
                }
                case "1.18", "1.18.1" -> {
                    return new CustomBiome1_18_R1();
                }
                case "1.17", "1.17.1" -> {
                    return new CustomBiome1_17_R1();
                }
                case "1.20.5-Mojmap", "1.20.6-Mojmap" -> {
                    return new CustomBiomeMojMapR1();
                }
                case "1.20.3-Mojmap", "1.20.4-Mojmap" -> {
                    return new CustomBiome1_20_R3_Mojmap();
                }
                case "1.20.2-Mojmap" -> {
                    return new CustomBiome1_20_R2_Mojmap();
                }
                case "1.20-Mojmap", "1.20.1-Mojmap" -> {
                    return new CustomBiome1_20_R1_Mojmap();
                }
                case "1.19.4-Mojmap" -> {
                    return new CustomBiome1_19_R3_Mojmap();
                }
                case "1.19.3-Mojmap" -> {
                    return new CustomBiome1_19_R2_Mojmap();
                }
                case "1.19-Mojmap", "1.19.1-Mojmap", "1.19.2-Mojmap" -> {
                    return new CustomBiome1_19_R1_Mojmap();
                }
                case "1.18.2-Mojmap" -> {
                    return new CustomBiome1_18_R2_Mojmap();
                }
                case "1.18-Mojmap", "1.18.1-Mojmap" -> {
                    return new CustomBiome1_18_R1_Mojmap();
                }
                default -> throw new UnsupportedVersionException(bukkitVersion + (isMojMap() ? "-Mojmap" : ""));
            }
        }

        private static boolean isMojMap() {
            try {
                Class.forName("net.minecraft.world.level.biome.Biome");
                return true;
            } catch (ClassNotFoundException ignore) {
                return false;
            }
        }
    }
}

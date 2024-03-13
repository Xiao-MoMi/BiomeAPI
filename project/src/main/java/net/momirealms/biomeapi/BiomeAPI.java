package net.momirealms.biomeapi;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public class BiomeAPI {

    private static BiomeAPI api;
    private CustomBiome customBiome;

    /**
     * The biome would be null if the server version is not supported
     *
     * @param location location
     * @return biome
     */
    @Nullable
    public static String getBiomeAt(Location location) {
        if (api == null) api = new BiomeAPI();
        return api.getBiome(location);
    }

    public String getBiome(Location location) {
        if (customBiome == null)
            init();
        return customBiome.getBiomeAt(location);
    }

    private void init() {
        switch (Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + (isMojMap() ? "_Mojmap" : "")) {
            case "v1_20_R3" -> this.customBiome = new CustomBiome1_20_R3();
            case "v1_20_R2" -> this.customBiome = new CustomBiome1_20_R2();
            case "v1_20_R1" -> this.customBiome = new CustomBiome1_20_R1();
            case "v1_19_R3" -> this.customBiome = new CustomBiome1_19_R3();
            case "v1_19_R2" -> this.customBiome = new CustomBiome1_19_R2();
            case "v1_19_R1" -> this.customBiome = new CustomBiome1_19_R1();
            case "v1_18_R2" -> this.customBiome = new CustomBiome1_18_R2();
            case "v1_18_R1" -> this.customBiome = new CustomBiome1_18_R1();
            case "v1_17_R1" -> this.customBiome = new CustomBiome1_17_R1();
            case "v1_20_R3_Mojmap" -> this.customBiome = new CustomBiome1_20_R3_Mojmap();
            case "v1_20_R2_Mojmap" -> this.customBiome = new CustomBiome1_20_R2_Mojmap();
            case "v1_20_R1_Mojmap" -> this.customBiome = new CustomBiome1_20_R1_Mojmap();
            case "v1_19_R3_Mojmap" -> this.customBiome = new CustomBiome1_19_R3_Mojmap();
            case "v1_19_R2_Mojmap" -> this.customBiome = new CustomBiome1_19_R2_Mojmap();
            case "v1_19_R1_Mojmap" -> this.customBiome = new CustomBiome1_19_R1_Mojmap();
            case "v1_18_R2_Mojmap" -> this.customBiome = new CustomBiome1_18_R2_Mojmap();
            case "v1_18_R1_Mojmap" -> this.customBiome = new CustomBiome1_18_R1_Mojmap();
            default -> throw new UnsupportedVersionException();
        }
    }

    private boolean isMojMap() {
        try {
            Class.forName("net.minecraft.world.level.biome.BiomeBase");
            return false;
        } catch (ClassNotFoundException ignore) {
            return true;
        }
    }
}

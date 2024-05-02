package net.momirealms.biomeapi;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.world.level.biome.Biome;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.CraftWorld;

public class CustomBiome1_20_R4 extends CustomBiome {

    private final DedicatedServer dedicatedServer = ((CraftServer) Bukkit.getServer()).getServer();
    private final Registry<Biome> registry = dedicatedServer.registries().compositeAccess().registryOrThrow(Registries.BIOME);

    @Override
    public String getBiomeAt(Location location) {
        Biome biome = ((CraftWorld) location.getWorld()).getHandle().getNoiseBiome(location.getBlockX() >> 2, location.getBlockY() >> 2, location.getBlockZ() >> 2).value();
        ResourceLocation minecraftKey = registry.getKey(biome);
        if (minecraftKey == null) {
            return "void";
        }
        return minecraftKey.toString();
    }
}

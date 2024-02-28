package net.momirealms.biomeapi;

import net.minecraft.core.IRegistry;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.world.level.biome.BiomeBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftServer;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;

public class CustomBiome1_17_R1 extends CustomBiome {

    private final DedicatedServer dedicatedServer = ((CraftServer) Bukkit.getServer()).getServer();
    private final IRegistry<BiomeBase> registry = this.dedicatedServer.getCustomRegistry().d(IRegistry.aO);

    @Override
    public String getBiomeAt(Location location) {
        BiomeBase biomeBase = ((CraftWorld) location.getWorld()).getHandle().getBiome(location.getBlockX() >> 2, location.getBlockY() >> 2, location.getBlockZ() >> 2);
        MinecraftKey minecraftKey = registry.getKey(biomeBase);
        if (minecraftKey == null) {
            return "void";
        }
        return minecraftKey.toString();
    }
}

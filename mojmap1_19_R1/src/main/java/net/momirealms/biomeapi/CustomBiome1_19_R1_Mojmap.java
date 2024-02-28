package net.momirealms.biomeapi;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.world.level.biome.Biome;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;

public class CustomBiome1_19_R1_Mojmap extends CustomBiome {

    private final DedicatedServer dedicatedServer = ((CraftServer) Bukkit.getServer()).getServer();
    private final Registry<Biome> registry = dedicatedServer.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY);

    @Override
    public String getBiomeAt(Location location) {
        Biome biome = ((CraftWorld) location.getWorld()).getHandle().getNoiseBiome(location.getBlockX() >> 2, location.getBlockY() >> 2, location.getBlockZ() >> 2).value();
        ResourceLocation resourceLocation = registry.getKey(biome);
        if (resourceLocation == null) {
            return "void";
        }
        return resourceLocation.toString();
    }
}

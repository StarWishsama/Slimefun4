package io.github.thebusybiscuit.slimefun4.utils;

import io.github.thebusybiscuit.slimefun4.core.services.holograms.HologramsService;
import io.github.thebusybiscuit.slimefun4.implementation.items.altar.AncientPedestal;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.HologramProjector;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

import javax.annotation.Nonnull;

/**
 * This class holds utilities for {@link ArmorStand}, useful for classes
 * dealing with {@link ArmorStand}s that are not from {@link HologramsService}
 *
 * @see HologramProjector
 * @see AncientPedestal
 *
 * @author JustAHuman
 */
public class ArmorStandUtils {
    /**
     * Spawns an {@link ArmorStand} at the given {@link Location}
     * (Invisible, Silent, Marker, NoGravity, NoBasePlate, Visible CustomName, NoRemoveWhenFarAway)
     *
     * @param location The {@link Location} to spawn the {@link ArmorStand}
     * @return The spawned {@link ArmorStand}
     */
    public static ArmorStand spawnArmorStand(@Nonnull Location location) {
        ArmorStand armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setVisible(false);
        armorStand.setSilent(true);
        armorStand.setMarker(true);
        armorStand.setGravity(false);
        armorStand.setBasePlate(false);
        armorStand.setCustomNameVisible(true);
        armorStand.setRemoveWhenFarAway(false);
        return armorStand;
    }
}

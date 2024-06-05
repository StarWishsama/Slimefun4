package com.xzavier0722.mc.plugin.slimefun4.storage.controller;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.Getter;
import lombok.Setter;
import me.mrCookieSlime.Slimefun.api.inventory.UniversalMenu;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class SlimefunUniversalData extends ASlimefunDataContainer {
    @Getter
    private final String sfId;

    @Setter
    @Getter
    private volatile UniversalMenu universalMenu;

    @Setter
    @Getter
    private volatile Location lastPresent;

    @Setter
    @Getter
    private volatile boolean pendingRemove = false;

    @ParametersAreNonnullByDefault
    SlimefunUniversalData(UUID uuid, Location location, String sfId) {
        super(uuid.toString());
        this.lastPresent = location;
        this.sfId = sfId;
    }

    @ParametersAreNonnullByDefault
    SlimefunUniversalData(UUID uuid, Location location, SlimefunUniversalData other) {
        super(uuid.toString(), other);
        this.lastPresent = location;
        this.sfId = other.sfId;
    }

    @ParametersAreNonnullByDefault
    public void setData(String key, String val) {
        checkData();
        setCacheInternal(key, val, true);
        Slimefun.getDatabaseManager().getBlockDataController().scheduleDelayedUniversalDataUpdate(this, key);
    }

    @ParametersAreNonnullByDefault
    public void removeData(String key) {
        if (removeCacheInternal(key) != null || !isDataLoaded()) {
            Slimefun.getDatabaseManager().getBlockDataController().scheduleDelayedUniversalDataUpdate(this, key);
        }
    }

    @Nullable public ItemStack[] getMenuContents() {
        if (universalMenu == null) {
            return null;
        }
        var re = new ItemStack[54];
        var presetSlots = universalMenu.getPreset().getPresetSlots();
        var inv = universalMenu.toInventory().getContents();
        for (var i = 0; i < inv.length; i++) {
            if (presetSlots.contains(i)) {
                continue;
            }
            re[i] = inv[i];
        }

        return re;
    }

    public UUID getUUID() {
        return UUID.fromString(getKey());
    }

    @Override
    public String toString() {
        return "SlimefunUniversalData [sfId=" + sfId + ", isPendingRemove=" + pendingRemove + "]";
    }
}

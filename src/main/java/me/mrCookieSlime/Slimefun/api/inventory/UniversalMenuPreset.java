package me.mrCookieSlime.Slimefun.api.inventory;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.bukkit.block.Block;

public abstract class UniversalMenuPreset extends BlockMenuPreset {
    /**
     * Creates a new ChestMenu with the specified
     * Title
     *
     * @param title The title of the Menu
     */
    public UniversalMenuPreset(@Nonnull String id, @Nonnull String title) {
        super(id, title);
    }

    public void newInstance(@Nonnull UniversalMenu menu, @Nonnull Block b) {
        // This method can optionally be overridden by implementations
    }

    protected void clone(@Nonnull UniversalMenu menu, @Nonnull Block b) {
        menu.setPlayerInventoryClickable(true);

        for (int slot : occupiedSlots) {
            menu.addItem(slot, getItemInSlot(slot));
        }

        if (size > -1) {
            menu.addItem(size - 1, null);
        }

        newInstance(menu, b);

        for (int slot = 0; slot < 54; slot++) {
            if (getMenuClickHandler(slot) != null) {
                menu.addMenuClickHandler(slot, getMenuClickHandler(slot));
            }
        }

        menu.addMenuOpeningHandler(getMenuOpeningHandler());
        menu.addMenuCloseHandler(getMenuCloseHandler());
    }

    @Nullable public static UniversalMenuPreset getPreset(@Nullable String id) {
        if (id == null) {
            return null;
        } else {
            var preset = Slimefun.getRegistry().getMenuPresets().get(id);
            if (preset instanceof UniversalMenuPreset uniPreset) {
                return uniPreset;
            } else {
                return null;
            }
        }
    }
}

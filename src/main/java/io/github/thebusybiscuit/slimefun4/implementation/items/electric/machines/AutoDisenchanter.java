package io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

/**
 * This has been moved.
 * 
 * @deprecated Moved to
 *             {@link io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.enchanting.AutoDisenchanter}
 *
 */
@Deprecated
public class AutoDisenchanter extends io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.enchanting.AutoEnchanter {

    @ParametersAreNonnullByDefault
    public AutoDisenchanter(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

}

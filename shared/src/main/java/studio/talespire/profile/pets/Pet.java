package studio.talespire.profile.pets;

import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import studio.talespire.profile.util.Rarities;

import java.util.UUID;

@Data
public abstract class Pet {
    private final String name;
    private final Rarities rarity;
    private final int level;
    private final int maxLevel;
    private final int xp;

    public abstract ItemStack getHead();
    public abstract void spawn(Player player);
    public abstract void despawn(Player player, UUID uuid);
}

package studio.talespire.profile.classes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;

@RequiredArgsConstructor
@Getter
public enum Class {
    UNDEFINED ("Deprived", Material.BARRIER, 100, 100, 100, 100, 100, 100, 100),
    MAGE("Mage", Material.STICK, 100, 180, 100, 120, 100, 100, 110),
    WARRIOR("Warrior", Material.IRON_SWORD, 180, 100, 160, 140, 150, 140, 100),
    BANDIT("Bandit", Material.IRON_AXE, 130, 110, 120, 150, 110, 110, 160),
    ARCHER("Archer", Material.BOW, 150, 120, 110, 130, 100, 100, 140),
    ASSASSIN("Assassin", Material.STONE_SWORD, 120, 140, 110, 160, 100, 100, 150);

    private final String name;
    private final Material icon;

    private final int health;
    private final int mana;
    private final int strength;
    private final int damage;
    private final int defense;
    private final int carryWeight;
    private final int speed;
}

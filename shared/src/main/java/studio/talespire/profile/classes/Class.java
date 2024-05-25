package studio.talespire.profile.classes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;

@RequiredArgsConstructor
@Getter
public enum Class {
    UNDEFINED ("Deprived", Material.BARRIER),
    MAGE("Mage", Material.STICK),
    WARRIOR("Warrior", Material.IRON_SWORD),
    BANDIT("Bandit", Material.IRON_AXE),
    ARCHER("Archer", Material.BOW),
    ASSASSIN("Assassin", Material.STONE_SWORD);

    private final String name;
    private final Material icon;
}

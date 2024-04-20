package studio.talespire.profile.classes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;

@RequiredArgsConstructor
@Getter
public enum Class {
    UNDEFINED ("None", Material.BARRIER),
    BARBARIAN ("Barbarian", Material.IRON_AXE),
    BARD ("Bard", Material.MUSIC_DISC_CAT),
    CLERIC ("Cleric", Material.GOLDEN_APPLE),
    DRUID ("Druid", Material.OAK_LEAVES),
    FIGHTER ("Fighter", Material.IRON_SWORD),
    MONK ("Monk", Material.GOLDEN_CARROT),
    PALADIN ("Paladin", Material.SHIELD),
    RANGER ("Ranger", Material.BOW),
    ROGUE ("Rogue", Material.IRON_NUGGET),
    SORCERER ("Sorcerer", Material.BLAZE_POWDER),
    WARLOCK ("Warlock", Material.ENDER_PEARL),
    WIZARD ("Wizard", Material.ENCHANTING_TABLE);

    private final String name;
    private final Material icon;
}

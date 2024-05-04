package studio.talespire.profile.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;

@RequiredArgsConstructor
@Getter
public enum Rarities {

    COMMON("Common", ChatColor.WHITE),
    UNCOMMON("Uncommon", ChatColor.GREEN),
    RARE("Rare", ChatColor.BLUE),
    EPIC("Epic", ChatColor.DARK_PURPLE),
    LEGENDARY("Legendary", ChatColor.GOLD),
    MYTHIC("Mythic", ChatColor.RED);

    private final String name;
    private final ChatColor color;
}
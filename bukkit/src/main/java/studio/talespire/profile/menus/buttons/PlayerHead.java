package studio.talespire.profile.menus.buttons;

import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import studio.lunarlabs.universe.menus.api.Button;
import studio.lunarlabs.universe.util.ItemBuilder;

@RequiredArgsConstructor
public class PlayerHead extends Button {

    private final String playerName;

    @Override
    public ItemStack getItem(Player player) {
        return new ItemBuilder(Material.PLAYER_HEAD, 1, (short) SkullType.PLAYER.ordinal())
                .setSkullOwner(playerName)
                .setName(ChatColor.RESET + "")
                .toItemStack();
    }
}

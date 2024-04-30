package studio.talespire.profile.menus.buttons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import studio.lunarlabs.universe.menus.api.Button;
import studio.lunarlabs.universe.util.ItemBuilder;

public class StoreButton extends Button {

    @Override
    public ItemStack getItem(Player player) {
        return new ItemBuilder(Material.EMERALD)
                .setName(ChatColor.GREEN + "Store")
                .toItemStack();
    }

    @Override
    public void clicked(Player player, ClickType clickType) {
        player.sendMessage(ChatColor.GREEN + "Opening Store...");
    }
}

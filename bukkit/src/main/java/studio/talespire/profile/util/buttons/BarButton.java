package studio.talespire.profile.util.buttons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import studio.lunarlabs.universe.menus.api.Button;
import studio.lunarlabs.universe.util.ItemBuilder;

public class BarButton extends Button {

    @Override
    public ItemStack getItem(Player player) {
        return new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setName(ChatColor.RESET + "")
                .toItemStack();
    }
}

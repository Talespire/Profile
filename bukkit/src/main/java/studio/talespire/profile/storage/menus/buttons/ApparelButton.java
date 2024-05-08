package studio.talespire.profile.storage.menus.buttons;

import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.menus.api.Button;
import studio.lunarlabs.universe.menus.api.MenuHandler;
import studio.lunarlabs.universe.util.ItemBuilder;
import studio.talespire.profile.storage.menus.ApparelMenu;

@RequiredArgsConstructor
public class ApparelButton extends Button {
    private final boolean isSelected;

    @Override
    public ItemStack getItem(Player player) {
        ItemStack item = new ItemBuilder(Material.NETHERITE_CHESTPLATE)
            .setName(isSelected? ChatColor.GREEN + "Apparel" : ChatColor.GRAY + "Apparel")
            .toItemStack();

        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);

        return item;
    }

    @Override
    public void clicked(Player player, ClickType clickType) {
        if (isSelected) {
            player.playSound(player.getLocation(), org.bukkit.Sound.ENTITY_VILLAGER_NO, 1, 1);
        } else {
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1f, 1f);
            player.closeInventory();
            Universe.get(MenuHandler.class).openMenu(new ApparelMenu(), player);
        }
    }

}

package studio.talespire.profile.storage.menus.buttons;

import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.menus.api.Button;
import studio.lunarlabs.universe.menus.api.MenuHandler;
import studio.lunarlabs.universe.util.ItemBuilder;
import studio.talespire.profile.storage.menus.FavoritesMenu;
import studio.talespire.profile.storage.menus.FoodMenu;

@RequiredArgsConstructor
public class FoodButton extends Button {

    private final boolean isSelected;

    @Override
    public ItemStack getItem(Player player) {
        return new ItemBuilder(Material.COOKED_BEEF)
                .setName(isSelected? ChatColor.GREEN + "Food" : ChatColor.GRAY + "Food")
                .toItemStack();
    }

    @Override
    public void clicked(Player player, ClickType clickType) {
        if (isSelected) {
              player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
          } else {
              player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 20f, 0.1f);
            player.closeInventory();
              Universe.get(MenuHandler.class).openMenuAsync(new FoodMenu(), player);
          }
    }
}

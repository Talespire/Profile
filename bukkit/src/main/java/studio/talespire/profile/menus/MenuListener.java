package studio.talespire.profile.menus;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.menus.api.MenuHandler;

public class MenuListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) return;

        ItemStack item = event.getItem();
        if (item.getType() == Material.HEART_OF_THE_SEA) {
            Universe.get(MenuHandler.class).openMenuAsync(new ProfileMenu(), event.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {

        Material droppedItem = event.getItemDrop().getItemStack().getType();

        if (droppedItem == Material.HEART_OF_THE_SEA) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerSecondHand(PlayerSwapHandItemsEvent event) {
        ItemStack item = event.getOffHandItem();
        if (item.getType() == Material.HEART_OF_THE_SEA) {
            event.setCancelled(true);
        }
    }
}

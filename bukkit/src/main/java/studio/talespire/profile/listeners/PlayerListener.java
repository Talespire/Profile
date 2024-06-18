package studio.talespire.profile.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.menus.api.MenuHandler;
import studio.talespire.profile.menus.talespireMenus.CharacterSelectionMenu;

/**
 * @author Disunion
 * @date 5/24/2024
 */

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerCloseInventory(InventoryCloseEvent event) {
        if (event.getInventory() instanceof CharacterSelectionMenu) {
            if (!CharacterSelectionMenu.isDoneWithMenu()) {
                Universe.get(MenuHandler.class).openMenuAsync((Player) event.getPlayer(), new CharacterSelectionMenu());
            }
        }
    }

    @EventHandler
    public void onPlayerLoseHunger(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!player.hasMetadata("build")) {
            event.setCancelled(true);
        }
    }
}

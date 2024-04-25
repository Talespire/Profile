package studio.talespire.profile.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.menus.api.Menu;
import studio.lunarlabs.universe.menus.api.MenuHandler;
import studio.lunarlabs.universe.util.PlayerUtils;
import studio.talespire.profile.menus.CharacterSelectionMenu;

public class LogInListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {

        event.getPlayer().getInventory().clear();

        event.getPlayer().setInvisible(true);
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999, 1, false, false, false));

        event.getPlayer().teleport(Bukkit.getWorld("world").getSpawnLocation());

        Universe.get().getRegistry().get(MenuHandler.class).openMenuAsync(event.getPlayer(), new CharacterSelectionMenu());
        event.getPlayer().sendMessage("Welcome to the server! Please select a character.");
    }
}
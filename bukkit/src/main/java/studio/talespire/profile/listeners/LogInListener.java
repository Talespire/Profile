package studio.talespire.profile.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.menus.api.MenuHandler;
import studio.talespire.profile.ProfilePlugin;
import studio.talespire.profile.menus.talespireMenus.CharacterSelectionMenu;

public class LogInListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {

        event.getPlayer().getInventory().clear();

        event.getPlayer().setInvisible(true);
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999, 1, false, false, false));

        event.getPlayer().teleport(new Location(ProfilePlugin.get().getServer().getWorld("world"), 0.5, 0, 0.5));

        Universe.get().getRegistry().get(MenuHandler.class).openMenuAsync(event.getPlayer(), new CharacterSelectionMenu());
    }
}
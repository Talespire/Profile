package studio.talespire.profile.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import studio.talespire.profile.Profile;

public class LogOutListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        // Update the player's character's inventory
        Profile.getInstance().getProfileHandler().getProfile(event.getPlayer().getUniqueId())
                .getSelectedCharacter().setInventory(event.getPlayer().getInventory().getContents());

        // Save the player's character data when they log out
        Profile.getInstance().getProfileHandler().getProfile(event.getPlayer().getUniqueId()).updateCharacter(
                Profile.getInstance().getProfileHandler().getProfile(event.getPlayer().getUniqueId()).getSelectedCharacter()
        );
    }
}
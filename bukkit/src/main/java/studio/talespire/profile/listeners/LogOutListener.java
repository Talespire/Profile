package studio.talespire.profile.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import studio.talespire.profile.Profile;

public class LogOutListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        Profile.getInstance().getProfileHandler().getProfile(event.getPlayer().getUniqueId());


    }
}

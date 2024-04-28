package studio.talespire.profile.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitTask;
import studio.talespire.profile.Profile;
import studio.talespire.profile.ProfilePlugin;

import java.util.UUID;

public class PlayerListener implements Listener {
//
//    private BukkitTask task;
//
//    @EventHandler
//    public void onPlayerMove(PlayerMoveEvent event) {
//        UUID uuid = event.getPlayer().getUniqueId();
//
//        String oldReleventInfo = Profile.getInstance().getProfileHandler().getProfile(uuid).getSelectedCharacter().getActionBar().getReleventInfo();
//
//        // Cancel the previous task if it exists
//        if (task != null) {
//            task.cancel();
//        }
//
//        String direction = event.getTo().getDirection().toString();
//
//        Profile.getInstance().getProfileHandler().getProfile(uuid).getSelectedCharacter().getActionBar().setReleventInfo(
//                ChatColor.WHITE + direction
//        );
//
//        // Schedule a task to reset the action bar after 1 second (20 ticks) of no movement
//        task = Bukkit.getScheduler().runTaskLater(ProfilePlugin.get(), () -> {
//            Profile.getInstance().getProfileHandler().getProfile(uuid).getSelectedCharacter().getActionBar().setReleventInfo(oldReleventInfo);
//        }, 20L);
//    }

//    @EventHandler
//    public void onPlayerMove(PlayerMoveEvent event) {
//        UUID uuid = event.getPlayer().getUniqueId();
//
//        String direction = event.getTo().getDirection().toString();
//
//
//        Profile.getInstance().getProfileHandler().getProfile(uuid).getSelectedCharacter().getActionBar().setReleventInfo(
//                ChatColor.WHITE + direction
//        );
//    }
}

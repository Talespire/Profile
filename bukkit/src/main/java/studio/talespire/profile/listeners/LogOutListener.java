package studio.talespire.profile.listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import studio.talespire.profile.Profile;
import studio.talespire.profile.character.Character;
import studio.talespire.profile.profiles.TalespireProfile;

public class LogOutListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        TalespireProfile profile = Profile.getInstance().getProfileHandler().getProfile(event.getPlayer().getUniqueId());
        Character playerCharacter = Profile.getInstance().getProfileHandler().getProfile(event.getPlayer().getUniqueId()).getSelectedCharacter();
        
        playerCharacter.setInventory(event.getPlayer().getInventory().getContents());
        Location location = event.getPlayer().getLocation();
        playerCharacter.setLocationX(location.getX());
        playerCharacter.setLocationY(location.getY());
        playerCharacter.setLocationZ(location.getZ());

        profile.updateCharacter(playerCharacter);
        profile.save();
    }
}
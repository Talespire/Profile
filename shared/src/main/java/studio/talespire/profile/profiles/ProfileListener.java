package studio.talespire.profile.profiles;

import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import studio.lunarlabs.universe.util.general.Tasks;
import studio.talespire.profile.Profile;

import java.util.UUID;

@RequiredArgsConstructor
public class ProfileListener implements Listener {

    private final Profile shared;

    @EventHandler
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        UUID uuid = event.getUniqueId();
        TalespireProfile talespireProfile = shared.getProfileHandler().getProfile(uuid);

        if (talespireProfile != null) {
            talespireProfile.load();
            talespireProfile.setName(event.getName());
            TalespireProfile finalProfile = talespireProfile;
            Tasks.runLater(() -> {
                finalProfile.setName(event.getName());
                finalProfile.save();
            }, 20L * 5);
            return;
        }

        talespireProfile = shared.getProfileHandler().addProfile(uuid);
        talespireProfile.setName(event.getName());
        talespireProfile.save();
    }
}

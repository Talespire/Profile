package studio.talespire.profile;

import org.bukkit.plugin.java.JavaPlugin;
import studio.lunarlabs.universe.annotation.BukkitPlugin;
import studio.talespire.profile.profiles.ProfileListener;

@BukkitPlugin(
        name = "Profile",
        version = "${git.build.version}-${git.commit.id.abbrev}-${git.branch}",
        description = "Profile",
        load = "STARTUP",
        gitReplacements = true,
        apiVersion = "1.13",
        depend = "Universe"
)
public class ProfilePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new ProfileBukkit(this);
    }

    @Override
    public void onDisable() {
        Profile.getInstance().disable();
    }
}

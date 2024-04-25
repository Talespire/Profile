package studio.talespire.profile;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import studio.lunarlabs.universe.annotation.BukkitPlugin;

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

    private static ProfilePlugin instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        new ProfileBukkit(this);
    }

    @Override
    public void onDisable() {
        Profile.getInstance().disable();
    }

    public static Plugin get() {
        return instance;
    }
}

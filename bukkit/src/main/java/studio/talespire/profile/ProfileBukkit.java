package studio.talespire.profile;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import studio.talespire.profile.listeners.LogInListener;

@Getter
public class ProfileBukkit extends Profile{

    @Getter
    private static ProfileBukkit instance;

    public ProfileBukkit(JavaPlugin plugin) {
        super(plugin.getDataFolder().toPath());
        instance = this;

        plugin.getServer().getPluginManager().registerEvents(new LogInListener(), plugin);
    }
}

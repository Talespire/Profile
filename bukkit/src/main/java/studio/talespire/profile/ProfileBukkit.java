package studio.talespire.profile;

import org.bukkit.plugin.java.JavaPlugin;

public class ProfileBukkit extends Profile{

    public ProfileBukkit(JavaPlugin plugin) {
        super(plugin.getDataFolder().toPath());
    }
}

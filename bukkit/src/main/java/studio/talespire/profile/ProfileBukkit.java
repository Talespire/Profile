package studio.talespire.profile;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.scoreboard.ScoreboardService;
import studio.talespire.profile.listeners.LogInListener;
import studio.talespire.profile.listeners.LogOutListener;
import studio.talespire.profile.listeners.PlayerListener;
import studio.talespire.profile.menus.MenuListener;
import studio.talespire.profile.scoreboard.PlayerScoreBoardAdapter;

@Getter
public class ProfileBukkit extends Profile{

    @Getter
    private static ProfileBukkit instance;

    public ProfileBukkit(JavaPlugin plugin) {
        super(plugin.getDataFolder().toPath());
        instance = this;

        Universe.get(ScoreboardService.class).setAdapter(new PlayerScoreBoardAdapter());
        Universe.get(ScoreboardService.class).init();

        plugin.getServer().getPluginManager().registerEvents(new LogInListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LogOutListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MenuListener(), plugin);
    }
}

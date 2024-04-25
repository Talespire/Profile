package studio.talespire.profile;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.UniverseBukkit;
import studio.lunarlabs.universe.UniversePlugin;
import studio.lunarlabs.universe.scoreboard.ScoreboardAdapter;
import studio.lunarlabs.universe.scoreboard.ScoreboardService;
import studio.talespire.profile.listeners.LogInListener;
import studio.talespire.profile.listeners.LogOutListener;
import studio.talespire.profile.menus.CharacterSelectionMenu;
import studio.talespire.profile.scoreboard.PlayerScoreBoardAdapter;

@Getter
public class ProfileBukkit extends Profile{

    @Getter
    private static ProfileBukkit instance;

    public ProfileBukkit(JavaPlugin plugin) {
        super(plugin.getDataFolder().toPath());
        instance = this;

        Universe.get().getRegistry().get(ScoreboardService.class).setAdapter(new PlayerScoreBoardAdapter());
        Universe.get().getRegistry().get(ScoreboardService.class).init();

        plugin.getServer().getPluginManager().registerEvents(new LogInListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LogOutListener(), plugin);

    }
}

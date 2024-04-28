package studio.talespire.profile.scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.config.defaults.MessageConfig;
import studio.lunarlabs.universe.scoreboard.ScoreboardAdapter;
import studio.talespire.profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class PlayerScoreBoardAdapter implements ScoreboardAdapter {
    @Override
    public String getTitle(Player player) {
        return (ChatColor.GOLD + "Talespire Profile");
    }

    @Override
    public List<String> getLines(Player player) {

        //-- Instance Variables
        List<String> lines = new ArrayList<>();
        lines.add(ChatColor.GREEN + "Level: " + Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter().getLevel());
        lines.add(ChatColor.GREEN + "Experience: " + Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter().getExperience());

        lines.add("");
        lines.add(ChatColor.YELLOW + "talespire.net");

        return lines;
    }
}

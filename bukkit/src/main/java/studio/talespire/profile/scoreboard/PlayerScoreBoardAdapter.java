package studio.talespire.profile.scoreboard;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.config.defaults.MessageConfig;
import studio.lunarlabs.universe.scoreboard.ScoreboardAdapter;
import studio.talespire.profile.Profile;
import studio.talespire.profile.character.Character;
import studio.talespire.questmind.quests.Objective;
import studio.talespire.questmind.quests.Quest;
import studio.talespire.questmind.quests.QuestService;

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
        Character character = Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter();

        lines.add("Current Quest");

        Quest trackedQuest = Universe.get(QuestService.class).getQuestByName(character.getTrackedQuest());
        Objective objective = trackedQuest.getObjectives().get(character.getPlayerObjectiveIndex(trackedQuest.getQuestName()));
        if (trackedQuest != null) {
            lines.add(ChatColor.RED + trackedQuest.getQuestName());
            lines.add(ChatColor.WHITE + objective.getDescription());
        } else {
            lines.add(ChatColor.YELLOW + "No Active Quest");
        }

        lines.add("");
        lines.add(ChatColor.YELLOW + "talespire.net");

        return lines;
    }
}

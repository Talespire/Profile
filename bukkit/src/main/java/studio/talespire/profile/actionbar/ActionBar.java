package studio.talespire.profile.actionbar;

import lombok.Getter;
import lombok.Setter;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import studio.talespire.profile.Profile;
import studio.talespire.profile.ProfilePlugin;

@Getter
public class ActionBar {

    private final Player player;

    private String healthBar;
    private String manaBar;
    private String releventInfo;

    public ActionBar(Player player) {
        this.player = player;

        //-- Start the task to update the action bar every tick
        Bukkit.getScheduler().runTaskTimer(ProfilePlugin.get(), () -> {

            //-- Initialize what should initially be the player's health, mana, and relevent info
            healthBar = ChatColor.RED
                    + (rounder(player.getHealth()*5)
                    + "/" + rounder(player.getMaxHealth()*5)
                    + "❤");
            manaBar = ChatColor.BLUE
                    + String.valueOf(Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter().getCurrentMana())
                    + "/" + Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter().getMaxMana()
                    + "✎";
            releventInfo = ChatColor.WHITE
                    + Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter().getActionBarReleventInfo();

            this.display(player);
        }, 0L, 20L);
    }

    public void display(Player player) {

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(
                    healthBar + "     " + releventInfo + "     " + manaBar
                )
        );
    }

    private int rounder(double value) {
        return (int) Math.round(value);
    }
}
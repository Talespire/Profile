package studio.talespire.profile.actionbar;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import studio.talespire.profile.Profile;

public class ActionBar {

    public void display(Player player) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(

                ChatColor.RED + String.valueOf(Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter().getCurrentHealth())
                + "/" + Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter().getMaxHealth() + "❤"

                + "     " + ChatColor.GREEN + Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter().getDefense() + "✚ Defense"

                + "     " + ChatColor.BLUE + Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter().getCurrentMana()
                + "/" + Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).getSelectedCharacter().getMaxMana() + "✎ Mana"

                ));
    }

}

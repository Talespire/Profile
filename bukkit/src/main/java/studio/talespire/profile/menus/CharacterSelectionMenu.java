package studio.talespire.profile.menus;

import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import studio.lunarlabs.universe.menus.api.Button;
import studio.lunarlabs.universe.menus.api.Menu;
import studio.lunarlabs.universe.util.ItemBuilder;
import studio.talespire.profile.Profile;
import studio.talespire.profile.character.Character;
import studio.talespire.profile.profiles.ProfileHandler;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class CharacterSelectionMenu extends Menu {

    private final ProfileHandler profileHandler = Profile.getInstance().getProfileHandler();

    @Override
    public String getTitle(Player player) {
        return "CHARACTER SELECTION";
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {

        final Map<Integer, Button> buttons = new HashMap<>();

        profileHandler.getProfile(player.getUniqueId()).getCharacters()
                .stream().forEach(character -> buttons.put((buttons.size() + 11), new ExistingCharacterButton(character)));

        for (int i = buttons.size() + 11; i < 6; i++) {
            buttons.computeIfAbsent(i, k -> new NewCharacterButton());
        }

        return buttons;
    }

    @RequiredArgsConstructor
    private static class ExistingCharacterButton extends Button {

        private final Character character;

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(character.getCharacterClass().getIcon())
                    .setName(ChatColor.GOLD + "[>] Select This Character")
                    .addLoreLine(ChatColor.YELLOW + "Character Info")
                    .addLoreLine(ChatColor.YELLOW + "- " + ChatColor.GRAY + "Class: " + ChatColor.WHITE + character.getCharacterClass().getName())
                    .addLoreLine(ChatColor.YELLOW + "- " + ChatColor.GRAY + "Level: " + ChatColor.WHITE + character.getLevel())
                    .addLoreLine(ChatColor.YELLOW + "- " + ChatColor.GRAY + "XP: " + ChatColor.WHITE + character.getExperience() + "%")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.RED + "Right Click to Delete")
                    .toItemStack();
        }

        @Override
        public void clicked(Player player, ClickType clickType) {
            if (clickType == ClickType.RIGHT) {
                // Delete character
                player.closeInventory();
            } else {
                // Select character
                player.closeInventory();
            }
        }
    }

    @RequiredArgsConstructor
    private static class NewCharacterButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.OAK_BUTTON)
                    .setName(ChatColor.GREEN + "[+] Create a new Character!")
                    .addLoreLine(ChatColor.YELLOW + "Create a new character to play with!")
                    .toItemStack();
        }

        @Override
        public void clicked(Player player, ClickType clickType) {
            // Create new character
            player.closeInventory();
        }
    }
}

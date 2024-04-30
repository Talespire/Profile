package studio.talespire.profile.menus.talespireMenus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.menus.api.Button;
import studio.lunarlabs.universe.menus.api.Menu;
import studio.lunarlabs.universe.menus.api.MenuHandler;
import studio.lunarlabs.universe.util.ItemBuilder;
import studio.talespire.profile.Profile;
import studio.talespire.profile.actionbar.ActionBar;
import studio.talespire.profile.character.Character;
import studio.talespire.profile.profiles.ProfileHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CharacterSelectionMenu extends Menu {

    @Getter  public static boolean doneWithMenu = false;
    private final ProfileHandler profileHandler;

    public CharacterSelectionMenu() {
        this.setBordered(true);
        this.profileHandler = Profile.getInstance().getProfileHandler();
    }

    @Override
    public String getTitle(Player player) {
        return "Select your Character";
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {

        final Map<Integer, Button> buttons = new HashMap<>();

        profileHandler.getProfile(player.getUniqueId()).getCharacters()
                .stream().forEach(character -> buttons.put((buttons.size() + 11), new ExistingCharacterButton(character)));

        for (int i = 11; i < 16; i++) {
            buttons.computeIfAbsent(i, k -> new NewCharacterButton());
        }

        return buttons;
    }

    @RequiredArgsConstructor
    private static class ExistingCharacterButton extends Button {

        private final Character character;

        @Override
        public ItemStack getItem(Player player) {

            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

            return new ItemBuilder(character.getCharacterClass().getIcon())
                    .setName(ChatColor.GOLD + "[>] Select This Character")
                    .addLoreLine(ChatColor.YELLOW + "Character Info")
                    .addLoreLine(ChatColor.YELLOW + "- " + ChatColor.GRAY + "Class: " + ChatColor.WHITE + character.getCharacterClass().getName())
                    .addLoreLine(ChatColor.YELLOW + "- " + ChatColor.GRAY + "Level: " + ChatColor.WHITE + character.getLevel())
                    .addLoreLine(ChatColor.YELLOW + "- " + ChatColor.GRAY + "XP: " + ChatColor.WHITE + character.getExperience() + "%")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.DARK_GRAY + "Created on: " + dateFormat.format(new Date(character.getCreationDate())))
                    .addLoreLine("")
                    .addLoreLine(ChatColor.RED + "Right Click to Delete")
                    .toItemStack();
        }

        @Override
        public void clicked(Player player, ClickType clickType) {
            if (clickType == ClickType.RIGHT) {

                // Delete the character from the player's profile and reopen the menu
                Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).deleteCharacter(character);
                Universe.get().getRegistry().get(MenuHandler.class).openMenuAsync(player, new CharacterSelectionMenu());

            } else {

                // Set the player's selected character to their current character
                Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).setSelectedCharacter(character);

                // Update the player's inventory to that of the selected character
                player.getInventory().setContents(character.getInventory());

                // Remove all effects associated with first spawning in, and send the player off to the world
                sendPlayerOff(player);
                doneWithMenu = true;
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

            Character newCharacter = new Character();

            // Create a new character, add it to the player's profile and set it as the selected character
            Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).addCharacter(newCharacter);
            Profile.getInstance().getProfileHandler().getProfile(player.getUniqueId()).setSelectedCharacter(newCharacter);

            // Close the menu and send the player off to the world
            doneWithMenu = true;
            player.closeInventory();
            sendPlayerOff(player);
        }
    }

    public static void sendPlayerOff(Player player) {

        player.sendMessage("Welcome to the server!");
        player.teleport(Bukkit.getWorld("world").getSpawnLocation());
        player.setInvisible(false);
        player.clearActivePotionEffects();

        player.getInventory().setItem(8,
                new ItemBuilder(Material.HEART_OF_THE_SEA)
                        .setName(ChatColor.GREEN + "Talespire Menu")
                        .addLoreLine(ChatColor.GRAY + "Right click to open the Talespire Menu")
                        .toItemStack());

        // Initialize the actionBar and let it do its thing
        new ActionBar(player);
    }
}

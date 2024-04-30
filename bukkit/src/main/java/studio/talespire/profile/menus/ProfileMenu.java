package studio.talespire.profile.menus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.menus.api.Button;
import studio.lunarlabs.universe.menus.api.Menu;
import studio.lunarlabs.universe.menus.api.MenuHandler;
import studio.lunarlabs.universe.util.ItemBuilder;
import studio.talespire.profile.menus.buttons.ExitButton;
import studio.talespire.profile.menus.buttons.PlayerHead;
import studio.talespire.profile.menus.buttons.StoreButton;
import studio.talespire.profile.menus.talespireMenus.CharacterSelectionMenu;

import java.util.HashMap;
import java.util.Map;

public class ProfileMenu extends Menu {

    public ProfileMenu() {
        this.setBordered(true);
    }

    @Override
    public String getTitle(Player player) {
        return "Talespire Profile";
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        buttons.put(getSlot(1, 1), new CharacterSelectorButton());
        buttons.put(getSlot(4, 1), new PlayerHead(player.getName()));
        buttons.put(getSlot(7, 1), new BankButton());

        buttons.put(getSlot(1, 2), new SocialMenuButton());
        buttons.put(getSlot(3, 2), new SkillTreeButton());
        buttons.put(getSlot(4, 2), new LevelingButton());
        buttons.put(getSlot(5, 2), new StorageButton());
        buttons.put(getSlot(7, 2), new MapButton());

        buttons.put(getSlot(1, 3), new SettingsButton());
        buttons.put(getSlot(3, 3), new CalenderButton());
        buttons.put(getSlot(4, 3), new CraftingButton());
        buttons.put(getSlot(5, 3), new StoreButton());
        buttons.put(getSlot(7, 3), new PetsButton());


        buttons.put(getSlot(4, 4), new ExitButton());

        return buttons;
    }


    private static class CharacterSelectorButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.NAME_TAG)
                    .setName(ChatColor.GREEN + "Character Selector")
                    .addLoreLine(ChatColor.GRAY + "View, Manage, and Select from all of your")
                    .addLoreLine(ChatColor.GRAY + "Saved Characters.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            player.closeInventory();
            Universe.get(MenuHandler.class).openMenuAsync(new CharacterSelectionMenu(), player);
        }
    }

    private static class BankButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.GOLD_INGOT)
                    .setName(ChatColor.GREEN + "Bank")
                    .addLoreLine(ChatColor.GRAY + "View your bank balance and manage your")
                    .addLoreLine(ChatColor.GRAY + "bank account.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            // Open the bank menu
        }
    }

    private static class SocialMenuButton extends Button {

        @Override
        public ItemStack getItem(Player player) {

            ItemStack item = new ItemBuilder(Material.SKULL_BANNER_PATTERN)
                    .setName(ChatColor.GREEN + "Social Menu")
                    .addLoreLine(ChatColor.GRAY + "View your current Friends, view, send")
                    .addLoreLine(ChatColor.GRAY + "and accept Friend requests. Create, join")
                    .addLoreLine(ChatColor.GRAY + "and send Party Requests. View and manage")
                    .addLoreLine(ChatColor.GRAY + "Your current Guild. Accept, search, and request")
                    .addLoreLine(ChatColor.GRAY + "to join other Guilds.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();

            ItemMeta meta = item.getItemMeta();
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ITEM_SPECIFICS);
            item.setItemMeta(meta);

            return item;
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            // Open the social menu
        }
    }

    private static class SkillTreeButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.OAK_SAPLING)
                    .setName(ChatColor.GREEN + "Skill Tree")
                    .addLoreLine(ChatColor.GRAY + "View and manage your character's skill tree")
                    .addLoreLine(ChatColor.GRAY + "for each skill.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            // Open the skill tree menu
        }
    }

    private static class LevelingButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.NETHER_STAR)
                    .setName(ChatColor.GREEN + "Leveling")
                    .addLoreLine(ChatColor.GRAY + "View your current level, experience, and")
                    .addLoreLine(ChatColor.GRAY + "progress to the next level.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            // Open the leveling menu
        }
    }

    private static class StorageButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.CHEST)
                    .setName(ChatColor.GREEN + "Storage")
                    .addLoreLine(ChatColor.GRAY + "View and manage your character's storage,")
                    .addLoreLine(ChatColor.GRAY + "weapons, armor, spells, accessories and more.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            // Open the storage menu
        }
    }

    private static class MapButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.FILLED_MAP)
                    .setName(ChatColor.GREEN + "World Map")
                    .addLoreLine(ChatColor.GRAY + "View the map of the world, your current")
                    .addLoreLine(ChatColor.GRAY + "location, and other points of interest.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            // Open the map menu
        }
    }

    private static class SettingsButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.COMPARATOR)
                    .setName(ChatColor.GREEN + "Settings")
                    .addLoreLine(ChatColor.GRAY + "View and manage your Talespire settings,")
                    .addLoreLine(ChatColor.GRAY + "such as request filters, chat filters, notifications")
                    .addLoreLine(ChatColor.GRAY + "and more.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            // Open the settings menu
        }
    }

    private static class CalenderButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.CLOCK)
                    .setName(ChatColor.GREEN + "Calender")
                    .addLoreLine(ChatColor.GRAY + "View the Talespire calender,")
                    .addLoreLine(ChatColor.GRAY + "events, and more.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            // Open the calender menu
        }
    }

    private static class CraftingButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.CRAFTING_TABLE)
                    .setName(ChatColor.GREEN + "Crafting")
                    .addLoreLine(ChatColor.GRAY + "Open the Talespire crafting menu and")
                    .addLoreLine(ChatColor.GRAY + "your unlocked recipes to craft items.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            // Open the crafting menu
        }
    }

    private static class CrateButton extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.TRIPWIRE_HOOK)
                    .setName(ChatColor.GREEN + "Crates")
                    .addLoreLine(ChatColor.GRAY + "View and manage your Talespire crates,")
                    .addLoreLine(ChatColor.GRAY + "keys, and rewards.")
                    .addLoreLine("")
                    .addLoreLine(ChatColor.YELLOW + "Click to view!")
                    .toItemStack();
        }

        @Override
        public void clicked (Player player, ClickType clickType) {
            // Open the crates menu
        }
    }

    private static class PetsButton extends Button {

            @Override
            public ItemStack getItem(Player player) {
                return new ItemBuilder(Material.SADDLE)
                        .setName(ChatColor.GREEN + "Pets")
                        .addLoreLine(ChatColor.GRAY + "View and manage your Talespire pets,")
                        .addLoreLine(ChatColor.GRAY + "feed, train, and play with them.")
                        .addLoreLine("")
                        .addLoreLine(ChatColor.YELLOW + "Click to view!")
                        .toItemStack();
            }

            @Override
            public void clicked (Player player, ClickType clickType) {
                // Open the pets menu
            }
    }

    private static class ColoredBarMaterial extends Button {

        @Override
        public ItemStack getItem(Player player) {
            return new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE)
                    .setName(ChatColor.RESET + "")
                    .toItemStack();
        }
    }

}

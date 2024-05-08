package studio.talespire.profile.storage.menus;

import lombok.RequiredArgsConstructor;
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
import studio.talespire.profile.profiles.ProfileHandler;
import studio.talespire.profile.storage.menus.buttons.*;
import studio.talespire.profile.util.buttons.BarButton;

import java.util.HashMap;
import java.util.Map;

public class FavoritesMenu extends Menu {

    private final ProfileHandler profileHandler;

    public FavoritesMenu() {
        this.profileHandler = Profile.getInstance().getProfileHandler();
    }

    @Override
    public String getTitle(Player player) {
        return "Favorites";
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        //-- Header
        buttons.put(getSlot(0, 0), new FavoritesButton(true));
        buttons.put(getSlot(1, 0), new WeaponsButton(false));
        buttons.put(getSlot(2, 0), new ApparelButton(false));
        buttons.put(getSlot(3, 0), new PotionsButton(false));
        buttons.put(getSlot(4, 0), new FoodButton(false));
        buttons.put(getSlot(5, 0), new BooksButton(false));
        buttons.put(getSlot(6, 0), new KeysButton(false));
        buttons.put(getSlot(7, 0), new FishingButton(false));
        buttons.put(getSlot(8, 0), new MiscButton(false));
        for (int i = 0; i < 8 ; i++) {
            buttons.put(getSlot(i, 1), new BarButton());
        }

        //-- Inventory
        ItemStack[] favorites = profileHandler.getProfile(player.getUniqueId()).getSelectedCharacter().getStorage_favorites();

        // Iterate through the player's favorites and add them to the menu
        for (ItemStack item : favorites) {
            if (item == null) continue;
            buttons.put(buttons.size(), new ItemButton(item));
        }

        // Fill the rest of the menu with empty slots
        for (int i = buttons.size(); i < 54; i++) {
            buttons.computeIfAbsent(i, k -> new Button() {
                @Override
                public ItemStack getItem(Player player) {
                    return new ItemBuilder(Material.AIR)
                            .toItemStack();
                }
            });
        }
        return buttons;
    }

    @RequiredArgsConstructor
    private static class ItemButton extends Button {
        private final ItemStack item;

        @Override
        public ItemStack getItem(Player player) {
            return item;
        }

        @Override
        public void clicked(Player player, ClickType clickType) {
            player.getInventory().addItem(item);
        }
    }

}

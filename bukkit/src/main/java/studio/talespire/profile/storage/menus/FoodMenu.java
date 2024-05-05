package studio.talespire.profile.storage.menus;

import org.bukkit.entity.Player;
import studio.lunarlabs.universe.menus.api.Button;
import studio.lunarlabs.universe.menus.api.Menu;
import studio.talespire.profile.storage.menus.buttons.*;

import java.util.HashMap;
import java.util.Map;

public class FoodMenu extends Menu {
    @Override
    public String getTitle(Player player) {
        return "Food";
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        //-- Header
        buttons.put(getSlot(0, 0), new FavoritesButton(false));
        buttons.put(getSlot(0, 1), new WeaponsButton(false));
        buttons.put(getSlot(0, 2), new ApparelButton(false));
        buttons.put(getSlot(0, 3), new PotionsButton(false));
        buttons.put(getSlot(0, 4), new FoodButton(false));
        buttons.put(getSlot(0, 5), new BooksButton(false));
        buttons.put(getSlot(0, 6), new KeysButton(false));
        buttons.put(getSlot(0, 7), new FishingButton(true));
        buttons.put(getSlot(0, 8), new MiscButton(false));

        return buttons;
    }
}

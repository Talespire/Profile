package studio.talespire.profile.storage.menus;

import org.bukkit.entity.Player;
import studio.lunarlabs.universe.menus.api.Button;
import studio.lunarlabs.universe.menus.api.Menu;
import studio.talespire.profile.storage.menus.buttons.*;

import java.util.HashMap;
import java.util.Map;

public class FavoritesMenu extends Menu {
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

        return buttons;
    }

}

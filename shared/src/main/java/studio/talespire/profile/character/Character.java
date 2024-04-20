package studio.talespire.profile.character;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.Inventory;
import studio.talespire.profile.classes.Class;

@Getter
@Setter
public class Character {

    private final Inventory inventory;

    private final int level;
    private final int experience;

    private final Class characterClass;

    public Character() {
        this.inventory = null;
        this.level = 0;
        this.experience = 0;
        this.characterClass = Class.UNDEFINED;
    }
}

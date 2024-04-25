package studio.talespire.profile.character;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;
import studio.talespire.profile.classes.Class;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Character {

    private final int level;
    private final int experience;
    private final Class characterClass;
    private final ItemStack[] inventory;
    private final long creationDate;

    public Character() {
        this.level = 0;
        this.experience = 0;
        this.inventory = new ItemStack[41];
        this.characterClass = Class.UNDEFINED;
        this.creationDate = new Date().getTime();
    }

    public void setInventory(ItemStack[] inventory) {
        System.arraycopy(inventory, 0, this.inventory, 0, inventory.length);
    }
}

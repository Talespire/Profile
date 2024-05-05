package studio.talespire.profile.character;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import studio.talespire.profile.classes.Class;

import java.util.Date;

@Getter
@Setter
public class Character {

    // -- General Chracter Information
    private int level;
    private final int experience;
    private int levelPoints;
    private double coins;

    //-- Class Specific Information
    private final Class characterClass;
    private final ItemStack[] inventory;
    private final long creationDate;

    //-- Character Storage Information
    private final ItemStack[] storage_favorites;

    //-- ActionBar Relevent Information
    @Setter private String actionBarReleventInfo;
    @Getter private final String actionBarReleventDefault;

    //-- Player Stats
    private int maxHealth;
    private int defense;
    private int maxMana;
    private int currentHealth;
    private int currentMana;

    public Character() {

        level = 0;
        experience = 0;
        levelPoints = 0;
        
        inventory = new ItemStack[41];
        characterClass = Class.UNDEFINED;
        creationDate = new Date().getTime();

        storage_favorites = new ItemStack[45];

        actionBarReleventInfo = ((ChatColor.STRIKETHROUGH + "           ") + ChatColor.RESET);
        actionBarReleventDefault = actionBarReleventInfo;

        maxHealth = 100;
        defense = 0;
        maxMana = 100;
        currentHealth = maxHealth;
        currentMana = maxMana;
    }
    
    public void incrementLevel(int amount) {
        level += amount;
        levelPoints += amount;
    }

    public void incrementMana(int amount) {
        currentMana += amount;
        if (currentMana > maxMana) {
            currentMana = maxMana;
        }
    }

    public void incrementHealth(int amount) {
        currentHealth += amount;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }

    public void setInventory(ItemStack[] inventory) {
        System.arraycopy(inventory, 0, inventory, 0, inventory.length);
    }
}

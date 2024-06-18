package studio.talespire.profile.character;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import studio.lunarlabs.universe.Universe;
import studio.talespire.profile.classes.Class;
import studio.talespire.questmind.QuestMind;
import studio.talespire.questmind.quests.Objective;
import studio.talespire.questmind.quests.Quest;
import studio.talespire.questmind.quests.QuestService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class Character {

    // -- General Chracter Information
    private int level;
    private final int experience;
    private int levelPoints;
    private double coins;

    //-- Class Specific Information
    private Class characterClass;
    private final ItemStack[] inventory;
    protected double locationX;
    protected double locationY;
    protected double locationZ;
    private final long creationDate;

    //-- Character Storage Information
    private final ItemStack[] storage_favorites;

    //-- ActionBar Relevent Information
    @Setter private String actionBarReleventInfo;
    @Getter private final String actionBarReleventDefault;

    //-- Player Stats
    private int maxHealth;
    private int currentHealth;
    private int maxMana;
    private int currentMana;
    private int speed;
    private int maxCarryWeight;
    private int currentCarryWeight;
    private int defense;
    private int damage;
    private int strength;

    //-- Quests
    @Setter @Getter private String trackedQuest;
    private final HashMap<String, Integer> activeQuests;
    private final List<String> completedQuests;

    public Character() {

        level = 0;
        experience = 0;
        levelPoints = 0;
        
        inventory = new ItemStack[41];
        characterClass = Class.UNDEFINED;
        creationDate = new Date().getTime();

        locationX = 0.5;
        locationY = 0;
        locationZ = 0.5;

        storage_favorites = new ItemStack[45];

        actionBarReleventInfo = ((ChatColor.STRIKETHROUGH + "           ") + ChatColor.RESET);
        actionBarReleventDefault = actionBarReleventInfo;

        maxHealth = 100;
        currentHealth = maxHealth;
        maxMana = 100;
        currentMana = maxMana;
        speed = 0;
        maxCarryWeight = 100;
        currentCarryWeight = 0;
        defense = 0;
        damage = 0;
        strength = 0;

        trackedQuest = "";
        activeQuests = new HashMap<>();
        completedQuests = new ArrayList<>();
    }

    public void addQuest(Quest quest) {
        activeQuests.put(quest.getQuestName(), 0);
    }

    public int getPlayerObjectiveIndex(String questName) {
        for (String quest : activeQuests.keySet()) {
            if (quest.equals(questName)) {
                return activeQuests.get(quest);
            }
        }
        return 0;
    }

    public void updateQuest(Quest quest, int objectiveIndex) {
        activeQuests.put(quest.getQuestName(), objectiveIndex);
    }

    public void completedQuest(Quest quest) {
        activeQuests.remove(quest.getQuestName());
        completedQuests.add(quest.getQuestName());
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

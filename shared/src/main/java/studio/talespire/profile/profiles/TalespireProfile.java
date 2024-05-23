package studio.talespire.profile.profiles;

import lombok.Data;
import lombok.Getter;
import studio.talespire.profile.Profile;
import studio.talespire.profile.character.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Data
public class TalespireProfile {

    private final UUID uuid;

    private String name;
    @Getter
    private List<Character> characters = new ArrayList<>();// Note: this might need to be more thread safe using a CopyOnWriteArrayList
    private Character selectedCharacter;

    public void load() {

        Profile.getInstance().getProfileHandler().getFromDatabaseFuture(uuid).whenComplete((profile, error) -> {
            if (error != null) {
                error.printStackTrace();
                return;
            }

            if (profile == null) {
                this.save();
                return;
            }

            this.name = profile.getName();
            this.characters = profile.getCharacters();
        });
    }

    public void save() {
        Profile.getInstance().getProfileHandler().saveToDatabase(uuid, this);
    }

    public void createCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character cannot be null");
        }
        characters.add(character);
        this.save();
    }

    public void deleteCharacter(Character character) {
        characters.remove(character);
        this.save();
    }

    public void addCharacter(Character character) {
        characters.add(character);
        this.save();
    }

    public void updateCharacter(Character character) {
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).equals(character)) {
                characters.set(i, character);
                return;
            }
        }
        this.save();
    }
}

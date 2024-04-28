package studio.talespire.profile.skills;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CombatProfile {

    private final int level;
    private final int experience;

    public CombatProfile () {
        this.level = 0;
        this.experience = 0;
    }
}

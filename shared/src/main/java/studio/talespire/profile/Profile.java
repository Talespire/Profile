package studio.talespire.profile;

import lombok.Getter;
import studio.talespire.profile.profiles.ProfileHandler;

import java.nio.file.Path;

/**
 * @author Oliver
 * @date 4/19/2024
 */

@Getter
public abstract class Profile {

    @Getter
    private static Profile instance;

    private final Path dataFolder;

    private final ProfileHandler profileHandler;

    public Profile(Path dataFolder) {
        instance = this;
        this.dataFolder = dataFolder;

        profileHandler = new ProfileHandler();

        // Register services here
    }

    public void disable() {
        // Disable services here
    }

}

package studio.talespire.profile;

import com.mongodb.reactivestreams.client.MongoDatabase;
import lombok.Getter;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.data.mongo.MongoService;
import studio.lunarlabs.universe.registry.ServiceRegistry;
import studio.lunarlabs.universe.registry.ServiceRegistryImpl;
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
    private final MongoDatabase database;

    public Profile(Path dataFolder) {
        instance = this;
        this.dataFolder = dataFolder;
        this.database = Universe.get(MongoService.class).getClient().getDatabase("talespire");
        this.profileHandler = new ProfileHandler();


        // Register services here
    }

    public Profile get() {
        return instance;
    }

    public void disable() {
        // Disable services here
    }

}

package studio.talespire.profile.profiles;

import lombok.Getter;
import studio.lunarlabs.universe.Universe;
import studio.lunarlabs.universe.data.mongo.MongoService;
import studio.lunarlabs.universe.repository.MongoMapRepository;
import studio.talespire.profile.Profile;

import java.util.UUID;

@Getter
public class ProfileHandler extends MongoMapRepository<UUID, TalespireProfile> {

    //TODO: I don't like the fact that this is public, so change it to protected
    public ProfileHandler() {
        super(TalespireProfile.class, Profile.getInstance().getDatabase().getCollection("profiles"));
    }

    public TalespireProfile addProfile(UUID uuid) {
        TalespireProfile profile = new TalespireProfile(uuid);
        addToCache(uuid, profile);
        return profile;
    }

    public TalespireProfile getProfile(UUID uuid) {
        if (uuid == null)
            return null;

        if (getCache().get(uuid) != null)
            return getCache().get(uuid);

        TalespireProfile profile = getFromDatabaseSync(uuid);
        if (profile != null) {
            addToCache(uuid, profile);
            return profile;
        }

        // If profile is not found in cache or database, create a new one
        profile = addProfile(uuid);
        return profile;
    }
}

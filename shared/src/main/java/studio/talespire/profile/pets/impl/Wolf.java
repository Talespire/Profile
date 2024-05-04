package studio.talespire.profile.pets.impl;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import studio.lunarlabs.universe.util.ItemBuilder;
import studio.talespire.profile.pets.Pet;
import studio.talespire.profile.util.Rarities;

import java.util.UUID;

public class Wolf extends Pet {

    @Getter
    private UUID petUUID;

    private final ItemStack head = new ItemBuilder(Material.PLAYER_HEAD)
            .setSkullOwner("MHF_Wolf")
            .toItemStack();;

    public Wolf() {
        super("wolf", Rarities.RARE, 0, 100, 0);
    }


    @Override
    public ItemStack getHead() {
        return head;
    }

    @Override
    public void spawn(Player player) {
        Location location = player.getLocation();
        location.setY(location.getY() + 1);

//        Parrot parrot = player.getWorld().spawn(location, Parrot.class);
//        parrot.setInvisible(true);
//        parrot.setInvulnerable(true);
//        parrot.setOwner(player);

        org.bukkit.entity.Wolf wolf = player.getWorld().spawn(location, org.bukkit.entity.Wolf.class);
        wolf.setCustomName(getName());
        wolf.setInvisible(true);
        wolf.setInvulnerable(true);
        wolf.setOwner(player);

        petUUID = wolf.getUniqueId();

        ArmorStand petStand = player.getWorld().spawn(location, ArmorStand.class);
        petStand.setCustomName(getName());
        petStand.setCustomNameVisible(true);
        petStand.setGravity(false);
        petStand.setVisible(false);

        petStand.getEquipment().setBoots(getHead());

        wolf.setPassenger(petStand);
    }

    @Override
    public void despawn(Player player, UUID uuid) {
        for (org.bukkit.entity.Entity entity : player.getWorld().getEntities()) {
            if (entity.getUniqueId().equals(uuid)) {
                entity.remove();
            }
        }
    }
}

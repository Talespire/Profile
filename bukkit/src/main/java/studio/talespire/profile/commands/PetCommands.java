package studio.talespire.profile.commands;

import me.andyreckt.raspberry.annotation.Children;
import me.andyreckt.raspberry.annotation.Command;
import me.andyreckt.raspberry.annotation.Param;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import studio.talespire.profile.pets.impl.Wolf;

@Command(names = "pet", permission = "talespire.command.pet")
public class PetCommands {

    @Children(names = "spawn")
    public void spawnWolf(CommandSender sender, @Param(name = "Pet Name") String petName) {
        if (petName.equalsIgnoreCase("wolf")) {
            Wolf wolf = new Wolf();
            wolf.spawn((Player) sender);
        }
    }

}

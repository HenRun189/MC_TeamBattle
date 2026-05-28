package me.HenRun189.teamBattel;

import it.unimi.dsi.fastutil.Hash;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SwitchWorldCommand implements CommandExecutor, TabCompleter {

    public SwitchWorldCommand() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        HashMap<String, Player> nameList = new HashMap<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            nameList.put(p.getName(), p);
        }


            Player p = nameList.get(sender.getName());

            switch (args[0]) {
                case "battle" -> {
                    World world = Bukkit.getWorld("battleworld");
                    Location spawnLoc = new Location(world,0.0,0.0, 0.0);
                    try {
                        spawnLoc = world.getSpawnLocation();
                    }
                    catch (Exception e) {
                        sender.sendMessage("§Wahrscheinlich gibt es keinen world spawn in dieser Welt");
                    }
                    finally {
                        p.teleport(spawnLoc);
                        return true;
                    }
                }

                case "farming" -> {
                    World world = Bukkit.getWorld("farmingworld");
                    Location spawnLoc = world.getSpawnLocation();
                    if (spawnLoc == null) {
                        spawnLoc = new Location(world,0.0,0.0, 0.0);
                    }
                    p.teleport(spawnLoc);
                    return true;
                }
                default -> {
                    sender.sendMessage("§Diese Welt gibt es nicht!!!!!!");
                }
            }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 0) {
            List<String> options = new ArrayList<>();

            options.add("battle");
            options.add("farming");

            return options;
        }

        return Collections.emptyList();
    }
}

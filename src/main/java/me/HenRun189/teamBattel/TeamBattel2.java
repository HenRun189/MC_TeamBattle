package me.HenRun189.teamBattel;
import java.util.HashMap;
import org.bukkit.*;
import org.bukkit.entity.Player;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;


import java.util.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeamBattel2 {
    private HashMap<Player, UUID> players;

    public void spawnTeamMob(String mobName, EntityType type, Location loc, double health) {
        World world = Bukkit.getWorld("battleworld");
        LivingEntity entity = (LivingEntity) world.spawnEntity(loc, type);

        entity.setCustomName(mobName);
        entity.setCustomNameVisible(true);

        entity.setMaxHealth(health);
        entity.setHealth(health);
    }
}
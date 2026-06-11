package me.HenRun189.teamBattel.teams;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import org.bukkit.*;
import org.bukkit.entity.Player;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;


import java.util.*;

public final class TeamData {

    private HashMap<UUID, Player> players;
    private String name;
    private Entity flagEntity;
    double entityHealth;

    public TeamData(String p_name) {
        name = p_name;
        entityHealth = 100;
    }

    public void addPlayer(Player player) {
        players.put(player.getUniqueId(), player);
    }

    public void removePlayer(Player player) {
        players.remove(player.getUniqueId());
    }

    public void spawnTeamMob(String mobName, EntityType type, Location loc, double health, World world, boolean ai) {
        LivingEntity entity = (LivingEntity) world.spawnEntity(loc, type);

        entity.setCustomName(mobName);
        entity.setCustomNameVisible(true);

        entity.setMaxHealth(health);
        entity.setHealth(health);

        entity.setAI(ai);
    }

    public HashMap<UUID, Player> getPlayers() {
        return players;
    }

    public String getName() {
        return this.name;
    }

    public Entity getFlagEntityEntity() {
        return flagEntity;
    }

    public double getEntityHealth() {
        return entityHealth;
    }

    public void setEntityHealth(double p_entityHealth) {
        entityHealth = p_entityHealth;
    }
}

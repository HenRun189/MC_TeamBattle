package me.HenRun189.mCServer1;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.Map;

public class TeamManager {

    private Scoreboard board;
    private Map<String, Integer> points = new HashMap<>();

    public TeamManager() {
        board = Bukkit.getScoreboardManager().getNewScoreboard();

        createTeam("red", ChatColor.RED);
        createTeam("blue", ChatColor.BLUE);
    }

    private void createTeam(String name, ChatColor color) {
        Team team = board.registerNewTeam(name);
        team.setColor(color);
        team.setDisplayName(color + name.toUpperCase());

        points.put(name, 0);
    }

    public void addPlayer(Player player, String teamName) {
        Team team = board.getTeam(teamName);
        if (team != null) {
            team.addEntry(player.getName());
            player.setScoreboard(board);
        }
    }

    public void addPoints(String teamName, int amount) {
        points.put(teamName, points.getOrDefault(teamName, 0) + amount);
    }

    public int getPoints(String teamName) {
        return points.getOrDefault(teamName, 0);
    }

    public Scoreboard getBoard() {
        return board;
    }

    public Map<String, Integer> getAllPoints() {
        return points;
    }
}
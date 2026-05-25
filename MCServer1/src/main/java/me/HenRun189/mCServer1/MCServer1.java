package me.HenRun189.mCServer1;

import org.bukkit.plugin.java.JavaPlugin;
import me.HenRun189.mCServer1.JoinCommand;

public final class MCServer1 extends JavaPlugin {

    private static MCServer1 instance;
    private TeamManager teamManager;
    private ScoreboardManager scoreboardManager;

    @Override
    public void onEnable() {
        instance = this;

        teamManager = new TeamManager();
        scoreboardManager = new ScoreboardManager(teamManager);

        getCommand("join").setExecutor(new JoinCommand()); // 👈 DAS HIER


        getLogger().info("Plugin gestartet!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin gestoppt!");
    }

    public static MCServer1 getInstance() {
        return instance;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }
}
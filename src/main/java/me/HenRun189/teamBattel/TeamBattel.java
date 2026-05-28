package me.HenRun189.teamBattel;

import io.papermc.paper.command.brigadier.BasicCommand;
import me.HenRun189.teamBattel.SwitchWorldCommand;
import me.HenRun189.teamBattel.teams.TeamManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class TeamBattel extends JavaPlugin {

    TeamManager teamManager;

    @Override
    public void onEnable() {
        // Plugin startup logic

        registerCommand("tpw", (BasicCommand) new SwitchWorldCommand());
        registerCommand("team", (BasicCommand) new TeamCommand(teamManager));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

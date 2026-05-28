package me.HenRun189.teamBattel;

import me.HenRun189.teamBattel.teams.TeamManager;
import me.HenRun189.teamBattel.teams.TeamData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamCommand implements CommandExecutor, TabCompleter {

    private TeamManager teamManager;

    public TeamCommand(TeamManager p_teamManager) {
        teamManager = p_teamManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        switch (args[0]) {

            case "createTeam" -> {

                TeamData teamData = new TeamData(args[1]);

                teamManager.addTeam(teamData);
                return true;
            }

            case "addMember" -> {

                for (TeamData teamData : teamManager.getTeamsList()) {
                    if (teamData.getName().equals(args[1])) {

                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if (p.getName().equals(args[2])) {
                                teamData.addPlayer(p);
                                return true;
                            }
                        }
                        break;
                    }
                }
            }

            case "removeMember" -> {

                for (TeamData teamData : teamManager.getTeamsList()) {
                    if (teamData.getName().equals(args[1])) {

                        for (Player p : teamData.getPlayers().values()) {
                            if (p.getName().equals(args[2])) {
                                teamData.removePlayer(p);
                                return true;
                            }
                        }
                        break;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> options = new ArrayList<>();

        if (args.length == 0) {

            options.add("battle");
            options.add("farming");

            return options;
        }

        switch (args[0]) {

            case "createTeam" -> {
                // kann man auswähen, man muss glaube ich nicht emphelen oder so
            }

            case "addMember" -> {

                if (args.length == 1) {
                    for (TeamData teamData : teamManager.getTeamsList()) {
                        options.add(teamData.getName());
                    }
                }

                for (TeamData teamData : teamManager.getTeamsList()) {
                    if (teamData.getName().equals(args[1])) {

                        if (args.length == 2) {
                            for (Player player : teamData.getPlayers().values()) {
                                options.add(player.getName());
                            }
                        }
                    }
                }
            }

            case "removeMember" -> {

                if (args.length == 1) {
                    for (TeamData teamData : teamManager.getTeamsList()) {
                        options.add(teamData.getName());
                    }
                }

                for (TeamData teamData : teamManager.getTeamsList()) {
                    if (teamData.getName().equals(args[1])) {

                        if (args.length == 2) {
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                options.add(player.getName());
                            }
                        }
                    }
                }
            }
        }

        return Collections.emptyList();
    }
}

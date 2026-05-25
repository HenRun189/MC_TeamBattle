package me.HenRun189.mCServer1;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) return true;

        if (args.length == 0) {
            player.sendMessage("§cBenutze: /join <red|blue>");
            return true;
        }

        String team = args[0].toLowerCase();

        if (!team.equals("red") && !team.equals("blue")) {
            player.sendMessage("§cNur red oder blue!");
            return true;
        }

        MCServer1.getInstance().getTeamManager().addPlayer(player, team);
        MCServer1.getInstance().getScoreboardManager().setScoreboard(player);

        player.sendMessage("§aDu bist jetzt im Team " + team + "!");
        return true;
    }
}
package me.HenRun189.teamBattel;
import me.HenRun189.teamBattel.teams.TeamData;
import me.HenRun189.teamBattel.teams.TeamManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class TeamBattleGameMode implements Listener {

    TeamManager teamManager;

    TeamBattleGameMode(TeamManager p_teamManager) {
        teamManager = p_teamManager;
    }

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event) {

        Entity target = event.getEntity();

        for (TeamData teamData : teamManager.getTeamsList())
            if (target.getCustomName().equals(teamData.getName())) {

            }
    }
}

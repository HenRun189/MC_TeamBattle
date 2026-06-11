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

                event.isCancelled();

                Entity damageSource = event.getDamageSource().getCausingEntity();

                if (damageSource instanceof Player) {
                    Player damager = (Player) damageSource;

                    for (TeamData testTeam : teamManager.getTeamsList()) {
                        for (Player player : testTeam.getPlayers().values()) {
                            if (damager.getUniqueId() == player.getUniqueId() && !(teamData.getName().equals(testTeam.getName()))) {
                                teamData.setEntityHealth(event.getDamage());
                            }

                        }
                    }
                }
            }

    }
}

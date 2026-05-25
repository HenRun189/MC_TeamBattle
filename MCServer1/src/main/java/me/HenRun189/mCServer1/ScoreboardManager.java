package me.HenRun189.mCServer1;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardManager {

    private TeamManager teamManager;
    private Scoreboard board;
    private Objective obj;

    public ScoreboardManager(TeamManager teamManager) {
        this.teamManager = teamManager;

        board = Bukkit.getScoreboardManager().getNewScoreboard();
        obj = board.registerNewObjective("game", "dummy", "§6§lTURNIER");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    public void setScoreboard(Player player) {
        player.setScoreboard(board);
    }

    public void update() {
        board.getEntries().forEach(board::resetScores);

        int score = 10;

        for (String team : teamManager.getAllPoints().keySet()) {
            int points = teamManager.getPoints(team);

            obj.getScore("§f" + team + ": " + points).setScore(score);
            score--;
        }
    }
}

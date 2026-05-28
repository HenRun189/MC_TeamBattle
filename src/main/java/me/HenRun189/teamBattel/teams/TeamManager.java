package me.HenRun189.teamBattel.teams;


import me.HenRun189.teamBattel.TeamBattel;

import java.util.ArrayList;
import java.util.List;

public class TeamManager {

    private List<TeamData> teamsList = new ArrayList<>();

    public void addTeam(TeamData teamData) {
        teamsList.add(teamData);
    }

    public List<TeamData> getTeamsList() {
        return teamsList;
    }
}

package minix6;

import java.util.List;

interface TeamFormationStrategy {
    List<List<Player>> formTeams(List<Player> players, int teamSize);
}

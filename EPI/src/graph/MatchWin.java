package graph;

import java.util.*;

public class MatchWin {
    static class MatchResult {
        public String winningTeam;
        public String losingTeam;
        public MatchResult ( String winningTeam, String losingTeam) {
            this.winningTeam = winningTeam;
            this.losingTeam = losingTeam;
        }
    }
    public static boolean canTeamABeatTeamB(List<MatchResult> matches, String teamA, String teamB) {
        return isReachableDfs(buildGraph(matches),teamA,teamB,new HashSet<>());


    }
    private static Map<String, Set<String>> buildGraph (List<MatchResult> matches) {
        Map<String, Set<String>> graph = new HashMap<>();
        for(MatchResult match: matches) {
            graph.putIfAbsent(match.winningTeam,new HashSet<>()).add(match.losingTeam);
        }
        return graph;
    }
    private static boolean isReachableDfs(Map<String, Set<String>> graph, String curr, String dest, Set<String> visited) {
        if(curr.equals(dest)) {
            return true;
        }
        else if (visited.contains(curr) || graph.get(curr) == null)
            return false;
        visited.add(curr);
        return graph.get(curr).stream().anyMatch(team -> isReachableDfs(graph,team,dest,visited));
    }
}

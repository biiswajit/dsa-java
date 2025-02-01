import java.util.HashMap;

/*
Difficulty: Easy
Problem: Tournament winner
Pattern: Linear search with hashmap
 */
public class TournamentWinner {
    // O(n) time | O(p) space, where p is the number of distinct players
    static String solution(String[][] competitions, int[] result) {
        // hashmap to keep track of number of wins per player
        HashMap<String, Integer> wins = new HashMap<String, Integer>();
        // populate the hashmap with the number of wins per player, on the basis of result
        for (int i=0; i<result.length; i++) {
            String player = competitions[i][0];
            if (result[i] == 0) player = competitions[i][1];
            wins.put(player, wins.getOrDefault(player, 0) + 1);
        }
        // find the player with the maximum wins
        String winner = "";
        int maxScore = -1;
        for (String player : wins.keySet()) {
            int score = wins.get(player);
            if (score > maxScore) {
                maxScore = score;
                winner = player;
            }
        }
        return winner;
    }
}

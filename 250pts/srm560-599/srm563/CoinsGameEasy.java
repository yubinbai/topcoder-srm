import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CoinsGameEasy {
    String[] board;
    int n, m, ans;
    int[][] direct = {{ -1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int minimalSteps(String[] board) {
        int p1r = -1, p1c = -1, p2r = -1, p2c = -1;
        this.board = board;
        n = board.length;
        m = board[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'o') {
                    if (p1r == -1) {
                        p1r = i;
                        p1c = j;
                    } else {
                        p2r = i;
                        p2c = j;
                    }
                }
            }
        }
        ans = 11;
        dfs(0, p1r, p1c, p2r, p2c);
        return (ans == 11) ? -1 : ans;
    }

    public void dfs(int depth, int p1r, int p1c, int p2r, int p2c) {
        if (depth == ans) return;
        boolean one = ( p1r >= 0 && p1r < n && p1c >= 0 && p1c < m );
        boolean two = ( p2r >= 0 && p2r < n && p2c >= 0 && p2c < m );
        if (one ^ two) {
            ans = depth;
            return;
        }
        if (!one && !two) return;
        for (int d = 0; d < 4; d++) {
            int r = p1r + direct[d][0], c = p1c + direct[d][1];
            int rr = p2r + direct[d][0], cc = p2c + direct[d][1];
            if (r >= 0 && r < n && c >= 0 && c < m && board[r].charAt(c) == '#') {
                r -= direct[d][0];
                c -= direct[d][1];
            }
            if (rr >= 0 && rr < n && cc >= 0 && cc < m && board[rr].charAt(cc) == '#') {
                rr -= direct[d][0];
                cc -= direct[d][1];
            }
            dfs(depth + 1, r, c, rr, cc);
        }
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p0[i] + "\"");
        }
        System.out.print("}");
        System.out.println("]");
        CoinsGameEasy obj;
        int answer;
        obj = new CoinsGameEasy();
        long startTime = System.currentTimeMillis();
        answer = obj.minimalSteps(p0);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p1);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p1;
        }
        if (!res) {
            System.out.println("DOESN'T MATCH!!!!");
        } else if ((endTime - startTime) / 1000.0 >= 2) {
            System.out.println("FAIL the timeout");
            res = false;
        } else if (hasAnswer) {
            System.out.println("Match :-)");
        } else {
            System.out.println("OK, but is it right?");
        }
        System.out.println("");
        return res;
    }
    public static void main(String[] args) {
        boolean all_right;
        all_right = true;

        String[] p0;
        int p1;

        // ----- test 0 -----
        p0 = new String[] {"oo"};
        p1 = 1;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new String[] {".#", ".#", ".#", "o#", "o#", "##"};
        p1 = 4;
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new String[] {"..", "..", "..", "o#", "o#", "##"};
        p1 = 3;
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new String[] {"###", ".o.", "###", ".o.", "###"};
        p1 = -1;
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new String[] {"###", ".o.", "#.#", ".o.", "###"};
        p1 = 3;
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new String[] {"###########", "........#o#", "###########", ".........o#", "###########"};
        p1 = 10;
        all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
        // ------------------

        // ----- test 6 -----
        p0 = new String[] {"############", ".........#o#", "############", "..........o#", "############"};
        p1 = -1;
        all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // We are playing a game with a pair of coins on a rectangular board.
    // The board is divided into unit square cells.
    // Each cell is either empty, or it contains an obstacle.
    // The board is given to you as a String[] board.
    // The character '#' represents an obstacle, '.' is an empty cell, and 'o' is an empty cell with a coin.
    // You may assume that there are exactly two coins on the board, and that initially they lie in different cells.
    //
    //
    //
    // Next to the board, there are 4 buttons labeled "Left", "Right", "Up", and "Down".
    // The game is played by pushing these buttons.
    // When you push a button, all coins will try to move one cell in the corresponding direction.
    // For each coin, there can be three different outcomes:
    //
    // If the next cell in the chosen direction contains an obstacle, the coin remains in its current cell.
    // If there is no next cell in the chosen direction (i.e., if the coin is already on the corresponding edge of the board), the coin falls off the board.
    // In all other cases, the coin moves one cell in the chosen direction. Note that this includes the case when the destination cell currently contains another coin.
    //
    //
    //
    //
    // The goal of the game is to make exactly one coin fall off the board.
    // If that is impossible, or if you need to push more than 10 buttons in order to achieve the goal, return -1.
    // Otherwise, return the smallest number of times you need to push a button in order to achieve the goal.
    //
    // DEFINITION
    // Class:CoinsGameEasy
    // Method:minimalSteps
    // Parameters:String[]
    // Returns:int
    // Method signature:int minimalSteps(String[] board)
    //
    //
    // NOTES
    // -There may be some sequences of moves that will cause both coins to end in the same cell. Note that when trying to win the game such moves should be avoided.
    //
    //
    // CONSTRAINTS
    // -board will contain between 1 and 20 elements, inclusive.
    // -Every element of board will have the same length, and this length will be between 1 and 20, inclusive.
    // -Each character in each element of board will be one of '#', 'o' and '.'.
    // -There will be exactly 2 'o' in board.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {"oo"}
    //
    // Returns: 1
    //
    // Push the Left button. The left coin will fall, the right one will move one step left and it will still be on the board.
    //
    // 1)
    // {".#",
    //  ".#",
    //  ".#",
    //  "o#",
    //  "o#",
    //  "##"}
    //
    // Returns: 4
    //
    // You need to push the Up button 4 times in a row.
    //
    // 2)
    // {"..",
    //  "..",
    //  "..",
    //  "o#",
    //  "o#",
    //  "##"}
    //
    // Returns: 3
    //
    // As in Example 1, this game can be won by pushing the Up button 4 times. However, there is also a shorter solution: push Up, Right, and Right, in this order.
    //
    // 3)
    // {"###",
    //  ".o.",
    //  "###",
    //  ".o.",
    //  "###"}
    //
    // Returns: -1
    //
    //
    //
    // 4)
    // {"###",
    //  ".o.",
    //  "#.#",
    //  ".o.",
    //  "###"}
    //
    // Returns: 3
    //
    //
    //
    // 5)
    // {"###########",
    //  "........#o#",
    //  "###########",
    //  ".........o#",
    //  "###########"}
    //
    // Returns: 10
    //
    //
    //
    // 6)
    // {"############",
    //  ".........#o#",
    //  "############",
    //  "..........o#",
    //  "############"}
    //
    // Returns: -1
    //
    // You need at least 11 steps to win the game, so you should return -1.
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

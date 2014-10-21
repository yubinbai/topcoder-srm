import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class FoxAndGo {
    int n, m;
    char[][] b;
    class Component {
        int size;
        HashSet<ArrayList<Integer>> empty = new HashSet<ArrayList<Integer>>();

        public Component () {  }
    }
    ArrayList<Component> com;
    /**
     * SRM 590
     * @param board
     * @return
     */
    public int maxKill(String[] board) {
        n = board.length;
        m = board[0].length();
        b = new char[n][m];
        for (int i = 0; i < n; i++) {
            b[i] = board[i].toCharArray();
        }
        com = new ArrayList<Component>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j] == 'o') {
                    Component c = new Component();
                    c.size = dfs(i, j, c);
                    com.add(c);
                }
            }
        }
        int dead = 0;
        int[][] e = new int[n][m];
        for (Component c : com) {
            int emptyCount = c.empty.size();
            if (emptyCount == 0) {
                dead += c.size;
            } else if (emptyCount == 1) {
                int row = 0, col = 0;
                for (ArrayList<Integer> a : c.empty) {
                    row = a.get(0);
                    col = a.get(1);
                }
                e[row][col] += c.size;
            }
        }
        int max = 0;
        for (int[] arr : e) {
            for (int i : arr) {
                max = Math.max(max, i);
            }
        }
        return dead + max;
    }

    private int dfs(int i, int j, Component c) {
        int count = 0;
        if (i < 0 || i >= n || j < 0 || j >= n) return count;
        if (b[i][j] == 'o') {
            b[i][j] = 'a';
            count = 1 + dfs(i, j + 1, c) + dfs(i + 1, j, c) + dfs(i - 1, j, c) + dfs(i, j - 1, c);
        } else if (b[i][j] == '.') {
            ArrayList<Integer> alist = new ArrayList<Integer>();
            alist.add(i);
            alist.add(j);
            c.empty.add(alist);
        }
        return count;
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
        FoxAndGo obj;
        int answer;
        obj = new FoxAndGo();
        long startTime = System.currentTimeMillis();
        answer = obj.maxKill(p0);
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

        // ----- test 4 -----
        p0 = new String[] {".......", ".xxxxx.", ".xooox.", ".xo.ox.", ".xooox.", ".xxxxx.", "......."};
        p1 = 8;
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

        // ----- test 0 -----
        p0 = new String[] {".....", "..x..", ".xox.", ".....", "....."};
        p1 = 1;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new String[] {"ooooo", "xxxxo", "xxxx.", "xxxx.", "ooooo"};
        p1 = 6;
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new String[] {".xoxo", "ooxox", "oooxx", "xoxox", "oxoox"};
        p1 = 13;
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new String[] {".......", ".......", ".......", "xxxx...", "ooox...", "ooox...", "ooox..."};
        p1 = 9;
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new String[] {"o.xox.o", "..xox..", "xxxoxxx", "ooo.ooo", "xxxoxxx", "..xox..", "o.xox.o"};
        p1 = 12;
        all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
        // ------------------

        // ----- test 6 -----
        p0 = new String[] {".......", "..xx...", ".xooox.", ".oxxox.", ".oxxxo.", "...oo..", "......."};
        p1 = 4;
        all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
        // ------------------

        // ----- test 7 -----
        p0 = new String[] {".ox....", "xxox...", "..xoox.", "..xoox.", "...xx..", ".......", "......."};
        p1 = 5;
        all_right = KawigiEdit_RunTest(7, p0, true, p1) && all_right;
        // ------------------

        // ----- test 8 -----
        p0 = new String[] {"...................", "...................", "...o..........o....", "................x..", "...............x...", "...................", "...................", "...................", "...................", "...................", "...................", "...................", "...................", "...................", "................o..", "..x................", "...............x...", "...................", "..................."};
        p1 = 0;
        all_right = KawigiEdit_RunTest(8, p0, true, p1) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Fox Ciel is teaching her friend Jiro to play Go.
    // Ciel has just placed some white and some black tokens onto a board.
    // She now wants Jiro to find the best possible move.
    // (This is defined more precisely below.)
    //
    //
    // You are given a String[] board.
    // Character j of element i of board represents the cell (i,j) of the board:
    // 'o' is a cell with a white token, 'x' a cell with a black token, and '.' is an empty cell.
    // At least one cell on the board will be empty.
    //
    //
    // Jiro's move will consist of adding a single black token to the board.
    // The token must be placed onto an empty cell.
    // Once Jiro places the token, some white tokens will be removed from the board according to the rules described in the next paragraphs.
    //
    //
    // The white tokens on the board can be divided into connected components using the following rules:
    // If two white tokens lie in cells that share an edge, they belong to the same component.
    // Being in the same component is transitive: if X lies in the same component as Y and Y lies in the same component as Z, then X lies in the same component as Z.
    //
    //
    // Each component of white tokens is processed separately.
    // For each component of white tokens we check whether it is adjacent to an empty cell.
    // (That is, whether there are two cells that share an edge such that one of them is empty and the other contains a white token from the component we are processing.)
    // If there is such an empty cell, the component is safe and its tokens remain on the board.
    // If there is no such empty cell, the component is killed and all its tokens are removed from the board.
    //
    //
    // Jiro's score is the total number of white tokens removed from the board after he makes his move.
    // Return the maximal score he can get for the given board.
    //
    //
    // DEFINITION
    // Class:FoxAndGo
    // Method:maxKill
    // Parameters:String[]
    // Returns:int
    // Method signature:int maxKill(String[] board)
    //
    //
    // NOTES
    // -The position described by board does not have to be a valid Go position. In particular, there can already be components of white tokens that have no adjacent empty cell.
    // -Please ignore official Go rules. The rules described in the problem statement are slightly different. For example, in this problem the black tokens cannot be killed, and it is allowed to place the black token into any empty cell.
    //
    //
    // CONSTRAINTS
    // -n will be between 2 and 19, inclusive.
    // -board will contain exactly n elements.
    // -Each element in board will contain exactly n characters.
    // -Each character in board will be 'o', 'x' or '.'.
    // -There will be at least one '.' in board.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {".....",
    //  "..x..",
    //  ".xox.",
    //  ".....",
    //  "....."}
    //
    //
    // Returns: 1
    //
    // To kill the only white token, Jiro must place his black token into the cell (3,2). (Both indices are 0-based.)
    //
    // 1)
    // {"ooooo",
    //  "xxxxo",
    //  "xxxx.",
    //  "xxxx.",
    //  "ooooo"}
    //
    //
    // Returns: 6
    //
    // By placing the token to the cell (2,4) Jiro kills 6 white tokens. The other possible move only kills 5 tokens.
    //
    // 2)
    // {".xoxo",
    //  "ooxox",
    //  "oooxx",
    //  "xoxox",
    //  "oxoox"}
    //
    //
    // Returns: 13
    //
    // There is only one possible move. After Jiro makes it, all the white tokens are killed.
    //
    // 3)
    // {".......",
    //  ".......",
    //  ".......",
    //  "xxxx...",
    //  "ooox...",
    //  "ooox...",
    //  "ooox..."}
    //
    //
    // Returns: 9
    //
    // Regardless of where Jiro moves, the 9 white tokens in the lower left corner will be killed.
    //
    // 4)
    // {".......",
    //  ".xxxxx.",
    //  ".xooox.",
    //  ".xo.ox.",
    //  ".xooox.",
    //  ".xxxxx.",
    //  "......."}
    //
    //
    // Returns: 8
    //
    //
    //
    // 5)
    // {"o.xox.o",
    //  "..xox..",
    //  "xxxoxxx",
    //  "ooo.ooo",
    //  "xxxoxxx",
    //  "..xox..",
    //  "o.xox.o"}
    //
    //
    // Returns: 12
    //
    //
    //
    // 6)
    // {".......",
    //  "..xx...",
    //  ".xooox.",
    //  ".oxxox.",
    //  ".oxxxo.",
    //  "...oo..",
    //  "......."}
    //
    // Returns: 4
    //
    //
    //
    // 7)
    // {".ox....",
    //  "xxox...",
    //  "..xoox.",
    //  "..xoox.",
    //  "...xx..",
    //  ".......",
    //  "......."}
    //
    //
    // Returns: 5
    //
    //
    //
    // 8)
    // {"...................",
    //  "...................",
    //  "...o..........o....",
    //  "................x..",
    //  "...............x...",
    //  "...................",
    //  "...................",
    //  "...................",
    //  "...................",
    //  "...................",
    //  "...................",
    //  "...................",
    //  "...................",
    //  "...................",
    //  "................o..",
    //  "..x................",
    //  "...............x...",
    //  "...................",
    //  "..................."}
    //
    //
    // Returns: 0
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

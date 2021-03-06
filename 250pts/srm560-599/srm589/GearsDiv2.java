import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

/**
 * SRM 589
 */
public class GearsDiv2 {
    int size;
    int size2;
    boolean[][] memo;
    int[][] dp;

    public int getmin(String Directions) {
        String round = Directions + Directions;
        size = Directions.length();
        size2 = size * 2;
        memo = new boolean[size2][size2];
        dp = new int[size2][size2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < size2; i++) {
            memo[i][i] = true;
            for (int j = i + 1; j < size2; j++) {
                if (round.charAt(j) != round.charAt(j - 1) && memo[i][j - 1]) {
                    memo[i][j] = true;
                }
            }
        }
        if (memo[0][size] == true) {
            // no need to cut
            return 0;
        } else {
            // cut somewhere
            int ret = Integer.MAX_VALUE;
            for (int cut = 0; cut < size; ++cut) {
                ret = Math.min(ret, solve(
                                   (cut + 1 + size) % size,
                                   (cut - 1 + size) % size
                               ));
            }
            return 1 + ret;
        }
    }

    private int solve(int left, int right) {
        left %= size;
        right %= size;
        if (right < left) right += size;
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        if (memo[left][right]) {
            return 0;
        } else {
            int ret = Integer.MAX_VALUE;
            ret = Math.min(ret, 1 + solve(left + 1, right));
            ret = Math.min(ret, 1 + solve(left, right - 1));
            for (int i = left + 1; i < right; i++) {
                ret = Math.min(ret, 1 + solve(left, i - 1) + solve(i + 1, right));
            }
            dp[left][right] = ret;
            return ret;
        }
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
        System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
        System.out.println("]");
        GearsDiv2 obj;
        int answer;
        obj = new GearsDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.getmin(p0);
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

        String p0;
        int p1;

        // ----- test 0 -----
        p0 = "LRRR";
        p1 = 1;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = "RRR";
        p1 = 2;
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = "LRLR";
        p1 = 0;
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = "LRLLRRLLLRRRLLLL";
        p1 = 6;
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = "RRRRRRRLRRRRRRRLRLRLLRLRLRLRRLRLRLLLRLRLLRLLRRLRRR";
        p1 = 14;
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Goose Tattarrattat has a machine that contains N gears (cogwheels).
    // The gears are numbered 0 through N-1.
    // Currently, the gears are arranged into a cycle: for each i, gear i meshes with gears i-1 and i+1 (counting modulo N).
    // In particular, gear 0 meshes with gear N-1.
    //
    // Let X and Y be two meshing gears.
    // Note that if X is turning, Y must clearly be turning in the opposite direction (clockwise vs. counter-clockwise).
    //
    // For each of the N gears we have a desired direction of turning.
    // You are given this information encoded as a String Directions.
    // Character i of Directions is 'R' if we want gear i to turn to the right (clockwise), and it is 'L' if we want it to turn to the left.
    //
    // Of course, it may be impossible to satisfy all the desired directions of turning.
    // Return the minimal number of gears that have to be removed from the machine so that all remaining gears can turn in the desired directions at the same time.
    //
    // DEFINITION
    // Class:GearsDiv2
    // Method:getmin
    // Parameters:String
    // Returns:int
    // Method signature:int getmin(String Directions)
    //
    //
    // NOTES
    // -Removing a gear creates a gap between the other gears. For example, after removing the gear 7, gears 6 and 8 will not mesh.
    //
    //
    // CONSTRAINTS
    // -Directions will contain between 3 and 50 characters, inclusive.
    // -Each character of Directions will be 'R' or 'L'.
    //
    //
    // EXAMPLES
    //
    // 0)
    // "LRRR"
    //
    // Returns: 1
    //
    // Once we remove gear 2, the other three are free to turn in the desired directions.
    //
    // 1)
    // "RRR"
    //
    // Returns: 2
    //
    // Gear 0 meshes with gear 2.
    //
    // 2)
    // "LRLR"
    //
    // Returns: 0
    //
    //
    //
    // 3)
    // "LRLLRRLLLRRRLLLL"
    //
    // Returns: 6
    //
    //
    //
    // 4)
    // "RRRRRRRLRRRRRRRLRLRLLRLRLRLRRLRLRLLLRLRLLRLLRRLRRR"
    //
    // Returns: 14
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class EmoticonsDiv2 {
    int dp[][];
    int total;

    public int printSmiles(int smiles) {
        dp = new int[smiles + 1][smiles + 1];
        for (int[] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE);
        dp[1][0] = 0;
        total = smiles;
        int ans = r(smiles - 1 , 1);
        return 1 + ans;
    }

    private int r(int target, int clip) {
        if (target < clip) return Integer.MAX_VALUE - 30;
        if (target == 0) return 0;
        if (target == clip) return 1;
        if (target < 0) return Integer.MAX_VALUE - 30;
        if (dp[target][clip] != Integer.MAX_VALUE) return dp[target][clip];

        int ans = Integer.MAX_VALUE;
        if (target % clip == 0) ans = Math.min(ans, 1 + r(target - clip, clip));
        int iHave = total - target;
        ans = Math.min(ans, 2 + r(target - iHave, iHave));
        return dp[target][clip] = ans;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, int p1) {
        System.out.print("Test " + testNum + ": [" + p0);
        System.out.println("]");
        EmoticonsDiv2 obj;
        int answer;
        obj = new EmoticonsDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.printSmiles(p0);
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

        int p0;
        int p1;

        // ----- test 0 -----
        p0 = 2;
        p1 = 2;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 6;
        p1 = 5;
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 11;
        p1 = 11;
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 16;
        p1 = 8;
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = 1000;
        p1 = 21;
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
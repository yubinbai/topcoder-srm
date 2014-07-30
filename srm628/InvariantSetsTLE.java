import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class InvariantSets {
    int n;
    long ret;
    int[] f;
    boolean[] curr;
    private void count(int step) {
        boolean flag = true;;
        for (int i = 0; i < step; i++) {
            if (curr[i] && !curr[f[i]]) {
                flag = false;
                break;
            }
        }
        if (flag) ret++;
        for (int i = step; i < n; i++) {
            curr[i] = true;
            count(i + 1);
            curr[i] = false;
        }
    }

    public long countSets(int[] f) {
        this.ret = 0;
        this.n = f.length;
        this.f = f;
        curr = new boolean[n];
        count(0);
        return this.ret;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, long p1) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p0[i]);
        }
        System.out.print("}");
        System.out.println("]");
        InvariantSets obj;
        long answer;
        obj = new InvariantSets();
        long startTime = System.currentTimeMillis();
        answer = obj.countSets(p0);
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

        int[] p0;
        long p1;

        // ----- test 0 -----
        p0 = new int[] {1, 0, 0, 0};
        p1 = 5L;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {1, 2, 0};
        p1 = 2L;
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {0, 0, 1, 2};
        p1 = 5L;
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {0, 1, 2, 3, 4, 5};
        p1 = 64L;
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new int[] {12, 10, 0, 4, 0, 6, 3, 8, 9, 14, 1, 5, 6, 12, 5};
        p1 = 90L;
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
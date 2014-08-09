import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ColorfulCoinsEasy {
    public String isPossible(int[] values) {
        int n = values.length;
        for (int x = 0; x <= values[n - 1]; x++) {
            int[] b = new int[n - 1];
            boolean ok = true;
            int r = x;
            for (int i = n - 2; i >= 0; i--) {
                b[i] = r / values[i];
                if (b[i] == 0) ok = false;
                r %= values[i];
            }
            Arrays.sort(b);
            for (int i = 1; i < n - 1; i++) {
                if (b[i] == b[i - 1]) ok = false;
            }
            if (ok) return "Possible";
        }
        return "Impossible";
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, String p1) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p0[i]);
        }
        System.out.print("}");
        System.out.println("]");
        ColorfulCoinsEasy obj;
        String answer;
        obj = new ColorfulCoinsEasy();
        long startTime = System.currentTimeMillis();
        answer = obj.isPossible(p0);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + "\"" + p1 + "\"");
        }
        System.out.println("Your answer:");
        System.out.println("\t" + "\"" + answer + "\"");
        if (hasAnswer) {
            res = answer.equals(p1);
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
        String p1;

        // ----- test 0 -----
        p0 = new int[] {1};
        p1 = "Possible";
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {1, 3};
        p1 = "Possible";
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {1, 2, 4};
        p1 = "Impossible";
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {1, 5, 15, 90};
        p1 = "Possible";
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new int[] {1, 4, 20, 60, 180, 1440, 5760};
        p1 = "Impossible";
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new int[] {1, 7, 21, 105, 630, 3150, 18900};
        p1 = "Possible";
        all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
        // ------------------

        // ----- test 6 -----
        p0 = new int[] {1, 10, 30, 300, 900, 9000, 18000};
        p1 = "Impossible";
        all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
        // ------------------

        // ----- test 7 -----
        p0 = new int[] {1, 2, 10, 40, 200, 1000, 4000, 20000};
        p1 = "Impossible";
        all_right = KawigiEdit_RunTest(7, p0, true, p1) && all_right;
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

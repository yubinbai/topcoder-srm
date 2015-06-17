import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class SlimeXSlimonadeTycoon {
    public int sell(int[] morning, int[] customers, int stale_limit) {
        int total = 0;
        int n = morning.length;
        ArrayList<Integer> stale = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            stale.add(morning[i]);
            if (stale.size() > stale_limit) stale.remove(0);
            int remainCustomer = customers[i];
            for (int k = 0; k < stale.size(); k++) {
                if (remainCustomer >= stale.get(k)) {
                    remainCustomer -= stale.get(k);
                    stale.set(k, 0);
                } else {
                    stale.set(k, stale.get(k) - remainCustomer);
                    remainCustomer = 0;
                    break;
                }
            }
            total += customers[i] - remainCustomer;
        }
        return total;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, int p3) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p0[i]);
        }
        System.out.print("}" + "," + "{");
        for (int i = 0; p1.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p1[i]);
        }
        System.out.print("}" + "," + p2);
        System.out.println("]");
        SlimeXSlimonadeTycoon obj;
        int answer;
        obj = new SlimeXSlimonadeTycoon();
        long startTime = System.currentTimeMillis();
        answer = obj.sell(p0, p1, p2);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p3);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p3;
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
        int[] p1;
        int p2;
        int p3;

        // ----- test 0 -----
        p0 = new int[] {5, 1, 1};
        p1 = new int[] {1, 2, 3};
        p2 = 2;
        p3 = 5;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {10, 20, 30};
        p1 = new int[] {30, 20, 10};
        p2 = 1;
        p3 = 40;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {1, 2, 3, 4, 5};
        p1 = new int[] {5, 5, 5, 5, 5};
        p2 = 5;
        p3 = 15;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {10000, 0, 0, 0, 0, 0, 0};
        p1 = new int[] {1, 2, 4, 8, 16, 32, 64};
        p2 = 4;
        p3 = 15;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
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
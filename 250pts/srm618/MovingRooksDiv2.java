import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class MovingRooksDiv2 {
    public String move(int[] Y1, int[] Y2) {
        int n = Y1.length;
        boolean ret = false;
        ArrayList<Integer> target = new ArrayList<Integer>();
        for (int i : Y2) target.add(i);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayDeque<ArrayList<Integer>> q = new ArrayDeque<ArrayList<Integer>>();

        ArrayList<Integer> from = new ArrayList<Integer>();
        for (int i : Y1) from.add(i);

        set.add(from);
        q.add(from);
        while (!q.isEmpty()) {
            ArrayList<Integer> curr = q.poll();
            if (curr.equals(target)) {
                ret = true;
                break;
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (curr.get(i) > curr.get(j)) {
                        ArrayList<Integer> e = new ArrayList<Integer>(curr);
                        Collections.swap(e, i, j);
                        if (!set.contains(e)) {
                            q.add(e);
                            set.add(e);
                        }
                    }
                }
            }
        }

        return ret ? "Possible" : "Impossible";
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, String p2) {
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
        System.out.print("}");
        System.out.println("]");
        MovingRooksDiv2 obj;
        String answer;
        obj = new MovingRooksDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.move(p0, p1);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + "\"" + p2 + "\"");
        }
        System.out.println("Your answer:");
        System.out.println("\t" + "\"" + answer + "\"");
        if (hasAnswer) {
            res = answer.equals(p2);
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
        String p2;

        // ----- test 0 -----
        p0 = new int[] {3, 6, 2, 4, 1, 5, 0};
        p1 = new int[] {6, 4, 0, 2, 1, 3, 5};
        p2 = "Impossible";
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {1, 0};
        p1 = new int[] {0, 1};
        p2 = "Possible";
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {0, 1};
        p1 = new int[] {1, 0};
        p2 = "Impossible";
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {3, 1, 2, 0};
        p1 = new int[] {0, 2, 1, 3};
        p2 = "Possible";
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new int[] {3, 1, 2, 0};
        p1 = new int[] {3, 2, 0, 1};
        p2 = "Impossible";
        all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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
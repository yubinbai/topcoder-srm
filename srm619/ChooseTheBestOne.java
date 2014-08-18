import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ChooseTheBestOne {
    public int countNumber(int N) {
        ArrayList<Integer> circ = new ArrayList<Integer>();
        for (int i = 0; i < N; ++i) {
            circ.add(i + 1);
        }
        int curr = 0;
        for (int round = 1; round < N; ++round) {
            long move = 1L * round * round * round - 1;
            move %= circ.size();

            curr += (int) move;
            curr %= circ.size();

            circ.remove(curr);
            if (curr == circ.size()) curr = 0;
        }
        return circ.get(0);
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, int p1) {
        System.out.print("Test " + testNum + ": [" + p0);
        System.out.println("]");
        ChooseTheBestOne obj;
        int answer;
        obj = new ChooseTheBestOne();
        long startTime = System.currentTimeMillis();
        answer = obj.countNumber(p0);
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
        p0 = 2414;
        p1 = 1368;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 6;
        p1 = 6;
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 10;
        p1 = 8;
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 1234;
        p1 = 341;
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
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
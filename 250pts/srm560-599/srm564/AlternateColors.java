import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class AlternateColors {
    public String getColor(long r, long g, long b, long k) {
        long[] ball = new long[3];
        String[] ret = {"RED", "GREEN", "BLUE"};
        ArrayList<String> ret_str = new ArrayList<String>();
        for (String s : ret) {
            ret_str.add(s);
        }
        ball[0] = r;
        ball[1] = g;
        ball[2] = b;
        Arrays.sort(ball);
        if (k <= 3 * ball[0]) {
            int color = (int) ((k - 1) % 3);
            return ret[color];
        } else if (k <= ball[0] + 2 * ball[1]) {
            if (r <= g && r <= b) {
                ret_str.remove(0);
            } else if (g <= r && g <= b) {
                ret_str.remove(1);
            } else {
                ret_str.remove(2);
            }
            int color = (int) ((k - 3 * ball[0] + 1) % 2);
            return ret_str.get(color);
        } else {
            if (r >= g && r >= b) {
                return ret[0];
            } else if (g >= r && g >= b) {
                return ret[1];
            } else {
                return ret[2];
            }
        }
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, long p0, long p1, long p2, long p3, boolean hasAnswer, String p4) {
        System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
        System.out.println("]");
        AlternateColors obj;
        String answer;
        obj = new AlternateColors();
        long startTime = System.currentTimeMillis();
        answer = obj.getColor(p0, p1, p2, p3);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + "\"" + p4 + "\"");
        }
        System.out.println("Your answer:");
        System.out.println("\t" + "\"" + answer + "\"");
        if (hasAnswer) {
            res = answer.equals(p4);
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

        long p0;
        long p1;
        long p2;
        long p3;
        String p4;

        // ----- test 0 -----
        p0 = 503832174890L;
        p1 = 917383384318L;
        p2 = 845748922941L;
        p3 = 1647508415774L;
        p4 = "BLUE";
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 0 -----
        p0 = 1L;
        p1 = 1L;
        p2 = 1L;
        p3 = 3L;
        p4 = "BLUE";
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 3L;
        p1 = 4L;
        p2 = 5L;
        p3 = 4L;
        p4 = "RED";
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 7L;
        p1 = 7L;
        p2 = 1L;
        p3 = 7L;
        p4 = "GREEN";
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 1000000000000L;
        p1 = 1L;
        p2 = 1L;
        p3 = 1000000000002L;
        p4 = "RED";
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = 653L;
        p1 = 32L;
        p2 = 1230L;
        p3 = 556L;
        p4 = "BLUE";
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Bob is playing with his ball destroyer robot. Initially, Bob has r red balls, g green balls and b blue balls. The robot will repeat the following 3-step program until there are no balls left:
    //
    // If there is at least one red ball available, destroy one red ball.
    // If there is at least one green ball available, destroy one green ball.
    // If there is at least one blue ball available, destroy one blue ball.
    //
    // You are given the longs r, g and b. You are also given a long k. Find the color of the k-th ball (1-index based) that will be destroyed.
    // If the color of the k-th ball to be destroyed is red, return "RED" (quotes for clarity, returned values are case-sensitive).
    // If the color is green, return "GREEN".
    // If the color is blue, return "BLUE".
    //
    //
    // DEFINITION
    // Class:AlternateColors
    // Method:getColor
    // Parameters:long, long, long, long
    // Returns:String
    // Method signature:String getColor(long r, long g, long b, long k)
    //
    //
    // CONSTRAINTS
    // -r, g and b  will each be between 1 and 1000000000000 (10^12), inclusive.
    // -k will be between 1 and r+g+b, inclusive.
    //
    //
    // EXAMPLES
    //
    // 0)
    // 1
    // 1
    // 1
    // 3
    //
    // Returns: "BLUE"
    //
    // The order in which the balls are destroyed is: Red, green and blue. The third ball was blue.
    //
    // 1)
    // 3
    // 4
    // 5
    // 4
    //
    // Returns: "RED"
    //
    // The order in which the balls are destroyed is:  Red, green, blue, red, green, blue, red, green, blue, green, blue and blue.
    //
    // 2)
    // 7
    // 7
    // 1
    // 7
    //
    // Returns: "GREEN"
    //
    //
    //
    // 3)
    // 1000000000000
    // 1
    // 1
    // 1000000000002
    //
    // Returns: "RED"
    //
    // Once the only green and blue balls are destroyed, all of the remaining balls will be red.
    //
    // 4)
    // 653
    // 32
    // 1230
    // 556
    //
    // Returns: "BLUE"
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

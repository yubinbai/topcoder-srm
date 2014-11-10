import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class NextOrPrev {
    public int getMinimum(int nextCost, int prevCost, String start, String goal) {
        for (int i = 0; i < start.length(); i++) {
            for (int j = i + 1; j < start.length(); j++) {
                if (!possible(start.charAt(i), goal.charAt(i), start.charAt(j), goal.charAt(j))) {
                    return -1;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) >= goal.charAt(i)) {
                ret += prevCost * Math.abs(start.charAt(i) - goal.charAt(i));
            } else {
                ret += nextCost * Math.abs(start.charAt(i) - goal.charAt(i));
            }
        }
        return ret;
    }

    private boolean possible(char c, char c1, char c2, char c3) {
        int direction = (c1 - c) * (c3 - c2);
        if (direction > 0) {
            int max1 = Math.max(c, c1);
            int max2 = Math.max(c2, c3);
            int min1 = Math.min(c, c1);
            int min2 = Math.min(c2, c3);
            if (max1 >= max2) {
                return min1 >= min2;
            } else {
                return min2 >= min1;
            }
        } else {
            int min = Math.min(c2, c3);
            int max = Math.max(c2, c3);
            for (int iter = Math.min(c, c1); iter <= Math.max(c, c1); iter++) {
                if (iter >= min && iter <= max) {
                    return false;
                }
            }
            return true;
        }
    }


    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, String p2, String p3, boolean hasAnswer, int p4) {
        System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "\"" + p2 + "\"" + "," + "\"" + p3 + "\"");
        System.out.println("]");
        NextOrPrev obj;
        int answer;
        obj = new NextOrPrev();
        long startTime = System.currentTimeMillis();
        answer = obj.getMinimum(p0, p1, p2, p3);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p4);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p4;
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
        String p2;
        String p3;
        int p4;

        // ----- test 0 -----
        p0 = 5;
        p1 = 8;
        p2 = "sadebkfnotx";
        p3 = "tbhigqnsuvx";
        p4 = -1;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 0 -----
        p0 = 5;
        p1 = 8;
        p2 = "zq";
        p3 = "bv";
        p4 = -1;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 0 -----
        p0 = 5;
        p1 = 8;
        p2 = "ae";
        p3 = "bc";
        p4 = 21;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 5;
        p1 = 8;
        p2 = "ae";
        p3 = "cb";
        p4 = -1;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 1;
        p1 = 1;
        p2 = "srm";
        p3 = "srm";
        p4 = 0;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 10;
        p1 = 1;
        p2 = "acb";
        p3 = "bdc";
        p4 = 30;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = 10;
        p1 = 1;
        p2 = "zyxw";
        p3 = "vuts";
        p4 = 16;
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = 563;
        p1 = 440;
        p2 = "ptrbgcnlaizo";
        p3 = "rtscedkiahul";
        p4 = 10295;
        all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 6 -----
        p0 = 126;
        p1 = 311;
        p2 = "yovlkwpjgsna";
        p3 = "zpwnkytjisob";
        p4 = -1;
        all_right = KawigiEdit_RunTest(6, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Consider a string consisting of lowercase characters and following two operations that can change it:
    //
    //  Next: Choose a lowercase character other than 'z' and replace its every occurrence with the next character
    //  ('a' -> 'b', 'b' -> 'c', ..., 'x' -> 'y', 'y' -> 'z').
    //  Prev: Choose a lowercase character other than 'a' and replace its every occurrence with the previous character
    //  ('b' -> 'a', 'c' -> 'b', ..., 'y' -> 'x', 'z' -> 'y').
    //
    // You can use each operation as many times as you want, and in any order you like.
    // You are given ints nextCost and prevCost.
    // These represent the cost of using each Next and Prev operation, respectively.
    // You are also given two Strings start and goal.
    // These strings are special: no two characters in start are the same, and no two characters in goal are the same.
    // Return the minimum cost required in order to transform start into goal using the above operations.
    // If transforming start into goal is impossible, return -1 instead.
    //
    //
    // DEFINITION
    // Class:NextOrPrev
    // Method:getMinimum
    // Parameters:int, int, String, String
    // Returns:int
    // Method signature:int getMinimum(int nextCost, int prevCost, String start, String goal)
    //
    //
    // CONSTRAINTS
    // -nextCost and prevCost will each be between 1 and 1000, inclusive.
    // -start and goal will each contain between 1 and 26 characters, inclusive.
    // -start and goal will contain the same number of characters.
    // -Each character in start and goal will be a lowercase character.
    // -The characters in start will be distinct.
    // -The characters in goal will be distinct.
    //
    //
    // EXAMPLES
    //
    // 0)
    // 5
    // 8
    // "ae"
    // "bc"
    //
    // Returns: 21
    //
    // There are several optimal sequences of operations.
    // Here is one of them: "ae" -(Next)-> "be" -(Prev)-> "bd" -(Prev)-> "bc". The total cost is 5 + 8 + 8 = 21.
    //
    //
    // 1)
    // 5
    // 8
    // "ae"
    // "cb"
    //
    // Returns: -1
    //
    // It is impossible to transform "ae" into "cb".
    //
    //
    // 2)
    // 1
    // 1
    // "srm"
    // "srm"
    //
    // Returns: 0
    //
    // start and goal may be the same.
    // The cost of an empty sequence of operations is 0.
    //
    //
    // 3)
    // 10
    // 1
    // "acb"
    // "bdc"
    //
    // Returns: 30
    //
    //
    //
    // 4)
    // 10
    // 1
    // "zyxw"
    // "vuts"
    //
    // Returns: 16
    //
    //
    //
    // 5)
    // 563
    // 440
    // "ptrbgcnlaizo"
    // "rtscedkiahul"
    //
    // Returns: 10295
    //
    //
    //
    // 6)
    // 126
    // 311
    // "yovlkwpjgsna"
    // "zpwnkytjisob"
    //
    // Returns: -1
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

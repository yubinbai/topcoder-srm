import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class JumpFurther {
    public int furthest(int N, int badStep) {
        int MAX_SIZE = 2000 * (2000 + 1) / 2 + 100;
        BigInteger prev = BigInteger.valueOf(1L);
        BigInteger curr = BigInteger.valueOf(1L);
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
            curr = prev.shiftLeft(i).or(prev);
            if (sum >= badStep) {
                curr = curr.clearBit(badStep);
            }
            prev = curr;
        }
        int ret = 0;
        for (int i = MAX_SIZE - 1; i > 0; i--) {
            if (curr.testBit(i)) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, int p2) {
        System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
        System.out.println("]");
        JumpFurther obj;
        int answer;
        obj = new JumpFurther();
        long startTime = System.currentTimeMillis();
        answer = obj.furthest(p0, p1);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p2);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p2;
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
        int p2;

        // ----- test 0 -----
        p0 = 2;
        p1 = 2;
        p2 = 3;
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 2;
        p1 = 1;
        p2 = 2;
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 3;
        p1 = 3;
        p2 = 5;
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 1313;
        p1 = 5858;
        p2 = 862641;
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = 1;
        p1 = 757065;
        p2 = 1;
        all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = 2000;
        p1 = 4000000;
        p2 = 2001000;
        all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = 2000;
        p1 = 1;
        p2 = 2000999;
        all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    //
    // Little Fox Jiro is standing at the bottom of a long flight of stairs.
    // The bottom of the stairs has number 0, the bottommost step has number 1, the next step has number 2, and so on.
    // The staircase is so long that Jiro is guaranteed not to reach its top.
    //
    //
    // Jiro will now perform N consecutive actions.
    // The actions are numbered 1 through N, in order.
    // When performing action X, Jiro chooses between two options: either he does nothing, or he jumps exactly X steps up the stairs.
    // In other words, if Jiro starts performing action X standing on step Y, he will end it either on step Y, or on step Y+X.
    //
    //
    // For example, if N=3, Jiro will make three consecutive choices: whether or not to jump 1 step upwards, 2 steps upwards, and then 3 steps upwards.
    //
    //
    // One of the steps is broken.
    // The number of this step is badStep.
    // Jiro cannot jump onto this step.
    //
    //
    // You are given the ints N and badStep.
    // Compute and return the number of the topmost step that can be reached by Jiro.
    //
    //
    //
    //
    // DEFINITION
    // Class:JumpFurther
    // Method:furthest
    // Parameters:int, int
    // Returns:int
    // Method signature:int furthest(int N, int badStep)
    //
    //
    // CONSTRAINTS
    // -N will be between 1 and 2,000, inclusive.
    // -badStep will be between 1 and 4,000,000, inclusive.
    //
    //
    // EXAMPLES
    //
    // 0)
    // 2
    // 2
    //
    // Returns: 3
    //
    // The optimal strategy is to jump upwards twice: from step 0 to step 1, and then from step 1 to step 3. This trajectory avoids the broken step.
    //
    // 1)
    // 2
    // 1
    //
    // Returns: 2
    //
    // In this case step 1 is broken, so Jiro cannot jump upwards as his first action. The optimal strategy is to first stay on step 0, and then to jump from step 0 to step 2.
    //
    // 2)
    // 3
    // 3
    //
    // Returns: 5
    //
    //
    //
    // 3)
    // 1313
    // 5858
    //
    // Returns: 862641
    //
    //
    //
    // 4)
    // 1
    // 757065
    //
    // Returns: 1
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

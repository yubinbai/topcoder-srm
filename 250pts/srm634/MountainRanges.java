import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class MountainRanges {
    public int countPeaks(int[] heights) {
        int ret = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = (i == 0) ? 0 : heights[i - 1];
            int right = (i == heights.length - 1) ? 0 : heights[i + 1];
            if (heights[i] > left && heights[i] > right) ret++;
        }
        return ret;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p0[i]);
        }
        System.out.print("}");
        System.out.println("]");
        MountainRanges obj;
        int answer;
        obj = new MountainRanges();
        long startTime = System.currentTimeMillis();
        answer = obj.countPeaks(p0);
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
        int p1;

        // ----- test 0 -----
        p0 = new int[] {5, 6, 2, 4};
        p1 = 2;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {1, 1, 1, 1, 1, 1, 1};
        p1 = 0;
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {2, 1};
        p1 = 1;
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {2, 5, 3, 7, 2, 8, 1, 3, 1};
        p1 = 4;
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new int[] {1};
        p1 = 1;
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new int[] {1, 2, 3, 4, 4, 3, 2, 1};
        p1 = 0;
        all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    //
    // Tom is in charge of a tourist agency.
    // He has a lovely picture of the local mountain range.
    // He would like to sell it to the tourists but first he needs to know how many peaks are visible in the picture.
    //
    //
    //
    // The mountain range in the picture can be seen as a sequence of heights.
    // You are given these heights as a int[] height.
    // An element of height is called a peak if its value is strictly greater than each of the values of adjacent elements.
    // Compute and return the number of peaks in the given mountain range.
    //
    //
    //
    // DEFINITION
    // Class:MountainRanges
    // Method:countPeaks
    // Parameters:int[]
    // Returns:int
    // Method signature:int countPeaks(int[] heights)
    //
    //
    // CONSTRAINTS
    // -heights will contain between 1 and 50 elements, inclusive.
    // -Each element of heights will be between 1 and 100, inclusive.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {5, 6, 2, 4}
    //
    // Returns: 2
    //
    // Element 1 (0-based index) is a peak.
    // Its height is 6, which is strictly greater than each of its neighbors' heights (5 and 2).
    // Element 3 is also a peak since its height is 4 and that is strictly greater than its neighbor's height (which is 2).
    //
    // 1)
    // {1, 1, 1, 1, 1, 1, 1}
    //
    // Returns: 0
    //
    // This is a very flat mountain with no peaks.
    //
    // 2)
    // {2, 1}
    //
    // Returns: 1
    //
    // Element 0 is a peak.
    //
    // 3)
    // {2,5,3,7,2,8,1,3,1}
    //
    // Returns: 4
    //
    // The peaks here are the elements with 0-based indices 1, 3, 5, and 7. Their heights are 5, 7, 8, and 3, respectively.
    //
    // 4)
    // {1}
    //
    // Returns: 1
    //
    // Element 0 is a peak. Even though it has no neighbors, the condition from the problem statement is still satisfied.
    //
    // 5)
    // {1,2,3,4,4,3,2,1}
    //
    // Returns: 0
    //
    // According to our definition there is no peak in this mountain range.
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

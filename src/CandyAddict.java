import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

/**
 * SRM 629 div2 1000 pt
 */
public class CandyAddict {
    public long[] solve(int[] X, int[] Y, int[] Z) {
        int cases = X.length;
        long[] ret = new long[cases];
        for (int caseNo = 0; caseNo < cases; ++caseNo) {
            int x = X[caseNo], y = Y[caseNo], z = Z[caseNo];
            ret[caseNo] = calc2(x, y, z);
        }
        return ret;
    }

    // dumb simulation
    public long calc(int x, int y, int z) {
        long cash = 0;
        long candy = 0;
        for (int i = 0; i < z; ++i) {
            cash += x;
            if (candy == 0) {
                candy = cash / y;
                cash = cash % y;
            }
            if (candy > 0) {
                candy--;
            } 
        }
        return cash;
    }

    // try to improve, circle finding?
    public long calc2(int x, int y, int z) {
        long cash = 0;
        long candy = 0;
        for (int i = 0; i < z; ++i) {
            cash += x;
            if (candy == 0) {
                candy = cash / y;
                cash = cash % y;

                if (i + candy < z) {
                    i += candy;
                    cash += candy * x;
                    // cash -= x;
                    candy = 0;
                }
            }
        }
        return cash;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, boolean hasAnswer, long[] p3) {
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
        System.out.print("}" + "," + "{");
        for (int i = 0; p2.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p2[i]);
        }
        System.out.print("}");
        System.out.println("]");
        CandyAddict obj;
        long[] answer;
        obj = new CandyAddict();
        long startTime = System.currentTimeMillis();
        answer = obj.solve(p0, p1, p2);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.print("\t" + "{");
            for (int i = 0; p3.length > i; ++i) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print(p3[i]);
            }
            System.out.println("}");
        }
        System.out.println("Your answer:");
        System.out.print("\t" + "{");
        for (int i = 0; answer.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(answer[i]);
        }
        System.out.println("}");
        if (hasAnswer) {
            if (answer.length != p3.length) {
                res = false;
            } else {
                for (int i = 0; answer.length > i; ++i) {
                    if (answer[i] != p3[i]) {
                        res = false;
                    }
                }
            }
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
        int[] p2;
        long[] p3;

        // ----- test 0 -----
        p0 = new int[] {5};
        p1 = new int[] {3};
        p2 = new int[] {3};
        p3 = new long[] {6L};
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {5, 5, 5, 5, 5};
        p1 = new int[] {3, 3, 3, 3, 3};
        p2 = new int[] {1, 2, 3, 4, 5};
        p3 = new long[] {2L, 1L, 6L, 2L, 7L};
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {1000000000, 1000000000, 1000000000, 1000000000, 1000000000};
        p1 = new int[] {1, 2, 3, 999999998, 999999999};
        p2 = new int[] {342568368, 560496730, 586947396, 386937583, 609483745};
        p3 = new long[] {342568367000000000L, 60496729000000000L, 253614062000000001L, 773875166L, 609483745L};
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
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

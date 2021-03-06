import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class PalindromicSubstringsDiv2 {
    public int count(String[] S1, String[] S2) {
        StringBuilder sb = new StringBuilder();
        for (String s : S1) {
            sb.append(s);
        }
        for (String s : S2) {
            sb.append(s);
        }
        // System.out.println(sb.toString());
        char[] s = sb.toString().toCharArray();
        int size = s.length;
        int ret = 0;
        // odd
        for (int i = 0; i < size; ++i) {
            int left = i, right = i;
            while (left >= 0 && right < size) {
                if (s[left] == s[right])  {
                    ret++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
        // even
        for (int i = 0; i < size - 1; ++i) {
            int left = i, right = i + 1;
            while (left >= 0 && right < size) {
                if (s[left] == s[right])  {
                    ret++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
        return ret;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String[] p0, String[] p1, boolean hasAnswer, int p2) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p0[i] + "\"");
        }
        System.out.print("}" + "," + "{");
        for (int i = 0; p1.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p1[i] + "\"");
        }
        System.out.print("}");
        System.out.println("]");
        PalindromicSubstringsDiv2 obj;
        int answer;
        obj = new PalindromicSubstringsDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.count(p0, p1);
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

        String[] p0;
        String[] p1;
        int p2;

        // ----- test 0 -----
        p0 = new String[] {"a", "a", ""};
        p1 = new String[] {"a"};
        p2 = 6;
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new String[] {"zaz"};
        p1 = new String[] {};
        p2 = 4;
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new String[] {"top"};
        p1 = new String[] {"coder"};
        p2 = 8;
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new String[] {};
        p1 = new String[] {"daata"};
        p2 = 7;
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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

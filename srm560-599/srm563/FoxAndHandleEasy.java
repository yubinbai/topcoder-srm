import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class FoxAndHandleEasy {
    public String isPossible(String S, String T) {
        for (int i = 0; i < S.length(); i++) {
            if (T.equals(S.substring(0, i) + S + S.substring(i, S.length()))) {
                return "Yes";
            }
        }
        if (T.equals(S + S)) return "Yes";
        return "No";
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, boolean hasAnswer, String p2) {
        System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
        System.out.println("]");
        FoxAndHandleEasy obj;
        String answer;
        obj = new FoxAndHandleEasy();
        long startTime = System.currentTimeMillis();
        answer = obj.isPossible(p0, p1);
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

        String p0;
        String p1;
        String p2;

        // ----- test 0 -----
        p0 = "Ciel";
        p1 = "CieCiell";
        p2 = "Yes";
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = "Ciel";
        p1 = "FoxCiel";
        p2 = "No";
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = "FoxCiel";
        p1 = "FoxFoxCielCiel";
        p2 = "Yes";
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = "FoxCiel";
        p1 = "FoxCielCielFox";
        p2 = "No";
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = "Ha";
        p1 = "HaHaHaHa";
        p2 = "No";
        all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = "TheHandleCanBeVeryLong";
        p1 = "TheHandleCanBeVeryLong";
        p2 = "No";
        all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 6 -----
        p0 = "Long";
        p1 = "LongLong";
        p2 = "Yes";
        all_right = KawigiEdit_RunTest(6, p0, p1, true, p2) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Fox Ciel has a new favorite string operation that works as follows:
    // She takes two copies of some string X, and inserts one copy somewhere into the other copy of the same string.
    // (She can also insert it at the beginning or, equivalently, at the end.)
    // This operation is called expansion of the string X.
    // For example, if X = "Ciel", she can expand it to "CielCiel", "CCieliel", "CiCielel", or "CieCiell".
    //
    //
    //
    // You are given two Strings: S and T.
    // Return "Yes" (quotes for clarity) if T can be obtained by expanding S exactly once.
    // Otherwise, return "No".
    //
    // DEFINITION
    // Class:FoxAndHandleEasy
    // Method:isPossible
    // Parameters:String, String
    // Returns:String
    // Method signature:String isPossible(String S, String T)
    //
    //
    // CONSTRAINTS
    // -S will contain between 1 and 50 characters, inclusive.
    // -T will contain between 1 and 50 characters, inclusive.
    // -Both S and T will contain uppercase and lowercase letters only ('A'-'Z' and 'a'-'z').
    //
    //
    // EXAMPLES
    //
    // 0)
    // "Ciel"
    // "CieCiell"
    //
    // Returns: "Yes"
    //
    // She can insert "Ciel" between "Cie" and "l".
    //
    // 1)
    // "Ciel"
    // "FoxCiel"
    //
    // Returns: "No"
    //
    // Each string obtained by expanding S="Ciel" has exactly 8 letters.
    //
    // 2)
    // "FoxCiel"
    // "FoxFoxCielCiel"
    //
    // Returns: "Yes"
    //
    //
    //
    // 3)
    // "FoxCiel"
    // "FoxCielCielFox"
    //
    // Returns: "No"
    //
    //
    //
    // 4)
    // "Ha"
    // "HaHaHaHa"
    //
    // Returns: "No"
    //
    //
    //
    // 5)
    // "TheHandleCanBeVeryLong"
    // "TheHandleCanBeVeryLong"
    //
    // Returns: "No"
    //
    //
    //
    // 6)
    // "Long"
    // "LongLong"
    //
    // Returns: "Yes"
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
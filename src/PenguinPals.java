import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class PenguinPals
{
    HashMap<String, Integer> ret = new HashMap<String, Integer>();
	public int findMaximumMatching(String colors)
	{
		return solve(colors);
	}

    private int solve(String str) {
        if (ret.containsKey(str)) return ret.get(str);
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    int curr = 1 + solve(str.substring(i + 1, j))
                            + solve(str.substring(0, i) + str.substring(j + 1, str.length()));
                    res = Math.max(res, curr);
                }
            }
        }
        ret.put(str, res);
        return res;
    }


    // BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		PenguinPals obj;
		int answer;
		obj = new PenguinPals();
		long startTime = System.currentTimeMillis();
		answer = obj.findMaximumMatching(p0);
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

		String p0;
		int p1;
        // ----- test 0 -----
        p0 = "BRRBRRRRRRBRRRRRRBRRBRBRRRBRRRBRRRRBRRBR";
        p1 = 19;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

		// ----- test 0 -----
		p0 = "RRBRBRBB";
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = "RRRR";
		p1 = 2;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = "BBBBB";
		p1 = 2;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = "RBRBRBRBR";
		p1 = 4;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = "RRRBRBRBRBRB";
		p1 = 5;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = "R";
		p1 = 0;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------

		// ----- test 6 -----
		p0 = "RBRRBBRB";
		p1 = 3;
		all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
		// ------------------

		// ----- test 7 -----
		p0 = "RBRBBRBRB";
		p1 = 4;
		all_right = KawigiEdit_RunTest(7, p0, true, p1) && all_right;
		// ------------------

		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	//
	// Penguin Pals is a match making service that matches penguins to new friends, using the following procedure:
	//
	// Each penguin is asked a single question: "Do you prefer the color blue, or the color red?"
	// All penguins are arranged so that they stand on a circle, equally spaced.
	// The organizers draw some straight lines, connecting some pairs of penguins. Each penguin may only be connected to at most one other penguin. Two penguins cannot be connected if they prefer a different color.
	// Each penguin who is connected to some other penguin follows the line to find their match.
	//
	//
	//
	//
	// The only problem with the above system was that it allowed penguins to collide if two lines crossed each other.
	// Therefore, a new additional rule was adopted: no two lines may cross.
	// Penguin Pals now has some penguins arranged on a circle (after step 2 of the above procedure).
	// They need to know the maximum number of pairs of penguins they can create.
	//
	//
	//
	// You are given a String colors whose i-th character represents the prefered color of the i-th penguin (0-based index) in the circular arrangement. The i-th character is 'R' if the i-th penguin prefers red and 'B' if the i-th penguin prefers blue. Return the maximum number of matched pairs that can be formed.
	//
	//
	// DEFINITION
	// Class:PenguinPals
	// Method:findMaximumMatching
	// Parameters:String
	// Returns:int
	// Method signature:int findMaximumMatching(String colors)
	//
	//
	// CONSTRAINTS
	// -colors will contain between 1 and 50 characters, inclusive.
	// -Each character of colors will be either 'R' or 'B'.
	//
	//
	// EXAMPLES
	//
	// 0)
	// "RRBRBRBB"
	//
	// Returns: 3
	//
	// In this picture the penguins have been colored in their preferred color.
	//
	//
	//
	// 1)
	// "RRRR"
	//
	// Returns: 2
	//
	//
	//
	// 2)
	// "BBBBB"
	//
	// Returns: 2
	//
	//
	//
	// 3)
	// "RBRBRBRBR"
	//
	// Returns: 4
	//
	//
	//
	// 4)
	// "RRRBRBRBRBRB"
	//
	// Returns: 5
	//
	//
	//
	// 5)
	// "R"
	//
	// Returns: 0
	//
	//
	//
	// 6)
	// "RBRRBBRB"
	//
	// Returns: 3
	//
	//
	//
	// 7)
	// "RBRBBRBRB"
	//
	// Returns: 4
	//
	//
	//
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

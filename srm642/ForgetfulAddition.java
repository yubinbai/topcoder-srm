import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ForgetfulAddition
{
	public int minNumber(String expression)
	{
		int ret = Integer.MAX_VALUE;
        int n = expression.length();
        for (int i = 1; i < n; i++) {
            int a = Integer.parseInt(expression.substring(0, i));
            int b = Integer.parseInt(expression.substring(i, n));
            ret = Math.min(ret, a + b);
        }
        return ret;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		ForgetfulAddition obj;
		int answer;
		obj = new ForgetfulAddition();
		long startTime = System.currentTimeMillis();
		answer = obj.minNumber(p0);
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
		p0 = "22";
		p1 = 4;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "123";
		p1 = 15;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "1289";
		p1 = 101;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "31415926";
		p1 = 9067;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "98765";
		p1 = 863;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// 
	// Alice had two positive integers, a and b.
	// She typed the expression "a+b" into her computer, but the '+' key malfunctioned.
	// For example, instead of "128+9" the computer's screen now shows "1289".
	// 
	// 
	// 
	// Later, Bob saw the string on the screen.
	// He knows that the '+' sign is missing but he does not know where it belongs.
	// He now wonders what is the smallest possible result of Alice's original expression.
	// 
	// 
	// 
	// For example, if Bob sees the string "1289", Alice's expression is either "128+9" or "12+89" or "1+289".
	// These expressions evaluate to 137, 101, and 290.
	// The smallest of those three results is 101.
	// 
	// 
	// 
	// You are given a String expression that contains the expression on Alice's screen.
	// Compute and return the smallest possible result after inserting the missing plus sign
	// 
	// 
	// DEFINITION
	// Class:ForgetfulAddition
	// Method:minNumber
	// Parameters:String
	// Returns:int
	// Method signature:int minNumber(String expression)
	// 
	// 
	// CONSTRAINTS
	// -expression will contain between 2 and 8 characters, inclusive.
	// -Each character of expression will be between '1' and '9'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "22"
	// 
	// Returns: 4
	// 
	// The only possible expression Alice could have typed is "2+2". Thus, Bob knows this evaluates to 4.
	// 
	// 1)
	// "123"
	// 
	// Returns: 15
	// 
	// The expression Alice has typed could have been "1+23" or "12+3". Of these two, the second is smaller, thus Bob will get the answer 15. 
	// 
	// 2)
	// "1289"
	// 
	// Returns: 101
	// 
	// This is the example from the problem statement.
	// 
	// 3)
	// "31415926"
	// 
	// Returns: 9067
	// 
	// 
	// 
	// 4)
	// "98765"
	// 
	// Returns: 863
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
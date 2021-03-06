import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TaroFillingAStringDiv2
{
	public int getNumber(String S)
	{
        final int BIG = (int) 1e7;
		int n = S.length();
        int dp0 = 0, dp1 = 0;
        int _dp0 = 0, _dp1 = 0;
        for (int i = 0; i < n; i++) {
            switch (S.charAt(i)) {
                case 'A':
                    _dp0 = Math.min(dp0 + 1, dp1);
                    _dp1 = BIG;
                    break;
                case 'B':
                    _dp0 = BIG;
                    _dp1 = Math.min(dp0, dp1 + 1);
                    break;
                case '?':
                    _dp0 = Math.min(dp0 + 1, dp1);
                    _dp1 = Math.min(dp0, dp1 + 1);
                    break;
            }
            dp0 = _dp0;
            dp1 = _dp1;
        }
        return Math.min(dp0, dp1);
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		TaroFillingAStringDiv2 obj;
		int answer;
		obj = new TaroFillingAStringDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0);
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
		p0 = "ABAA";
		p1 = 1;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "??";
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "A?A";
		p1 = 0;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "A??B???AAB?A???A";
		p1 = 3;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "?BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?";
		p1 = 10;
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
	// Cat Taro likes strings.
	// You are given a String S.
	// Each character of S is 'A', 'B', or '?'.
	// 
	// 
	// 
	// 
	// To Taro, the ugliness of a string is the number of pairs of equal consecutive characters.
	// For example, the ugliness of "ABABAABBB" is 3: there is one pair "AA" and two (overlapping) pairs "BB".
	// 
	// 
	// 
	// 
	// Taro now wants to change each question mark in S either to 'A' or to 'B'.
	// His goal is to minimize the ugliness of the resulting string.
	// Return the smallest ugliness that can be achieved.
	// 
	// 
	// DEFINITION
	// Class:TaroFillingAStringDiv2
	// Method:getNumber
	// Parameters:String
	// Returns:int
	// Method signature:int getNumber(String S)
	// 
	// 
	// CONSTRAINTS
	// -S will contain between 1 and 50 characters, inclusive.
	// -S will consist only of characters 'A', 'B' and '?'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "ABAA"
	// 
	// Returns: 1
	// 
	// There is initially one pair of consecutive digits that are equal in this case. There is no characters that Taro has to replace, hence the answer is 1.
	// 
	// 1)
	// "??"
	// 
	// Returns: 0
	// 
	// 
	// 
	// 2)
	// "A?A"
	// 
	// Returns: 0
	// 
	// 
	// 
	// 3)
	// "A??B???AAB?A???A"
	// 
	// Returns: 3
	// 
	// 
	// 
	// 4)
	// "?BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?"
	// 
	// Returns: 10
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

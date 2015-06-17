import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ElectionFraudDiv2
{
	public String IsFraudulent(int[] percentages)
	{
		int min = 0, max = 0;
        for (int p : percentages) {
            if (p != 0) {
                min += p * 100 - 50;
            }
            max += p * 100 + 49;
        }
        if (min <= 10000 && max >= 10000) {
            return "NO";
        } else {
            return "YES";
        }
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		ElectionFraudDiv2 obj;
		String answer;
		obj = new ElectionFraudDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.IsFraudulent(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p1 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p1);
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
		String p1;
		
		// ----- test 0 -----
		p0 = new int[]{100};
		p1 = "NO";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{34,34,34};
		p1 = "YES";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{12,12,12,12,12,12,12,12};
		p1 = "YES";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{13,13,13,13,13,13,13,13};
		p1 = "NO";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{0,1,100};
		p1 = "NO";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new int[]{3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8};
		p1 = "NO";
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// In a normal election, one expects the percentages received by each of the candidates to sum to exactly 100 percent.  There are two ways this might not be the case: if the election is fraudulent, or if the reported percentages are rounded.
	// In a recent election, the number of voters was known to be exactly 10000.  Assuming the election was run fairly, each voter voted for exactly one candidate.  The percentage of the vote received by each candidate was rounded to the nearest whole number before being reported.  Percentages lying halfway between two consecutive whole numbers were rounded up.
	// The ministry of voting is looking for a proof of election fraud.  You'll be given a int[] percentages, giving the reported percentage of the vote that went to each candidate.  Return a String containing "YES" if the election is definitely fraudulent, otherwise return "NO" (quotes for clarity only).  That is, return "YES" if it could not be the case that each of the 10000 voters voted for exactly one candidate, and "NO" otherwise.
	// 
	// DEFINITION
	// Class:ElectionFraudDiv2
	// Method:IsFraudulent
	// Parameters:int[]
	// Returns:String
	// Method signature:String IsFraudulent(int[] percentages)
	// 
	// 
	// CONSTRAINTS
	// -percentages will contain between 1 and 50 elements, inclusive.
	// -Each element of percentages will be between 0 and 100, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {100}
	// 
	// Returns: "NO"
	// 
	// If there's only one candidate, that candidate will receive 100% of the votes in a fair election.
	// 
	// 1)
	// {34, 34, 34}
	// 
	// Returns: "YES"
	// 
	// Even accounting for rounding, these numbers are too high.
	// 
	// 2)
	// {12, 12, 12, 12, 12, 12, 12, 12}
	// 
	// Returns: "YES"
	// 
	// These numbers are too low.
	// 
	// 3)
	// {13, 13, 13, 13, 13, 13, 13, 13}
	// 
	// Returns: "NO"
	// 
	// Each candidate could have received exactly 1250 votes.
	// 
	// 4)
	// {0, 1, 100}
	// 
	// Returns: "NO"
	// 
	// The only valid possibility is that the candidates received 0, 50, and 9950 votes, respectively.
	// 
	// 5)
	// {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8}
	// 
	// Returns: "NO"
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
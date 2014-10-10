import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class RaiseThisBarn
{
	public int calc(String str)
	{
		int size = str.length();
        int[] ct = new int[size];
        if (str.charAt(0) == 'c') {
            ct[0] = 1;
        }
        for (int i = 1; i < size; i++) {
            if (str.charAt(i) == 'c') {
                ct[i] = ct[i - 1] + 1;
            } else {
                ct[i] = ct[i - 1];
            }
        }
        int total = ct[size -1];
        if (total % 2 == 1) {
            return 0;
        } else {
            int ret = 0;
            for (int i = 0; i < size - 1; i++) {
                int c = ct[i];
                if (c == total / 2) ret++;
            }
            return ret;
        }
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		RaiseThisBarn obj;
		int answer;
		obj = new RaiseThisBarn();
		long startTime = System.currentTimeMillis();
		answer = obj.calc(p0);
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
		p0 = "cc..c.c";
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "c....c....c";
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "............";
		p1 = 11;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = ".c.c...c..ccc.c..c.c.cc..ccc";
		p1 = 3;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// The pony Applejack is going to raise a new barn.
	// The barn will consist of N sections in a row.
	// Some of the sections will be empty, others will contain a single cow each.
	// You are given a String str with N characters.
	// This string describes the desired layout of the barn:
	// the character 'c' represents a section with a cow, and the character '.' represents an empty section.
	// 
	// After she raises the barn, Applejack will build a wall that will divide the barn into two separate parts:
	// one containing the first k sections and the other containing the last N-k sections, for some integer k.
	// Each part must contain at least one section. (I.e., k must be between 1 and N-1, inclusive.)
	// Additionally, Applejack wants both parts to contain exactly the same number of cows.
	// 
	// Return the number of possible positions for the wall.
	// In other words, return the number of choices for the integer k such that all the conditions above are satisfied.
	// 
	// DEFINITION
	// Class:RaiseThisBarn
	// Method:calc
	// Parameters:String
	// Returns:int
	// Method signature:int calc(String str)
	// 
	// 
	// CONSTRAINTS
	// -str will contain between 2 and 50 characters, inclusive.
	// -Each character in str will be 'c' or '.'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "cc..c.c"
	// 
	// Returns: 3
	// 
	// Applejack can choose k=2, k=3, or k=4.
	// The three corresponding solutions are shown below, with '|' representing the wall between the two parts.
	// 
	// cc|..c.c
	// cc.|.c.c
	// cc..|c.c
	// 
	// 
	// 1)
	// "c....c....c"
	// 
	// Returns: 0
	// 
	// There is an odd number of cows. It is impossible to divide them into two equal halves.
	// 
	// 2)
	// "............"
	// 
	// Returns: 11
	// 
	// This is a barn with 12 empty sections. It can be divided in 11 different ways: into 1+11 sections, 2+10 sections, ..., or 11+1 sections.
	// 
	// 3)
	// ".c.c...c..ccc.c..c.c.cc..ccc"
	// 
	// Returns: 3
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

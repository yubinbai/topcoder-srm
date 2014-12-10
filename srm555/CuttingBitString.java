import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CuttingBitString
{
    HashMap<String, Integer> dp = new HashMap<String, Integer>();
	public int getmin(String S)
	{
		return solve(S);
	}

    private int solve(String str) {
        if (dp.containsKey(str)) return dp.get(str);
        if (str.charAt(0) == '0') {
            dp.put(str, -1);
            return -1;
        }
        long s = Long.parseLong(str, 2);
        while (s > 1 && s % 5 == 0) {
            s /= 5;
        }
        if (s == 1) {
            dp.put(str, 1);
            return 1;
        } else {
            int ret = 2 * str.length();
            for (int i = 1; i < str.length(); i++) {
                int s1 = solve(str.substring(0, i));
                int s2 = solve(str.substring(i, str.length()));
                if (s1 != -1 && s2 != -1) {
                    ret = Math.min(ret, s1 + s2);
                }
            }
            if (ret == 2 * str.length()) ret = -1;
            dp.put(str, ret);
            return ret;
        }
    }

    // BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		CuttingBitString obj;
		int answer;
		obj = new CuttingBitString();
		long startTime = System.currentTimeMillis();
		answer = obj.getmin(p0);
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
		p0 = "101101101";
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "1111101";
		p1 = 1;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "00000";
		p1 = -1;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "110011011";
		p1 = 3;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "1000101011";
		p1 = -1;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "111011100110101100101110111";
		p1 = 5;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// We are in a distant future.
	// After the downfall of mankind, the Earth is now ruled by fairies.
	// The "Turing game Online" website is hot among fairies right now.
	// On this website, everyone can play the programming puzzle "Turing game".
	// 
	// Fairies love powers of 5, that is, the numbers 1, 5, 25, 125, 625, and so on.
	// In the Turing game, the player is given a string of bits (zeros and ones).
	// The ideal situation is when the string is represents a power of 5 in binary, with no leading zeros.
	// If that is not the case, the fairy player tries to cut the given string into pieces, each piece being a binary representation of a power of 5, with no leading zeros.
	// Of course, it may be the case that even this is impossible.
	// In that case, the fairy player becomes depressed, and bad things happen when a fairy gets depressed.
	// You, as one of the surviving humans, are in charge of checking the bit strings to prevent the bad things from happening.
	// 
	// You are given a String S that consists of characters '0' and '1' only.
	// S represents the string given to a player of the Turing game.
	// Return the smallest positive integer K such that it is possible to cut S into K pieces, each of them being a power of 5.
	// If there is no such K, return -1 instead.
	// 
	// DEFINITION
	// Class:CuttingBitString
	// Method:getmin
	// Parameters:String
	// Returns:int
	// Method signature:int getmin(String S)
	// 
	// 
	// CONSTRAINTS
	// -S will contain between 1 and 50 characters, inclusive.
	// -Each character in S will be either '0' or '1'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "101101101"
	// 
	// Returns: 3
	// 
	// We can split the given string into three "101"s.
	// Note that "101" is 5 in binary.
	// 
	// 1)
	// "1111101"
	// 
	// Returns: 1
	// 
	// "1111101" is 5^3.
	// 
	// 2)
	// "00000"
	// 
	// Returns: -1
	// 
	// 0 is not a power of 5.
	// 
	// 3)
	// "110011011"
	// 
	// Returns: 3
	// 
	// Split it into "11001", "101" and "1".
	// 
	// 4)
	// "1000101011"
	// 
	// Returns: -1
	// 
	// 
	// 
	// 5)
	// "111011100110101100101110111"
	// 
	// Returns: 5
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
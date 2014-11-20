import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TypingDistance
{
	public int minDistance(String keyboard, String word)
	{
		int[] pos = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            pos[i] = keyboard.indexOf(word.charAt(i));
        }
        int ret = 0;
        for (int i = 1; i < word.length(); i++) {
            ret += Math.abs(pos[i] - pos[i - 1]);
        }
        return ret;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
		System.out.println("]");
		TypingDistance obj;
		int answer;
		obj = new TypingDistance();
		long startTime = System.currentTimeMillis();
		answer = obj.minDistance(p0, p1);
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
		
		String p0;
		String p1;
		int p2;
		
		// ----- test 0 -----
		p0 = "qwertyuiop";
		p1 = "potter";
		p2 = 8;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "tc";
		p1 = "tctcttccctccccttc";
		p2 = 9;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "a";
		p1 = "aaaaaaaaaaa";
		p2 = 0;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "kwadrutove";
		p1 = "rowerowe";
		p2 = 39;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "qwertyuiopasdfghjklzxcvbnm";
		p1 = "topcodersingleroundmatchgoodluckhavefun";
		p2 = 322;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// 
	// Jakub is trying out a one-dimensional keyboard.
	// It consists of a single row of keys. 
	// The distance between any two adjacent keys is 1.
	// Each key contains a distinct letter of the English alphabet.
	// Jakub uses only one finger to type on the keyboard.
	// He wonders what is the smallest total distance he will have to move his finger while typing a given word.
	// 
	// 
	// 
	// For example, if the keyboard's only row is "qwertyuiop", and Jakub wants to type the word "potter", he will have to move his finger from 'p' to 'o' (distance 1), from 'o' to 't' (distance 4), from 't' to 't' (distance 0), from 't' to 'e' (distance 2) and from 'e' to 'r' (distance 1), for a total distance of 1 + 4 + 0 + 2 + 1 = 8.
	// 
	// 
	// 
	// You are given a String keyboard and a String word, describing the keyboard and the word Jakub wants to write. Return the minimum distance he will have to move his finger in order to type the word on the keyboard.
	// 
	// 
	// DEFINITION
	// Class:TypingDistance
	// Method:minDistance
	// Parameters:String, String
	// Returns:int
	// Method signature:int minDistance(String keyboard, String word)
	// 
	// 
	// NOTES
	// -When moving the finger from the i-th key to the j-th key, the distance covered by the move can be computed as |i-j|, that is, the positive difference between i and j.
	// 
	// 
	// CONSTRAINTS
	// -keyboard will contain between 1 and 26 characters, inclusive.
	// -Each character in keyboard will be a different lowercase letter of the English alphabet ('a'-'z').
	// -word will contain between 1 and 50 characters, inclusive.
	// -Each character in word will be present in keyboard.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "qwertyuiop"
	// "potter"
	// 
	// Returns: 8
	// 
	// The example from the problem statement.
	// 
	// 1)
	// "tc"
	// "tctcttccctccccttc"
	// 
	// Returns: 9
	// 
	// 
	// 
	// 2)
	// "a"
	// "aaaaaaaaaaa"
	// 
	// Returns: 0
	// 
	// 
	// 
	// 3)
	// "kwadrutove"
	// "rowerowe"
	// 
	// Returns: 39
	// 
	// 
	// 
	// 4)
	// "qwertyuiopasdfghjklzxcvbnm"
	// "topcodersingleroundmatchgoodluckhavefun"
	// 
	// Returns: 322
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

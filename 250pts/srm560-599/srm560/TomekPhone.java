import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TomekPhone
{
	public int minKeystrokes(int[] frequencies, int[] keySizes)
	{
		Arrays.sort(frequencies);
        Arrays.sort(keySizes);
        ArrayList<Integer> strokes = new ArrayList<Integer>();
        for (int k : keySizes) {
            for (int i = 1; i <= k; i++) {
                strokes.add(i);
            }
        }
        Collections.sort(strokes);
        int ret = 0, curr = 0;
        for (int i = frequencies.length - 1; i >= 0; i--) {
            if (curr < strokes.size()) {
                ret += strokes.get(curr) * frequencies[i];
                curr++;
            } else {
                return -1;
            }
        }
        return ret;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, int p2) {
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
		System.out.print("}");
		System.out.println("]");
		TomekPhone obj;
		int answer;
		obj = new TomekPhone();
		long startTime = System.currentTimeMillis();
		answer = obj.minKeystrokes(p0, p1);
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
		
		int[] p0;
		int[] p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new int[]{7,3,4,1};
		p1 = new int[]{2,2};
		p2 = 19;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{13,7,4,20};
		p1 = new int[]{2,1};
		p2 = -1;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{11,23,4,50,1000,7,18};
		p1 = new int[]{3,1,4};
		p2 = 1164;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{100,1000,1,10};
		p1 = new int[]{50};
		p2 = 1234;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
		p1 = new int[]{10,10,10,10,10,10,10,10};
		p2 = 3353;
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
	// Tomek thinks that smartphones are overrated.
	// He plans to release a new cellphone with an old-school keyboard, which may require you to tap a key multiple times to type a single letter.
	// For example, if the keyboard has two keys, one with the letters "adef" and the other one with the letters "zyx", then typing 'a' requires one keystroke, typing 'f' requires four keystrokes, typing 'y' requires two keystrokes, and so on.
	// 
	// 
	// 
	// Tomek has already designed the keyboard's layout.
	// That is, he already knows the number of keys on the keyboard, and for each key he knows the maximum number of letters it may hold.
	// He now wants to create a specific keyboard for a language that uses N different letters.
	// He has a large body of text in this language, and he already analyzed it to find the frequencies of all N letters of its alphabet.
	// 
	// 
	// 
	// You are given a int[] frequencies with N elements.
	// Each element of frequencies is the number of times one of the letters in Tomek's alphabet appears in the text he has.
	// Each element of frequencies will be strictly positive.
	// (I.e., each of the N letters occurs at least once in Tomek's text.)
	// 
	// 
	// 
	// You are also given a int[] keySize.
	// The number of elements of keySize is the number of keys on Tomek's keyboard.
	// Each element of keySize gives the maximal number of letters on one of the keys.
	// 
	// 
	// 
	// Find an assignment of letters to keys that minimizes the number of keystrokes needed to type Tomek's entire text.
	// Return that minimum number of keystrokes.
	// If there is not enough room on the keys and some letters of the alphabet won't fit, return -1 instead.
	// 
	// 
	// DEFINITION
	// Class:TomekPhone
	// Method:minKeystrokes
	// Parameters:int[], int[]
	// Returns:int
	// Method signature:int minKeystrokes(int[] frequencies, int[] keySizes)
	// 
	// 
	// CONSTRAINTS
	// -frequencies will contain between 1 and 50 elements, inclusive.
	// -Each element of frequencies will be between 1 and 1,000, inclusive.
	// -keySizes will contain between 1 and 50 elements, inclusive.
	// -Each element of keySizes will be between 1 and 50, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {7,3,4,1}
	// {2,2}
	// 
	// Returns: 19
	// 
	// Tomek's language has four letters.
	// Let us call them A, B, C, and D.
	// Tomek's text contains seven As, three Bs, four Cs, and one D.
	// The keyboard has two keys, each of them may contain at most two letters.
	// One optimal solution is to use the keys "AD" and "CB".
	// We can then type each A and each C using a single keystroke, and we need two keystrokes for each B and each D.
	// Therefore, the total number of keystrokes when typing the entire text will be 7*1 + 3*2 + 4*1 + 1*2 = 19.
	// 
	// 
	// 1)
	// {13,7,4,20}
	// {2,1}
	// 
	// Returns: -1
	// 
	// There is not enough space on the keys to fit all four letters.
	// 
	// 2)
	// {11,23,4,50,1000,7,18}
	// {3,1,4}
	// 
	// Returns: 1164
	// 
	// 
	// 
	// 3)
	// {100,1000,1,10}
	// {50}
	// 
	// Returns: 1234
	// 
	// 
	// 
	// 4)
	// {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50}
	// {10,10,10,10,10,10,10,10}
	// 
	// Returns: 3353
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

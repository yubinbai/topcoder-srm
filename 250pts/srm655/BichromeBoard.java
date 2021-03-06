import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BichromeBoard {
	char[][] b;
	int n, m;
	public String ableToDraw(String[] board) {
		n = board.length;
		m = board[0].length();
		b = new char[n][m];
		for (int i = 0; i < n; i++) {
			b[i] = board[i].toCharArray();
		}
		boolean oddBlack = true;
		OUT: for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (b[i - 1][j - 1] != '?') {
					if ( (i ^ j) % 2 == 1 ) {
						oddBlack = (b[i - 1][j - 1] == 'B');
					} else {
						oddBlack = (b[i - 1][j - 1] == 'W');
					}
					break OUT;
				}
			}
		}
		System.out.println(oddBlack);
		boolean result = true;
		OUT2: for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (b[i - 1][j - 1] != '?') {
					char correct = ' ';
					if ( (i ^ j) % 2 == 1) {
						correct = oddBlack ? 'B' : 'W';
					} else {
						correct = oddBlack ? 'W' : 'B';
					}
					if ( b[i - 1][j - 1] != correct) {
						result = false;
						break OUT2;
					}
				}
			}
		}
		return result ? "Possible" : "Impossible";
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		BichromeBoard obj;
		String answer;
		obj = new BichromeBoard();
		long startTime = System.currentTimeMillis();
		answer = obj.ableToDraw(p0);
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

		String[] p0;
		String p1;

		// ----- test 0 -----
		p0 = new String[] {"W?W", "??B", "???"};
		p1 = "Possible";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new String[] {"W??W"};
		p1 = "Impossible";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new String[] {"??"};
		p1 = "Possible";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new String[] {"W???", "??B?", "W???", "???W"};
		p1 = "Possible";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new String[] {"W???", "??B?", "W???", "?B?W"};
		p1 = "Impossible";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new String[] {"B"};
		p1 = "Possible";
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new String[] {
		    "BWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBW",
		    "WBWB?BW??BWBWBWBWBWBWBWBWBWBB?WWWB",
		    "BWBWBWBWBWBWBWBWBWBWBWB?BBBWBWBWBW",
		    "WBWB?B?BWBWBWBW?WBWBWBWBWBWBWBWBWB",
		    "BWBW?WBWBWBWBWBWBWBWBWBWBWBWBWBWBW",
		    "WBWBWW?BWBWB?BWB?BWB?BWBWBWBWBBBW?",
		    "BBBWBWBWWWBWBWBWBWBWBWBWBWBWBWBWBW",
		    "WBWBWBWWWBWBWBWBWBW?WBWBWBBBWBWBWB",
		    "BWBWB?BW?WBWBWBWBWBWBWBWBWBWBWBWB?",
		    "WBWBWB?BWBWB?BWBWB?B?BWBWBWBWBWBWB",
		    "BWBWBWBWBWBWBWB?BWBWBWBWBWBWBWBWBW",
		    "WBWWWBWBWBWB?BWBBBWBWBWBWBWBWBWBWB",
		    "BWBWBWBWBWBWBW?WBW?WBWBW?WBWWWB??W",
		    "WB?B?WWBWBWBWBWBWBWBWBWBWBWBWBWBWB",
		    "BWBWBWBWBWBWB?BWBWBWBWBW?WBWBWBWBW",
		    "WBWBBBWB?BWBWBWBBBWBWBBBWWW?WBWBWB",
		    "BWBWBWWWWWBWBWBWBWBWBWBWBWBWBWBWBW",
		    "WBWB?WWBWBWB?BWWWBWBWBWBWBWBBBWBWB",
		    "BWBWB?BWBWBWBWBWBWBWBW?WBB??BWBWBW",
		    "WBWBWB?BW?WBWBWBW?WBWBWBWBWBW?BBW?",
		    "BWBW?WBBBWB?BWBWBWBWBWBWBWBW?W??BW",
		    "WBWBWBWBWBW?WBWBWBWBWBWBWB?BWBWBWB",
		    "BWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBW",
		    "WBWBWBWBWBWBWBWBBB?BW?WBWBWBWBBBWB",
		    "BWBW?W?WBWBWBWBWBWBBBWBWBWBWBWBWBW",
		    "WBWBWBWBWBW?WBW?WBWBWBBBW?WBW?WBWB",
		    "B?BWBW?WBBBWBWBWBWBWBWBW?WBWWWBWBW",
		    "WBWBWBWBW?WB?BWBWBWBWBBBWBWB??WBWB",
		    "BWBW??BWBWBWBWBWB?WWBWBWBWBWBWBWBW",
		    "WBWBBBWBWBWBWBWB?BWBWBWBWB?BWBWBWB",
		    "BWBWBWBWBWBWBWB?BWBWBWBWBWBWBWBWBB"
		};
		p1 = "Impossible";
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// We have a rectangular board divided into a grid of unit squares.
	// We are going to color each square either white or black.
	//
	//
	// You are given the String[] board.
	// Each character in board represents one unit square.
	// If board[i][j] is 'B', the corresponding square must be black.
	// If board[i][j] is 'W', the corresponding square must be white.
	// Finally, if board[i][j] is '?', you get to choose the color for this square: either white or black.
	//
	//
	// Two squares are adjacent if they share a common side.
	// We want to color the board in such a way that no two adjacent squares share the same color.
	// Return "Possible" (quotes for clarity) if it can be done, or "Impossible" otherwise.
	//
	// DEFINITION
	// Class:BichromeBoard
	// Method:ableToDraw
	// Parameters:String[]
	// Returns:String
	// Method signature:String ableToDraw(String[] board)
	//
	//
	// CONSTRAINTS
	// -board will contain between 1 and 50 elements, inclusive.
	// -Each element in board will contain between 1 and 50 characters, inclusive.
	// -Each element in board will contain the same number of characters.
	// -Each character in board will be one of 'W', 'B', '?'.
	//
	//
	// EXAMPLES
	//
	// 0)
	// {"W?W",
	//  "??B",
	//  "???"}
	//
	// Returns: "Possible"
	//
	// The solution is:
	//
	// WBW
	// BWB
	// WBW
	//
	//
	//
	// 1)
	// {"W??W"}
	//
	// Returns: "Impossible"
	//
	// The four possible colorings of this board are WWWW, WWBW, WBWW, and WBBW.
	// In each of them there is at least one pair of adjacent squares that share the same color.
	// Thus, there is no way to get a pattern with the desired property.
	//
	// 2)
	// {"??"}
	//
	// Returns: "Possible"
	//
	// There are 2 ways:
	// WB and BW
	//
	// 3)
	// {"W???",
	//  "??B?",
	//  "W???",
	//  "???W"}
	//
	// Returns: "Possible"
	//
	//
	//
	// 4)
	// {"W???",
	//  "??B?",
	//  "W???",
	//  "?B?W"}
	//
	// Returns: "Impossible"
	//
	//
	//
	// 5)
	// {"B"}
	//
	// Returns: "Possible"
	//
	//
	//
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

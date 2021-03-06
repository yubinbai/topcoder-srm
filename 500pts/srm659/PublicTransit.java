import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class PublicTransit
{
	public int minimumLongestDistance(int R, int C)
	{
		int result = R + C;
		for (int r1 = 0; r1 < R; r1++) {
			for (int c1 = 0; c1 < C; c1++) {
				for (int r2 = 0; r2 < R; r2++) {
					for (int c2 = 0; c2 < C; c2++) {
						result = Math.min(result, test(r1, c1, r2, c2, R, C));
					}
				}
			}
		}
		return result;
	}
	private int test(int R1, int C1, int R2, int C2, int R, int C) {
		int res = 0;
		for (int r1 = 0; r1 < R; r1++) {
			for (int c1 = 0; c1 < C; c1++) {
				for (int r2 = 0; r2 < R; r2++) {
					for (int c2 = 0; c2 < C; c2++) {
						int d1 = Math.abs(r1 - r2) + Math.abs(c1 - c2);
						int d2 = Math.abs(r1 - R1) + Math.abs(c1 - C1) + Math.abs(r2 - R2) + Math.abs(c2 - C2);
						int d3 = Math.abs(r1 - R2) + Math.abs(c1 - C2) + Math.abs(r2 - R1) + Math.abs(c2 - C1);
						int d = Math.min(d1 ,d2);
						d = Math.min(d, d3);
						res = Math.max(res, d);
					}
				}
			}
		}
		return res;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		PublicTransit obj;
		int answer;
		obj = new PublicTransit();
		long startTime = System.currentTimeMillis();
		answer = obj.minimumLongestDistance(p0, p1);
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
		
		int p0;
		int p1;
		int p2;
		
		// ----- test 0 -----
		p0 = 4;
		p1 = 1;
		p2 = 1;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 2;
		p1 = 2;
		p2 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 5;
		p1 = 3;
		p2 = 4;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 8;
		p1 = 2;
		p2 = 4;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 10;
		p1 = 10;
		p2 = 13;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Note that this problem has a time limit of 5 seconds.
	// 
	// 
	// The city of Gridlock is a grid of cells with R rows and C columns. Each cell has up to four neighbours: the cells directly above, below, to the left, and to the right. A citizen of Gridlock can travel from a cell to any of its neighbours in one minute.
	// 
	// 
	// The citizens of Gridlock are upset that it takes too long to get around, so they have decided to build a teleporter. The teleporter will consist of two identical booths, each located in some cell. If a citizen enters either booth, he or she may choose to teleport to the other booth instantly. It is allowed to build both booths in the same cell.
	// 
	// 
	// We define the distance between two cells as the minimum number of minutes needed to get from one cell to another. Let D be the maximum distance between any two cells. Place the teleporter in such a way that D is minimized, and return this minimum value.
	// 
	// DEFINITION
	// Class:PublicTransit
	// Method:minimumLongestDistance
	// Parameters:int, int
	// Returns:int
	// Method signature:int minimumLongestDistance(int R, int C)
	// 
	// 
	// CONSTRAINTS
	// -R is between 1 and 10, inclusive.
	// -C is between 1 and 10, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 4
	// 1
	// 
	// Returns: 1
	// 
	// The optimal solution is to connect cell (1, 1) to cell (4, 1). (All cell coordinates are 1-based.)
	// 
	// 1)
	// 2
	// 2
	// 
	// Returns: 1
	// 
	// 
	// 
	// 2)
	// 5
	// 3
	// 
	// Returns: 4
	// 
	// 
	// 
	// 3)
	// 8
	// 2
	// 
	// Returns: 4
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class SurroundingGameEasy
{
	public int score(String[] cost, String[] benefit, String[] stone)
	{
		int n = stone.length, m = stone[0].length();
        int ret = 0;
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean dominated = true;
                if (stone[i].charAt(j) != 'o') {
                    for (int d = 0; d < 4; d++) {
                        boolean valid = false;
                        int r = i + direction[d][0], c = j + direction[d][1];
                        if (r < 0 || r >= n || c < 0 || c >= m) {
                            valid = true;
                        } else if (stone[r].charAt(c) == 'o') {
                            valid = true;
                        }
                        if (!valid) {
                            dominated = false;
                            break;
                        }
                    }
                } else {
                    ret -= cost[i].charAt(j) - '0';
                }
                if (dominated) {
                    ret += benefit[i].charAt(j) - '0';
                }
            }
        }
        return ret;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, String[] p1, String[] p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p2[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SurroundingGameEasy obj;
		int answer;
		obj = new SurroundingGameEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.score(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p3);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p3;
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
		String[] p1;
		String[] p2;
		int p3;
		
		// ----- test 0 -----
		p0 = new String[]{"21","12"};
		p1 = new String[]{"21","12"};
		p2 = new String[]{".o","o."};
		p3 = 4;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"99","99"};
		p1 = new String[]{"11","11"};
		p2 = new String[]{".o","o."};
		p3 = -14;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"888","888","888"};
		p1 = new String[]{"000","090","000"};
		p2 = new String[]{"...",".o.","..."};
		p3 = 1;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"4362","4321"};
		p1 = new String[]{"5329","5489"};
		p2 = new String[]{"...o","..o."};
		p3 = 22;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"5413","4323","8321","5490"};
		p1 = new String[]{"0432","7291","3901","2310"};
		p2 = new String[]{"ooo.","o..o","...o","oooo"};
		p3 = -12;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Surrounding Game is a single-player game played on a rectangular grid of cells.
	// Cells are considered adjacent if they share a common side.
	// (Hence, each cell has at most four adjacent cells. 
	// The cells on the sides and in the corners of the grid have fewer adjacent cells than the ones inside the grid.)
	// 
	// The game is played by placing stones into some of the cells.
	// Each cell may only contain at most one stone.
	// A cell is called dominated if at least one of the following two conditions holds:
	// 
	// The cell contains a stone.
	// All cells adjacent to the cell contain stones.
	// 
	// 
	// Each cell of the grid contains two numbers, each from 0 to 9, inclusive:
	// the cost of placing a stone into the cell, and the benefit from dominating the cell.
	// At the end of the game, the overall score of the player is the sum of all benefits minus the sum of all costs.
	// 
	// You are given the String[]s cost and benefit.
	// The characters cost[i][j] and benefit[i][j] represent the two digits written in the cell (i,j).
	// For example, if character 7 of element 4 of cost is '3', the cost of placing a stone into the cell (4,7) is 3.
	// 
	// You are also given a String[] stone that describes the final state of the game.
	// The character stone[i][j] is 'o' (lowercase letter oh) if the cell (i,j) contains a stone.
	// Otherwise, stone[i][j] is '.' (a period).
	// Calculate and return the overall score of the game.
	// 
	// DEFINITION
	// Class:SurroundingGameEasy
	// Method:score
	// Parameters:String[], String[], String[]
	// Returns:int
	// Method signature:int score(String[] cost, String[] benefit, String[] stone)
	// 
	// 
	// CONSTRAINTS
	// -cost will contain between 2 and 20 elements, inclusive.
	// -cost, benefit and stone will each contain the same number of elements.
	// -Each element of cost will contain between 2 and 20 characters, inclusive.
	// -Each element of cost will contain the same number of characters.
	// -Each element of benefit and stone will contain the same number of characters as each element of cost.
	// -Each character in cost and benefit will be a digit ('0'-'9').
	// -Each character in stone will either 'o' (lowercase letter oh) or '.'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"21","12"}
	// {"21","12"}
	// {".o","o."}
	// 
	// Returns: 4
	// 
	// All the cells are dominated, so the overall benefit is 2+1+1+2 = 6.
	// Only two of the cells contain stones.
	// The total cost of placing the stones is 1+1 = 2.
	// Therefore the overall score is 6-2 = 4.
	// 
	// 1)
	// {"99","99"}
	// {"11","11"}
	// {".o","o."}
	// 
	// Returns: -14
	// 
	// A player may get a negative score.
	// 
	// 2)
	// {"888","888","888"}
	// {"000","090","000"}
	// {"...",".o.","..."}
	// 
	// Returns: 1
	// 
	// 
	// 
	// 3)
	// {"4362","4321"}
	// {"5329","5489"}
	// {"...o","..o."}
	// 
	// Returns: 22
	// 
	// 
	// 
	// 4)
	// {"5413","4323","8321","5490"}
	// {"0432","7291","3901","2310"}
	// {"ooo.","o..o","...o","oooo"}
	// 
	// Returns: -12
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

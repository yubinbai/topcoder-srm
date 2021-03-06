import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BallAndHats
{
	public int getHat(String hats, int numSwaps)
	{
		int[][] dp = new int[numSwaps + 1][3];
        for (int i = 0; i < 3; i++) {
            if (hats.charAt(i) == 'o') {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i <= numSwaps; i++) {
            dp[i][0] = dp[i][2] = dp[i - 1][1];
            dp[i][1] = 2 * dp[i - 1][0] + 2 * dp[i - 1][2];
            int g = gcd(gcd(dp[i][0], dp[i][1]), dp[i][2]);
            for (int j = 0; j < 3; j++) {
                dp[i][j] /= g;
            }
        }
        int a = dp[numSwaps][0];
        int b = dp[numSwaps][1];
        int c = dp[numSwaps][2];
        if (a > b && a > c) return 0;
        if (b > a && b > c) return 1;
        if (c > a && c > b) return 2;
        if (a > b) {
            return 0;
        } else {
            return 1;
        }
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + p1);
		System.out.println("]");
		BallAndHats obj;
		int answer;
		obj = new BallAndHats();
		long startTime = System.currentTimeMillis();
		answer = obj.getHat(p0, p1);
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
		int p1;
		int p2;
		
		// ----- test 0 -----
		p0 = ".o.";
		p1 = 1;
		p2 = 0;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "..o";
		p1 = 0;
		p2 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "o..";
		p1 = 1;
		p2 = 1;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "..o";
		p1 = 2;
		p2 = 0;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "o..";
		p1 = 101;
		p2 = 1;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// A magician has invited you to play a game. For this game, the magician uses a special table. On the table there are three spots in a row. The spots are labeled 0, 1, and 2, in order. He places three hats onto the table, so that each hat covers one of the spots. He then takes a ball and places it under one of the hats. The hats are not transparent, so you cannot see the ball while it is under a hat. Next, the magician shuffles the hats by repeatedly swapping two adjacent hats. Each swap is done by sliding the hats along the table, never showing you the ball.
	// Once the magician finishes swapping the hats, you have to guess the spot where the ball is. 
	// 
	// You are given a String hats which describes the contents of the hats in the beginning of the game. The i-th character of hats is 'o' if the ball was initially on the spot i. Otherwise, the i-th character of hats is '.' (a period).  
	// 
	// You are also given a int numSwaps. Assume that the magician swapped the hat that contained the ball exactly numSwaps times. Please remember that in our version of the game the magician always swaps two adjacent hats. Also, note that the total number of swaps in the game may be larger than numSwaps, because the magician may sometimes swap two hats that don't contain the ball.  
	// 
	// Assume that the magician chose the swaps he makes uniformly at random. That is, in each turn with probability 50% he swapped the hats on spots 0 and 1, and with probability 50% he swapped the hats on spots 1 and 2. Return the number of the spot that is most likely to contain the ball at the end of the game. If multiple spots are tied for the largest probability, return the smallest one of them.
	// 
	// DEFINITION
	// Class:BallAndHats
	// Method:getHat
	// Parameters:String, int
	// Returns:int
	// Method signature:int getHat(String hats, int numSwaps)
	// 
	// 
	// NOTES
	// -Two hats are adjacent if their spots differ by 1.
	// 
	// 
	// CONSTRAINTS
	// -hats will contain exactly three characters.
	// -hats will contain exactly one 'o' character.
	// -hats will contain exactly two '.' characters.
	// -numSwaps will be between 0 and 1000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// ".o."
	// 1
	// 
	// Returns: 0
	// 
	// The spots 0 and 2 are equally likely to contain the ball after the hat that contains it is swapped once.
	// We return the smallest spot number, which is 0.
	// 
	// 1)
	// "..o"
	// 0
	// 
	// Returns: 2
	// 
	// The ball does not change spots when 0 swaps are performed; therefore, the ball must be at spot 2.
	// 
	// 2)
	// "o.."
	// 1
	// 
	// Returns: 1
	// 
	// 
	// 
	// 3)
	// "..o"
	// 2
	// 
	// Returns: 0
	// 
	// 
	// 
	// 4)
	// "o.."
	// 101
	// 
	// Returns: 1
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

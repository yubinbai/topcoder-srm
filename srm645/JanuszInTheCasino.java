import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class JanuszInTheCasino
{
    HashMap dp[];
    int m;
	public double findProbability(long n, int m, int k)
	{
        dp = new HashMap[k + 1];
        for (int i = 0; i <= k; i++) {
            dp[i] = new HashMap<Long, Double>();
        }
        this.m = m;
        return find(n, k);
    }

    private double find(long n, int k) {
        if (k == 0) {
            return n > 0 ? 1.0 : 0.0;
        }
        if (!dp[k].containsKey(n)) {
            long v = n / m;
            int big = (int) (n % m);
            int small = m - big;
            double r = (big * 1.0 / m) * find(n - v - 1, k - 1) + (small * 1.0 / m) * find(n - v, k - 1);
            dp[k].put(n, r);
        }
        return (Double) dp[k].get(n);
    }

    // BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, long p0, int p1, int p2, boolean hasAnswer, double p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
		System.out.println("]");
		JanuszInTheCasino obj;
		double answer;
		obj = new JanuszInTheCasino();
		long startTime = System.currentTimeMillis();
		answer = obj.findProbability(p0, p1, p2);
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
			res = answer == answer && Math.abs(p3 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p3));
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
		
		long p0;
		int p1;
		int p2;
		double p3;
		
		// ----- test 0 -----
		p0 = 3L;
		p1 = 2;
		p2 = 2;
		p3 = 0.75D;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 1L;
		p1 = 3;
		p2 = 3;
		p3 = 0.2962962962962962D;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 4L;
		p1 = 3;
		p2 = 2;
		p3 = 1.0D;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 5L;
		p1 = 4;
		p2 = 5;
		p3 = 0.87109375D;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 1000000000000L;
		p1 = 2;
		p2 = 40;
		p3 = 0.9094947017729282D;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------

		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Janusz is in a casino with some friends.
	// Their group consists of n people.
	// They are all going to play a game.
	// 
	// The game is played on a plan that is divided into m fields.
	// At the beginning of the game, each player gets their own unique token.
	// The game then consists of k rounds.
	// Each round looks as follows:
	// 
	// Each player places their token onto one of the fields.
	// One of the fields is chosen uniformly at random.
	// The tokens in the chosen field are removed from the game. The players who placed those tokens are out of the game.
	// 
	// The players who are still in the game after the last round win the game.
	// 
	// Our group of players wants to maximize the probability that at least one of them wins the game.
	// You are given the long n and the ints m and k.
	// Compute and return the probability that there will be at least one winner if they play the game optimally.
	// 
	// 
	// DEFINITION
	// Class:JanuszInTheCasino
	// Method:findProbability
	// Parameters:long, int, int
	// Returns:double
	// Method signature:double findProbability(long n, int m, int k)
	// 
	// 
	// NOTES
	// -The return value must have an absolute error at most 1e-3.
	// 
	// 
	// CONSTRAINTS
	// -n will be between 1 and 10^12, inclusive.
	// -m and k will be between 1 and 50, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 3
	// 2
	// 2
	// 
	// Returns: 0.75
	// 
	// There are 3 players, 2 fields on the plan, and 2 rounds of the game.
	// In the first round the players should place one token onto the first field and two tokens onto the second field.
	// 
	// With probability 0.5 the first field is chosen.
	// If that happens, there will be two players in the second round. 
	// Each of them will choose a different field and thus one of them will certainly win the game.
	// 
	// With probability 0.5 the second field is chosen in the first round.
	// If that happens, there will only be a single player in the second round.
	// The probability that this player survives the second round is 0.5.
	// 
	// Hence, the answer is 0.5*1 + 0.5*0.5 = 0.75.
	// 
	// 
	// 1)
	// 1
	// 3
	// 3
	// 
	// Returns: 0.2962962962962962
	// 
	// There is only one player: Janusz.
	// He will survive each round with probability 2/3.
	// Hence, the probability that he will win the entire game is (2/3)^3.
	// 
	// 2)
	// 4
	// 3
	// 2
	// 
	// Returns: 1.0
	// 
	// One optimal strategy for the first round is to put two tokens onto one field and one token onto each of the other two fields.
	// Even if we lose the two tokens, we will still have two players in the second round and we can make sure that at least one of them will win the game.
	// 
	// 3)
	// 5
	// 4
	// 5
	// 
	// Returns: 0.87109375
	// 
	// 
	// 
	// 4)
	// 1000000000000
	// 2
	// 40
	// 
	// Returns: 0.9094947017729282
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
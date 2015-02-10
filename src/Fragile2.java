import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class Fragile2
{
	int n, time = 0;
	int[] disc_time, low, st;
	boolean[] visited;

	public int countPairs(String[] graph)
	{
		n = graph.length;
		visited = new boolean[n];

		st = new int[n];
		low = new int[n];

		dfs(0);
	}
	private void getArticulationPoints(int u) {
		visited[u] = true;
		st[u] = time++;
		low[u] = 


	}

// getArticulationPoints(u)
// 	visited[u] = true
// 	u.st = time++
// 	u.low = v.st	//keeps track of highest ancestor reachable from any descendants
// 	dfsChild = 0	//needed because if no child then removing this node doesn't decompose graph
// 	for each ni in adj[i]
// 		if not visited[ni]
// 			getArticulationPoints(ni)
// 			++dfsChild
// 			parents[ni] = u
// 			u.low = Min(u.low, ni.low)	//while coming back up, get the lowest reachable ancestor from descendants
// 		else if ni <> parent[u]	//while going down, note down the back edges
// 			u.low = Min(u.low, ni.st)
 
// 	//For dfs root node, we can't mark it as articulation point because 
// 	//disconnecting it may not decompose graph. So we have extra check just for root node.
// 	if (u.low = u.st and dfsChild > 0 and parent[u] != null) or (parent[u] = null and dfsChild > 1)
// 		Output u as articulation point
// 		Output edges of u with v.low >= u.low as bridges
// 	Output u.low as bicomponent ID
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		Fragile2 obj;
		int answer;
		obj = new Fragile2();
		long startTime = System.currentTimeMillis();
		answer = obj.countPairs(p0);
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
		
		String[] p0;
		int p1;
		
		// ----- test 0 -----
		p0 = new String[]{"NYNN","YNYN","NYNY","NNYN"};
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"NYNNNN","YNYNNN","NYNNNN","NNNNYN","NNNYNY","NNNNYN"};
		p1 = 5;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"NNN","NNN","NNN"};
		p1 = 0;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"NYNYNNYYNN","YNNNYNYYNN","NNNNYNNNYN","YNNNYYNNNN","NYYYNNNNYN","NNNYNNNNYN","YYNNNNNNNN","YYNNNNNNYN","NNYNYYNYNY","NNNNNNNNYN"};
		p1 = 9;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"NNNYNNYNNNNNNNYYNNNY","NNNNNNNNYNNNNNNNNNNN","NNNNNNNNNNNNNNNNNNNN","YNNNNNNNNNYNNNNNNNNN","NNNNNNNYNNNNNYNNNNYN","NNNNNNNNNNNNNNNNYNNY","YNNNNNNNNNNNNYYYNYNN","NNNNYNNNNNNNNYYNNNNN","NYNNNNNNNYNNNNNNNNNN","NNNNNNNNYNNNYNNNNNYN","NNNYNNNNNNNNNNYNNNNN","NNNNNNNNNNNNNNNNNNNN","NNNNNNNNNYNNNNNNNYNN","NNNNYNYYNNNNNNNNNNNN","YNNNNNYYNNYNNNNNNNNN","YNNNNNYNNNNNNNNNYNNN","NNNNNYNNNNNNNNNYNYNN","NNNNNNYNNNNNYNNNYNNN","NNNNYNNNNYNNNNNNNNNN","YNNNNYNNNNNNNNNNNNNN"};
		p1 = 42;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Lun the dog has found an undirected graph in Shuseki Forest. The graph consisted of N vertices and some edges. The vertices of the graph were numbered 0 through N-1. Each edge connected a different pair of vertices.
	// 
	// You are given the description of the graph in a String[] graph with N elements, each containing N characters. For each i and j, graph[i][j] will be 'Y' if vertex i and vertex j are connected by an edge, and 'N' otherwise. (Note that for each i, graph[i][i] will be 'N': there are no self-loops.)
	// 
	// Lun is interested in articulation pairs in this graph. An articulation pair is an unordered pair of two different vertices whose deletion increases the number of connected components in the graph. (The deletion of a vertex also removes all edges incident with that vertex.)
	// 
	// Return the number of the articulation pairs in Lun's graph.
	// 
	// DEFINITION
	// Class:Fragile2
	// Method:countPairs
	// Parameters:String[]
	// Returns:int
	// Method signature:int countPairs(String[] graph)
	// 
	// 
	// NOTES
	// -You are not given the value of N explicitly, but you can determine it as the number of elements in graph.
	// -Two vertices belong to the same connected component if and only if we can reach one of them from the other by following a sequence of zero or more edges.
	// 
	// 
	// CONSTRAINTS
	// -graph will contain between 3 and 20 elements, inclusive.
	// -Each element of graph will contain N characters, where N is the number of the elements in graph.
	// -Each character of each element of graph will be either 'Y' or 'N'.
	// -For each valid i and j, graph[i][j] will be equal to graph[j][i].
	// -For each valid i, graph[i][i] will be 'N'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"NYNN", "YNYN", "NYNY", "NNYN"}
	// 
	// Returns: 3
	// 
	// The graph looks as follows:
	// 
	// 
	// 
	// The articulation pairs are (0, 2), (1, 2) and (1, 3).
	// For example, here is why (0, 2) is an articulation pair:
	// Currently there is one connected component.
	// (It contains all four vertices.)
	// If we remove the vertices 0 and 2, and all edges incident to these vertices, we will be left with two isolated vertices: 1 and 3.
	// Each of these vertices now forms a different connected component, so the number of connected components increased from 1 to 2.
	// 
	// 1)
	// {"NYNNNN", "YNYNNN", "NYNNNN", "NNNNYN", "NNNYNY", "NNNNYN"}
	// 
	// Returns: 5
	// 
	// 
	// 
	// The articulation pairs are (0, 4), (1, 3), (1, 4), (1, 5) and (2, 4).
	// 
	// 2)
	// {"NNN", "NNN", "NNN"}
	// 
	// Returns: 0
	// 
	// 
	// 
	// There are no articulation pairs.
	// 
	// 3)
	// {"NYNYNNYYNN", "YNNNYNYYNN", "NNNNYNNNYN", "YNNNYYNNNN", "NYYYNNNNYN",
	//  "NNNYNNNNYN", "YYNNNNNNNN", "YYNNNNNNYN", "NNYNYYNYNY", "NNNNNNNNYN"}
	// 
	// Returns: 9
	// 
	// 
	// 
	// 4)
	// {"NNNYNNYNNNNNNNYYNNNY", "NNNNNNNNYNNNNNNNNNNN", "NNNNNNNNNNNNNNNNNNNN", "YNNNNNNNNNYNNNNNNNNN", "NNNNNNNYNNNNNYNNNNYN",
	//  "NNNNNNNNNNNNNNNNYNNY", "YNNNNNNNNNNNNYYYNYNN", "NNNNYNNNNNNNNYYNNNNN", "NYNNNNNNNYNNNNNNNNNN", "NNNNNNNNYNNNYNNNNNYN",
	//  "NNNYNNNNNNNNNNYNNNNN", "NNNNNNNNNNNNNNNNNNNN", "NNNNNNNNNYNNNNNNNYNN", "NNNNYNYYNNNNNNNNNNNN", "YNNNNNYYNNYNNNNNNNNN",
	//  "YNNNNNYNNNNNNNNNYNNN", "NNNNNYNNNNNNNNNYNYNN", "NNNNNNYNNNNNYNNNYNNN", "NNNNYNNNNYNNNNNNNNNN", "YNNNNYNNNNNNNNNNNNNN"}
	// 
	// Returns: 42
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

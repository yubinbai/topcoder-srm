import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class OddEvenTreeHard {
    public int[] getTree(String[] x) {
        int n = x.length;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; ++j) {
                switch (x[i].charAt(j)) {
                case 'E':
                    d[i][j] = 0;
                    break;
                case 'O':
                    d[i][j] = 1;
                    break;
                case '?':
                    d[i][j] = -1;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == -1) {
                    d[i][j] = d[j][i];
                }
                if (i == j) {
                    if (d[i][j] == 1) return new int[] { -1};
                } else {
                    if (d[i][j] != d[j][i] && d[i][j] >= 0 && d[j][i] >= 0) {
                        return new int[] { -1};
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (d[i][k] >= 0 && d[k][j] >= 0) {
                        d[i][j] = d[j][i] = (d[i][k] + d[k][j]) % 2;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (d[i][j] >= 0 && d[i][k] >= 0 && d[k][j] >= 0) {
                        if (d[i][j] != (d[i][k] + d[j][k]) % 2) {
                        	return new int[] { -1};
                        }
                    }
                }
            }
        }

        int odd = 1;
        for (; odd < n; odd++) {
            if (d[0][odd] == 1 || d[0][odd] == -1) break;
        }
        if (odd == n) {
            return new int[] { -1};
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < n; i++) {
            if (d[0][i] == 1 || d[0][i] == -1) {
                result.add(0);
                result.add(i);
                odd = i;
            }
        }

        for (int i = 1; i < n; i++) {
            if (d[0][i] == 0) {
                result.add(odd);
                result.add(i);
            }
        }
        int[] re = new int[result.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = result.get(i);
        }
        return re;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int[] p1) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p0[i] + "\"");
        }
        System.out.print("}");
        System.out.println("]");
        OddEvenTreeHard obj;
        int[] answer;
        obj = new OddEvenTreeHard();
        long startTime = System.currentTimeMillis();
        answer = obj.getTree(p0);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.print("\t" + "{");
            for (int i = 0; p1.length > i; ++i) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print(p1[i]);
            }
            System.out.println("}");
        }
        System.out.println("Your answer:");
        System.out.print("\t" + "{");
        for (int i = 0; answer.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(answer[i]);
        }
        System.out.println("}");
        if (hasAnswer) {
            if (answer.length != p1.length) {
                res = false;
            } else {
                for (int i = 0; answer.length > i; ++i) {
                    if (answer[i] != p1[i]) {
                        res = false;
                    }
                }
            }
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
        int[] p1;

        // ----- test 0 -----
        p0 = new String[] {"EOE", "OEO", "EOE"};
        p1 = new int[] {0, 1, 2, 1};
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new String[] {"????", "????", "????", "????"};
        p1 = new int[] {0, 1, 0, 3, 2, 1};
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new String[] {"????", "????", "??O?", "????"};
        p1 = new int[] { -1};
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new String[] {"??O?", "????", "E???", "????"};
        p1 = new int[] { -1};
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new String[] {"?O??", "??O?", "???O", "????"};
        p1 = new int[] {0, 1, 0, 3, 2, 1};
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new String[] {"?E??", "??E?", "???E", "????"};
        p1 = new int[] { -1};
        all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
        // ------------------

        // ----- test 6 -----
        p0 = new String[] {"?????????????", "??????????OE?", "?????????????", "?????????????", "?????????????", "?????????????", "?????????????", "???????E?????", "???????E?????", "?????????????", "???????????O?", "???????????E?", "????????????E"};
        p1 = new int[] {0, 1, 0, 3, 0, 5, 0, 7, 0, 8, 0, 11, 0, 12, 2, 1, 4, 1, 6, 1, 9, 1, 10, 1};
        all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // In a tree, the distance between two nodes is the number of edges on the (only) simple path that connects them.
    //
    //
    // You are given a String[] x with N elements, each containing N characters.
    // Draw a tree with N nodes, numbered 0 through N-1.
    // The tree must have the following properties:
    //
    // For each i and j, if x[i][j] is one of 'E', 'O' (uppercase o), and '?'.
    //
    // If x[i][j]='E', the distance between i and j must be even.
    // If x[i][j]='O', the distance between i and j must be odd.
    // If x[i][j]='?', the distance between i and j may be arbitrary.
    //
    //
    //
    // If there is no tree with these properties, return {-1}.
    // Otherwise, return a int[] with 2N-2 elements: the list of edges in one such tree.
    // For example, if N=3 and your tree contains the edges 0-2 and 1-2, return {0,2,1,2}.
    // If there are multiple correct outputs you may output any of them.
    //
    // DEFINITION
    // Class:OddEvenTreeHard
    // Method:getTree
    // Parameters:String[]
    // Returns:int[]
    // Method signature:int[] getTree(String[] x)
    //
    //
    // NOTES
    // -If you use plugins to test your solution, be careful. Plugins cannot tell you whether your solution is correct -- they'll just tell you whether it matches the example output exactly.
    //
    //
    // CONSTRAINTS
    // -n will be between 2 and 50, inclusive.
    // -x will contain exactly n elements.
    // -Each element in x will have exactly n characters.
    // -Each character in x will be 'O', 'E' or '?'.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {"EOE",
    //  "OEO",
    //  "EOE"}
    //
    // Returns: {0, 1, 2, 1 }
    //
    // The tree 0-1-2 is a valid solution.
    //
    // 1)
    // {"????",
    //  "????",
    //  "????",
    //  "????"}
    //
    // Returns: {0, 1, 0, 3, 2, 1 }
    //
    // Any tree with 4 nodes is a valid solution.
    //
    // 2)
    // {"????",
    //  "????",
    //  "??O?",
    //  "????"}
    //
    // Returns: {-1 }
    //
    // dist[2][2] should be zero, can't be an odd number.
    //
    // 3)
    // {"??O?",
    //  "????",
    //  "E???",
    //  "????"}
    //
    // Returns: {-1 }
    //
    // dist[0][2] = dist[2][0], they should be both even or both odd.
    //
    // 4)
    // {"?O??",
    //  "??O?",
    //  "???O",
    //  "????"}
    //
    // Returns: {0, 1, 0, 3, 2, 1 }
    //
    //
    //
    // 5)
    // {"?E??",
    //  "??E?",
    //  "???E",
    //  "????"}
    //
    // Returns: {-1 }
    //
    //
    //
    // 6)
    // {"?????????????","??????????OE?","?????????????","?????????????","?????????????","?????????????","?????????????","???????E?????","???????E?????",
    // "?????????????","???????????O?","???????????E?","????????????E"}
    //
    // Returns: {0, 1, 0, 3, 0, 5, 0, 7, 0, 8, 0, 11, 0, 12, 2, 1, 4, 1, 6, 1, 9, 1, 10, 1 }
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

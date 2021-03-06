import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TorusSailingEasy {
    boolean[][] visited;
    int n, m;
    public double expectedTime(int N, int M, int goalX, int goalY) {
        this.n = N;
        this.m = M;
        visited = new boolean[N][M];
        ArrayList<Integer> xList = new ArrayList<Integer>();
        ArrayList<Integer> yList = new ArrayList<Integer>();
        int x = 0, y = 0;
        while (!visited[x][y]) {
            visited[x][y] = true;
            xList.add(x);
            yList.add(y);
            x = (x + 1) % n;
            y = (y + 1) % m;
        }
        if (!visited[goalX][goalY]) {
            return -1.0;
        } else {
            int size = xList.size();
            double[][] A = new double[size][size];
            A[0][0] = 1;
            for (int i = 1; i < size - 1; ++i) {
                A[i][i - 1] = 1;
                A[i][i] = -2;
                A[i][i + 1] = 1;
            }
            A[size - 1][size - 2] = 1;
            A[size - 1][size - 1] = -2;
            double[] b = new double[size];
            for (int i = 0; i < size; ++i) {
                b[i] = -2;
            }
            b[0] = 0;
            double[] ret = lsolve(A, b);
            for (int i = 0; i < size; i++) {
                if (xList.get(i) == goalX && yList.get(i) == goalY) return ret[i];
            }
            return ret[0];
        }
    }

    // Gaussian elimination with partial pivoting
    public static double[] lsolve(double[][] A, double[] b) {
        double EPSILON = 1e-10;
        int N  = b.length;

        for (int p = 0; p < N; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < N; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;
            double   t    = b[p];
            b[p] = b[max];
            b[max] = t;

            // singular or nearly singular
            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new RuntimeException("Matrix is singular or nearly singular");
            }

            // pivot within A and b
            for (int i = p + 1; i < N; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < N; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // back substitution
        double[] x = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }


    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, double p4) {
        System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
        System.out.println("]");
        TorusSailingEasy obj;
        double answer;
        obj = new TorusSailingEasy();
        long startTime = System.currentTimeMillis();
        answer = obj.expectedTime(p0, p1, p2, p3);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p4);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == answer && Math.abs(p4 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p4));
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
        int p3;
        double p4;

        // ----- test 0 -----
        p0 = 2;
        p1 = 2;
        p2 = 1;
        p3 = 1;
        p4 = 1.0D;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 2;
        p1 = 2;
        p2 = 0;
        p3 = 1;
        p4 = -1.0D;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 3;
        p1 = 3;
        p2 = 1;
        p3 = 1;
        p4 = 2.0D;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 4;
        p1 = 6;
        p2 = 1;
        p3 = 3;
        p4 = 27.0D;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

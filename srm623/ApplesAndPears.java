import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ApplesAndPears {
    public int getArea(String[] board, int K) {
        int n = board.length;
        int[][][] m = new int[n + 1][n + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int w = 0; w <= i; w++) {
                    for (int h = 0; h <= j; h++) {
                        switch (board[w].charAt(h)) {
                        case 'A': m[i + 1][j + 1][0]++; break;
                        case 'P': m[i + 1][j + 1][1]++; break;
                        }
                    }
                }
            }
        }
        int A = m[n][n][0], P = m[n][n][1], E = n * n - A - P, max = 1;
        if (E == 0) K = 0;
        for (int w = 1; w <= n; w++) {
            for (int h = 1; h <= n; h++) {
                int s = w * h;
                if (s <= max) continue;
                for (int x = 0; x + w <= n; x++) {
                    for (int y = 0; y + h <= n; y++) {
                        int a = m[x + w][y + h][0] - m[x + w][y][0] - m[x][y + h][0] + m[x][y][0];
                        int p = m[x + w][y + h][1] - m[x + w][y][1] - m[x][y + h][1] + m[x][y][1];
                        if (A >= s && s - a + p <= K) max = s;
                        if (P >= s && s - p + a <= K) max = s;
                        if (E >= s && a + p <= K) max = s;

                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;


        time = System.currentTimeMillis();
        answer = new ApplesAndPears().getArea(new String[] {".A", "P."}, 0);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 1;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new ApplesAndPears().getArea(new String[] {".A", "P."}, 1);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 2;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new ApplesAndPears().getArea(new String[] {".PP",  "PPA",  "PAP"}, 3);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 6;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new ApplesAndPears().getArea(new String[] {"A.P.PAAPPA", "PPP..P.PPP", "AAP.A.PAPA", "P.PA.AAA.A", "...PA.P.PA", "P..A.A.P..", "PAAP..A.A.", "PAAPPA.APA", ".P.AP.P.AA", "..APAPAA.."}, 10);
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 21;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();


        if (errors)
            System.out.println("Some of the test cases had errors :-(");
        else
            System.out.println("You're a stud (at least on the test data)! :-D ");
    }

}
//Powered by [KawigiEdit] 2.0!

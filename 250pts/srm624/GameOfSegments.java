import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class GameOfSegments {
    public static int[] grundy = new int[1005];
    static {
        for (int i = 0; i < 1005; i++) {
            HashSet<Integer> next = new HashSet<Integer>();
            for (int j = 0; j < i - 1; j++) {
                next.add(grundy[j] ^ grundy[i - 2 - j]);
            }
            while (next.contains(grundy[i])) {
                grundy[i]++;
            }
        }
    }
    public int winner(int N) {
        return grundy[N] != 0 ? 1 : 2;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;


        time = System.currentTimeMillis();
        answer = new GameOfSegments().winner(3);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
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
        answer = new GameOfSegments().winner(4);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
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
        answer = new GameOfSegments().winner(15);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
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
        answer = new GameOfSegments().winner(191);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
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


        if (errors)
            System.out.println("Some of the test cases had errors :-(");
        else
            System.out.println("You're a stud (at least on the test data)! :-D ");
    }

}
//Powered by [KawigiEdit] 2.0!

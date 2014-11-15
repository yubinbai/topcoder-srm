import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class IncrementingSequence {
    public String canItBeDone(int k, int[] A) {
        Arrays.sort(A);
        int[] temp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            temp[i] = i + 1;
        }
        // O ( n * nlog_n )
        for (int i = 0; i < A.length; i++) {
            if (A[i] < temp[i]) {
                // definitely need to increase it since we cannot have A[i] < i + 1
                while (A[i] < temp[i]) {
                    A[i] += k;
                }
                if (A[i] > temp[i]) {
                    // rearrange to find the smallest at current position
                    Arrays.sort(A);
                    i--;
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != temp[i])
                return "IMPOSSIBLE";
        }
        return "POSSIBLE";

    }

    public static void main(String[] args) {
        long time;
        String answer;
        boolean errors = false;
        String desiredAnswer;


        time = System.currentTimeMillis();
        answer = new IncrementingSequence().canItBeDone(3, new int[] {1, 2, 4, 3});
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "POSSIBLE";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new IncrementingSequence().canItBeDone(5, new int[] {2, 2});
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "IMPOSSIBLE";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new IncrementingSequence().canItBeDone(1, new int[] {1, 1, 1, 1, 1, 1, 1, 1});
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "POSSIBLE";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new IncrementingSequence().canItBeDone(2, new int[] {5, 3, 3, 2, 1});
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "IMPOSSIBLE";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new IncrementingSequence().canItBeDone(9, new int[] {1, 2, 3, 1, 4, 5, 6, 7, 9, 8});
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "POSSIBLE";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new IncrementingSequence().canItBeDone(2, new int[] {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2});
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "POSSIBLE";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new IncrementingSequence().canItBeDone(1, new int[] {1});
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = "POSSIBLE";
        System.out.println("Your answer:");
        System.out.println("\t\"" + answer + "\"");
        System.out.println("Desired answer:");
        System.out.println("\t\"" + desiredAnswer + "\"");
        if (!answer.equals(desiredAnswer)) {
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

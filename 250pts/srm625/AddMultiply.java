import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class AddMultiply {
    public int[] makeExpression(int y) {
        boolean[] isPrime = new boolean[1000];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < 1000; i++) {
            for (int j = i + i; j < 1000; j += i) {
                isPrime[j] = false;
            }
        }
        int[] ret = new int[3];
        if (y < 250) {
            ret[2] = -250;
        } else {
            ret[2] = 2;
        }
        while (isPrime[y - ret[2]] || ret[2] == 0 && ret[2] == 1) {
            ret[2]++;
        }
        int total = y - ret[2];
        for (int p = 2; p < total; p++) {
            if (total % p == 0) {
                ret[0] = p;
                ret[1] = total / p;
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        long time;
        int[] answer;
        boolean errors = false;
        int[] desiredAnswer;

        boolean same;

        time = System.currentTimeMillis();
        answer = new AddMultiply().makeExpression(6);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new int[] {2, 2, 2 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new AddMultiply().makeExpression(11);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new int[] {2, 3, 5 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new AddMultiply().makeExpression(0);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new int[] {7, 10, -70 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new AddMultiply().makeExpression(500);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new int[] {-400, -3, -700 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new AddMultiply().makeExpression(2);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new int[] {2, 2, -2 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        } else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new AddMultiply().makeExpression(5);
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = new int[] {5, 2, -5 };
        System.out.println("Your answer:");
        if (answer.length > 0) {
            System.out.print("\t{ " + answer[0]);
            for (int i=1; i<answer.length; i++)
                System.out.print(", " + answer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        System.out.println("Desired answer:");
        if (desiredAnswer.length > 0) {
            System.out.print("\t{ " + desiredAnswer[0]);
            for (int i=1; i<desiredAnswer.length; i++)
                System.out.print(", " + desiredAnswer[i]);
            System.out.println(" }");
        } else
            System.out.println("\t{ }");
        same = desiredAnswer.length == answer.length;
        for (int i=0; i<answer.length && same; i++)
            if (answer[i] != desiredAnswer[i])
                same = false;
        if (!same) {
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
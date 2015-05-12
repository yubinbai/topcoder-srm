import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class SumOfPower {
    public int findSum(int[] array) {
        int[] s = new int[array.length];
        int n = array.length;
        if (array.length == 0) return 0;
        s[0] = array[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + array[i];
        }
        int ret = 0, curr;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    curr = s[j];
                } else {
                    curr = s[j] - s[i - 1];
                }
                ret += curr;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;


        time = System.currentTimeMillis();
        answer = new SumOfPower().findSum(new int[] {1,2});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
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
        answer = new SumOfPower().findSum(new int[] {1,1,1});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 10;
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
        answer = new SumOfPower().findSum(new int[] {3,14,15,92,65});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 1323;
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
        answer = new SumOfPower().findSum(new int[] {1,2,3,4,5,6,7,8,9,10});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 1210;
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
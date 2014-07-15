import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ConundrumReloaded {
    public int minimumLiars(String answers) {
        int qCount = 0;
        int n = answers.length();
        char[] ansc = answers.toCharArray();
        boolean[] isL = new boolean[n];
        for (char c : ansc) {
            if (c == '?') qCount++;
        }
        if (qCount == n) return 0;
        int ret = n;
        if (qCount == 0) {
            for (int i = 0; i < n - 1; ++i) {
                isL[i + 1] = isL[i] ^ (ansc[i] == 'L');
            }
            if (isL[0] ^ (ansc[n - 1] == 'L')) {
                return -1;
            } else {
                int cnt = 0;
                for (boolean b : isL) {
                    if (b) cnt++;
                }
                return Math.min(cnt, n - cnt);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;


        time = System.currentTimeMillis();
        answer = new ConundrumReloaded().minimumLiars("LLH");
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
        answer = new ConundrumReloaded().minimumLiars("?????");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 0;
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
        answer = new ConundrumReloaded().minimumLiars("LHLH?");
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
        answer = new ConundrumReloaded().minimumLiars("??LLLLLL??");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = 3;
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
        answer = new ConundrumReloaded().minimumLiars("LLL");
        System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
        desiredAnswer = -1;
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

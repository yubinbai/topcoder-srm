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
        if (qCount == 0) {
            for (int i = 0; i < n - 1; ++i) {
                isL[i + 1] = isL[i] ^ (ansc[i] == 'L');
            }
            if ( (isL[n - 1] ^ (ansc[n - 1] == 'L')) != isL[0] ) {
                return -1;
            } else {
                int cnt = 0;
                for (boolean b : isL) {
                    if (b) cnt++;
                }
                return Math.min(cnt, n - cnt);
            }
        }
        int start = 0;
        while (!(ansc[start % n] == '?' && ansc[(start + 1) % n] != '?')) start++;
        int ret = 0;
        for (int i = start; i < start + n; ++i) {
            int currLen = 1, currCost = 0;
            boolean curr = true;
            while (ansc[(i + 1) % n] != '?' && i < start + n) {
                curr ^= (ansc[(i + 1) % n] == 'L');
                if (!curr) currCost++;
                currLen++;
                i++;
            }
            ret += Math.min(currCost, currLen - currCost);
        }
        return ret;
    }

    public static void main(String[] args) {
        long time;
        int answer;
        boolean errors = false;
        int desiredAnswer;


        time = System.currentTimeMillis();
        answer = new ConundrumReloaded().minimumLiars("LHL");
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

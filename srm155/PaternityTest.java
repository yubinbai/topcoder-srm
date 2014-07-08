package topcoder;

import java.util.ArrayList;

public class PaternityTest {
    public int[] possibleFathers(String child, String mother, String[] men) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < men.length; i++)
            if (check(child, mother, men[i]))
                ans.add(i);
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = ans.get(i);
        return ret;
    }

    boolean check(String a, String b, String c) {
        int n = a.length();
        for (int i = 0; i < 1 << n; i++)
            if (Integer.bitCount(i) == n / 2) {
                boolean ok = true;
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) == 0)
                        ok &= a.charAt(j) == b.charAt(j);
                    else
                        ok &= a.charAt(j) == c.charAt(j);
                }
                if (ok) return true;
            }
        return false;
    }
}

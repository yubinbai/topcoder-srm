package topcoder;

import java.util.ArrayList;

public class LeaguePicks {
    public int[] returnPicks(int position, int friends, int picks) {
        ArrayList<Integer> seq = new ArrayList<Integer>();
        for (int round = 0; round < picks / friends; round++) {
            for (int i = 1; i <= friends; i++)
                seq.add(i);
            for (int i = friends; i > 0; i--)
                seq.add(i);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < picks; i++)
            if (seq.get(i) == position)
                res.add(i + 1);
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ret[i] = res.get(i);
        return ret;
    }
}

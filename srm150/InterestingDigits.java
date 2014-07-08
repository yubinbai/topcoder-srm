package topcoder;

import java.util.ArrayList;
import java.util.List;

public class InterestingDigits {
    public int[] digits(int base) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int d = 2; d < base; d++)
            if (base % d == 1)
                res.add(d);
        return toIntArray(res);
    }
    public int[] toIntArray(List<Integer> list)  {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list)
            ret[i++] = e.intValue();
        return ret;
    }
}

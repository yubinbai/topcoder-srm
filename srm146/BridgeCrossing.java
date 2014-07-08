package topcoder;

import java.util.Arrays;

public class BridgeCrossing {
    public int minTime(int[] times) {
        Arrays.sort(times);
        return minT(times, 0, times.length - 1);
    }

    public int minT(int[] times, int left, int right) {
        int L = right - left + 1;
        if (L == 1)
            return times[left];
        if (L == 2)
            return Math.max(times[left], times[right]);
        if (L == 3)
            return times[right] + times[left] + times[left + 1];
        if (L >= 4) {
            int a = times[left], b = times[left + 1];
            int y = times[right - 1], z = times[right];
            int r1 = b + a + z + b;
            int r2 = z + a + y + a;
            if (r1 <= r2)
                return r1 + minT(times, left, right - 2);
            else
                return r2 + minT(times, left, right - 2);
        } else {
            return 0;
        }
    }
}

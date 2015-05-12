import java.util.Arrays;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Yubin Bai
 */
public class MysticAndCandiesEasy {
    public int minBoxes(int C, int X, int[] high) {
        Arrays.sort(high);
        long s = 0;
        for (int i = 0; i < high.length; i++) {
            if (C - s >= X) {
                s += high[i];
            } else {
                return high.length - i + 1;
            }
        }
        return 1;
    }
}

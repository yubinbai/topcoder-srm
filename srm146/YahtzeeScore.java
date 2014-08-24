package topcoder;

public class YahtzeeScore {
    public int maxPoints(int[] toss) {
        int[] a = new int[7];
        for (int e : toss) {
            a[e] += e;
        }
        int res = 0;
        for (int e : a) {
            res = Math.max(e, res);
        }
        return res;
    }
}

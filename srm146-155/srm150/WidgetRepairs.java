package topcoder;

public class WidgetRepairs {
    public int days(int[] arrivals, int numPerDay) {
        int left = 0;
        int res = 0;
        for (int a : arrivals){
            left += a;
            if (left > 0){
                res += 1;
                left -= Math.min(left, numPerDay);
            }
        }
        if (left > 0){
            res += (int)Math.ceil(1.0 * left / numPerDay);
        }
        return res;
    }
}


/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Yubin Bai
 */
public class BigBurger {
    public int maxWait(int[] arrival, int[] service) {
//        int N = arrival.length;
//        int[] waitT = new int[N];
//        int t = arrival[0];
//        for (int curr = 0; curr < N; curr++){
//            if (t <= arrival[curr]){
//                waitT[curr] = 0;
//                t = arrival[curr] + service[curr];
//            } else {
//                waitT[curr] = t - arrival[curr];
//                t += service[curr];
//            }
//        }
//
//        int res = 0;
//        for (int w : waitT) {
//            res = Math.max(res, w);
//        }
//        return res;
        int t = 0;
        int ret = 0;
        for (int i = 0; i < arrival.length; i++) {
            if (arrival[i] > t)
                t = arrival[i];
            ret = Math.max(ret, t - arrival[i]);
            t += service[i];
        }
        return ret;

    }
}


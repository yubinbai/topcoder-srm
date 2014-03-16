package topcoder;

import java.util.Arrays;

public class PackingBallsDiv2 {
    public int minPacks(int R, int G, int B) {
        int[] a = {R, G, B};
        Arrays.sort(a);
        B = a[0];
        G = a[1];
        R = a[2];

        if (B == 0)
            if (G == 0) {
                return (R - R % 3) / 3 + R % 3;
            } else {
                int res1 = G + minPacks(R - G, 0, 0);
                int res2 = minPacks(R, 0, 0) + minPacks(G, 0, 0);
                return Math.min(res1, res2);
            }


        int vFirst = Math.min(R, Math.min(G, B));
        int r = R - vFirst;
        int g = G - vFirst;
        int b = B - vFirst;
        int res1 = vFirst + minPacks(r, g, b);
        int nFirst;
        nFirst = (R - R % 3);
        int res2 = (nFirst != 0) ?  nFirst/ 3 + minPacks(R % 3, G, B) : 1000;
        nFirst = (G - G % 3);
        int res3 = (nFirst != 0) ? nFirst/ 3 + minPacks(R , G % 3, B) : 1000;
        nFirst = (B - B % 3);
        int res4 = (nFirst != 0) ? nFirst / 3 + minPacks(R , G, B % 3) : 1000;

        return Math.min(Math.min(res1, res2), Math.min(res3, res4));
    }
}


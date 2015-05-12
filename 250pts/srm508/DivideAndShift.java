package topcoder;

import java.util.HashSet;

public class DivideAndShift {
//    public int getLeast(int N, int M) {
//        if (M == 1)
//            return 0;
//        int ret = N + 1;
//        for (int p : getDivisors(N)) {
//            int d = N / p;
//            ret = Math.min(ret, M % d);
//            if (M + d - M % d <= N)
//                ret = Math.min(ret, d - M % d);
//        }
//        return ret;
//    }

    public HashSet<Integer> getDivisors(int N) {
        HashSet<Integer> ret = new HashSet<Integer>();
        for (int i = 2; i <= Math.sqrt(N); i++)
            while (N % i == 0) {
                ret.add(i);
                N /= i;
            }
        if (N != 1)
            ret.add(N);
        return ret;
    }

    public int getLeast(int N, int M) {
        int res = N;
        // Change the indexing system to 0-indexed
        M--;
        for (int y = 1; y <= N; y++) {
            if (N % y == 0) {
                int x = N / y;
                // Count prime factors of x: (Division distance)
                int c = 0;
                for (int p = 2; p <= x / p; p++) {
                    while (x % p == 0) {
                        c++;
                        x /= p;
                    }
                }
                c += ((x != 1) ? 1 : 0);

                //Calculate the shift distance after the divisions:
                int s = Math.min(M % y, y - M % y);

                //Remember the minimum.
                res = Math.min(res, s + c);
            }
        }

        return res;
    }
}

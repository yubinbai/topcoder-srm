package topcoder;

public class VocaloidsAndSongs {
    public int count(int S, int gumi, int ia, int mayu) {
        long[][][][] memo = new long[51][51][51][51];
//        if (S > gumi + ia + mayu) return 0;

        return go(memo, S, gumi, ia, mayu);
    }

    public int go(long[][][][] memo, int S, int G, int I, int M) {
        memo[0][0][0][0] = 1;
        for (int s = 1; s <= S; s++)
            for (int g = 0; g <= G; g++)
                for (int i = 0; i <= I; i++)
                    for (int m = 0; m <= M; m++) {
                        if (g - 1 >= 0)
                            memo[s][g][i][m] += memo[s - 1][g - 1][i][m];
                        if (i - 1 >= 0)
                            memo[s][g][i][m] += memo[s - 1][g][i - 1][m];
                        if (m - 1 >= 0)
                            memo[s][g][i][m] += memo[s - 1][g][i][m - 1];
                        if (g - 1 >= 0 && m - 1 >= 0)
                            memo[s][g][i][m] += memo[s - 1][g - 1][i][m - 1];
                        if (g - 1 >= 0 && i - 1 >= 0)
                            memo[s][g][i][m] += memo[s - 1][g - 1][i - 1][m];
                        if (i - 1 >= 0 && m - 1 >= 0)
                            memo[s][g][i][m] += memo[s - 1][g][i - 1][m - 1];
                        if (g - 1 >= 0 && i - 1 >= 0 && m - 1 >= 0)
                            memo[s][g][i][m] += memo[s - 1][g - 1][i - 1][m - 1];
                        memo[s][g][i][m] %= 1000000007;
                    }
        return (int)(memo[S][G][I][M] % 1000000007);
    }
//    public int go(int[][][][] memo, int s, int g, int i, int m) {
//        if (s == 0) {
//            if (g == 0 && i == 0 && m == 0) return 1;
//            else return 0;
//        }
//        if (memo[s][g][i][m] != 0)
//            return memo[s][g][i][m];
//        if (g - 1 >= 0)
//            memo[s][g][i][m] += go(memo, s - 1, g - 1, i, m);
//        if (i - 1 >= 0)
//            memo[s][g][i][m] += go(memo, s - 1, g, i - 1, m);
//        if (m - 1 >= 0)
//            memo[s][g][i][m] += go(memo, s - 1, g, i, m - 1);
//        if (g - 1 >= 0 && m - 1 >= 0)
//            memo[s][g][i][m] += go(memo, s - 1, g - 1, i, m - 1);
//        if (g - 1 >= 0 && i - 1 >= 0)
//            memo[s][g][i][m] += go(memo, s - 1, g - 1, i - 1, m);
//        if (i - 1 >= 0 && m - 1 >= 0)
//            memo[s][g][i][m] += go(memo, s - 1, g, i - 1, m - 1);
//        if (g - 1 >= 0 && i - 1 >= 0 && m - 1 >= 0)
//            memo[s][g][i][m] += go(memo, s - 1, g - 1, i - 1, m - 1);
//
//        return memo[s][g][i][m] % 1000000007;
//    }
}

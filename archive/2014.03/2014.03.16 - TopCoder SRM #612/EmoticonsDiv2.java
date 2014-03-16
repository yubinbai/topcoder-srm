package topcoder;

import java.util.Arrays;

public class EmoticonsDiv2 {
    int dp[][];
    int total;

    public int printSmiles(int smiles) {
        dp = new int[smiles + 1][smiles + 1];
        for (int[] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE);
        dp[1][0] = 0;
        total = smiles;
        int ans = r(smiles - 1 , 1);
        return 1 + ans;
    }

    private int r(int target, int clip) {
        if (target < clip) return Integer.MAX_VALUE - 30;
        if (target == 0) return 0;
        if (target == clip) return 1;
        if (target < 0) return Integer.MAX_VALUE - 30;
        if (dp[target][clip] != Integer.MAX_VALUE)
            return dp[target][clip];

        int ans = Integer.MAX_VALUE;
        if (target % clip == 0) ans = Math.min(ans, 1 + r(target - clip, clip));
        int iHave = total - target;
        ans = Math.min(ans, 2 + r(target - iHave, iHave));
        return dp[target][clip] = ans;
    }
}

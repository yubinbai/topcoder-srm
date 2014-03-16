package topcoder;

import java.util.Arrays;

public class GoldenChain {
    public int minCuts(int[] sections) {
        Arrays.sort(sections);
        int links = 0, i;
        for (i = 0; i < sections.length; i++) {
            if (sections.length - i - 1 >= sections[i] + links)
                links += sections[i];
            else
                links += Math.max(sections.length - links - i, 0);
        }
        return links;
    }
}

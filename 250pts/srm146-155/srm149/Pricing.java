package topcoder;

import java.util.Arrays;

public class Pricing {
    public int maxSales(int[] price) {
        Arrays.sort(price);
        int ret = 0;
        for (int i = 0; i < price.length; i++) {
            for (int j = i; j < price.length; j++) {
                for (int k = j; k < price.length; k++) {
                    for (int m = k; m < price.length; m++) {
                        int rev = 0;
                        for (int n = 0; n < price.length; n++) {
                            if (price[n] >= price[m]) {
                                rev += price[m];
                            } else if (price[n] >= price[k]) {
                                rev += price[k];
                            } else if (price[n] >= price[j]) {
                                rev += price[j];
                            } else if (price[n] >= price[i]) {
                                rev += price[i];
                            }
                        }
                        ret = Math.max(ret, rev);
                    }
                }
            }
        }
        return ret;

    }

}

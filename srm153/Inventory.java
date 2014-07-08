package topcoder;

import java.math.BigInteger;

public class Inventory {
    public int monthlyOrder(int[] sales, int[] daysAvailable) {
        BigInteger num = BigInteger.valueOf(0);
        BigInteger den = BigInteger.valueOf(1);
        int count = sales.length;

        for (int i = 0; i < sales.length; i++) {
            BigInteger a = BigInteger.valueOf(sales[i]);
            BigInteger b = BigInteger.valueOf(daysAvailable[i]);
            if (b.equals(BigInteger.ZERO)) {
                count--;
                continue;
            }
            num = num.multiply(b).add(a.multiply(den));
            den = den.multiply(b);
            BigInteger g = den.gcd(num);
            num = num.divide(g);
            den = den.divide(g);
        }
        num = num.multiply(BigInteger.valueOf(30));
        den = den.multiply(BigInteger.valueOf(count));
        if (num.mod(den) == BigInteger.ZERO) {
            return num.divide(den).intValue();
        } else {
            return num.divide(den).intValue() + 1;
        }
    }
}

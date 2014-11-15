package topcoder;

public class BenfordsLaw {
    public int questionableDigit(int[] transactions, int threshold) {
        double[] expected = new double[10];
        int N = transactions.length;
        for (int i = 1; i<10; i++)
            expected[i] = N * Math.log10(1 + 1.0 / i);

        int[] freq = new int[10];
        for (int a : transactions) {
            freq[Integer.toString(a).charAt(0) - '0']++;
        }

        for (int i = 1; i<10; i++) {
            if (freq[i] > threshold * expected[i] || freq[i] < expected[i] / threshold)
                return i;
        }
        return -1;
    }
}

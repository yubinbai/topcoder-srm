package topcoder;

public class FixedPointTheorem {
    public double cycleRange(double R) {
        double x = 0.25;
        for (int i = 0; i < 200000; i++)
            x = f(x, R);
        double ma = 0, mi = 1000;
        for (int i = 0; i < 1000; i++) {
            x = f(x, R);
            ma = Math.max(ma, x);
            mi = Math.min(mi, x);
        }

        return ma - mi;
    }

    public double f(double x, double R) {
        return R * x * (1 - x);

    }
}

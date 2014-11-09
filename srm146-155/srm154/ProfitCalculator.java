package topcoder;

public class ProfitCalculator {
    public int percent(String[] items) {
        double p = 0, c = 0;
        for (String s : items) {
            String[] sa = s.split(" ");
            p += Double.parseDouble(sa[0]);
            c += Double.parseDouble(sa[1]);
        }
        int ret = (int) Math.floor((p - c) * 100 / p);
        return ret;
    }
}

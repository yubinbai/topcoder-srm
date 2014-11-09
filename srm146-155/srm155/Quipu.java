package topcoder;

public class Quipu {
    public int readKnots(String knots) {
        String[] sa = (knots + "A").split("-");
        int res = 0;
        for (int i = 0;i< sa.length - 1;i++){
            res *= 10;
            res += sa[i].length();
        }
        return res;
    }
}

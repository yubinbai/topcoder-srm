package topcoder;

public class MagicalStringDiv2 {
    public int minimalMoves(String S) {
        int k = S.length() / 2;
        int ret = 0;
        for (int i = 0; i < k; i++)
            if (S.charAt(i) != '>')
                ret++;
        for (int i = k; i < S.length(); i++)
            if (S.charAt(i) != '<')
                ret++;

        return ret;
    }
}

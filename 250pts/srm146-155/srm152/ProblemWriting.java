package topcoder;
//from topcoder answer:

public class ProblemWriting {
    public String topcoderAnswer(String dotForm) {
        int S0 = 0, S1 = 1, S2 = 2, S3 = 3;
        String ops = "+*-/";
        if (dotForm.length() < 1 || dotForm.length() > 25)
            return "dotForm must contain between 1 and 25 characters, inclusive.";
        boolean good = true;
        int STATE = S0;
        for (int i = 0; i < dotForm.length(); i++) {
            char curr = dotForm.charAt(i);
            good = true;
            if (STATE == S0) {
                if (Character.isDigit(curr)) STATE = S1;
                else good = false;
            } else if (STATE == S1 || STATE == S2) {
                if (curr == '.') STATE = S2;
                else if (ops.indexOf(curr) != -1) STATE = S3;
                else good = false;
            } else if (STATE == S3) {
                if (curr == '.') STATE = S3;
                else if (Character.isDigit(curr)) STATE = S1;
                else good = false;
            }
            if (!good) return "dotForm is not in dot notation, check character " + i + ".";
        }
        if (STATE != S1) return "dotForm is not in dot notation, check character " + (dotForm.length()) + ".";
        return "";
    }

    public String myCheckData(String dotForm) {
        int N = dotForm.length();
        if (N < 1 || N > 25)
            return "dotForm must contain between 1 and 25 characters, inclusive.";
        char lastC = dotForm.charAt(N - 1);
        if (Character.isDigit(lastC)) {
            int res = isDot(dotForm, N - 1);
            if (res == -1)
                return "";
            else
                return String.format("dotForm is not in dot notation, check character %d.", res);
        } else {
            int lastN = N - 1;
            for (; lastN >= 0; lastN--) {
                char c = dotForm.charAt(lastN);
                if (c == '+' || c == '-' || c == '*' || c == '/')
                    break;
            }
            int res = isDot(dotForm, lastN - 1);
            if (res == -1)
                return String.format("dotForm is not in dot notation, check character %d.", dotForm.length());
            else
                return String.format("dotForm is not in dot notation, check character %d.", res);

        }

    }

    public int isDot(String str, int last) {
        while (str.charAt(last) == '.')
            last--;
        if (Character.isDigit(str.charAt(last))) {
            int lastN = last - 1;
            for (; lastN >= 0; lastN--) {
                char c = str.charAt(lastN);
                if (Character.isDigit(c))
                    return last;
                if (c == '+' || c == '-' || c == '*' || c == '/')
                    break;
            }
            if (lastN == -1)
                return -1;
            else
                return isDot(str, lastN - 1);

        } else {
            return last;
        }
    }
}

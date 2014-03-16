package topcoder;

public class FormatAmt {
    public String amount(int dollars, int cents) {
        if (dollars == 0)
            return String.format("$0.%02d", cents);
        else {
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (dollars / 1000 > 0) {
                    sb.insert(0, String.format("%03d", dollars % 1000));
                    sb.insert(0, ",");
                    dollars /= 1000;
                } else {
                    sb.insert(0, String.format("$%d", dollars % 1000));
                    sb.append(String.format(".%02d", cents)).toString();
                    return sb.toString();
                }
            }

        }
    }
}

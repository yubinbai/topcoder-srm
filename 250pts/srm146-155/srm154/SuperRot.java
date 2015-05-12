package topcoder;

public class SuperRot {
    public String decoder(String message) {
        String encode = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
        String decode = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm5678901234 ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++)
            for (int ii = 0; ii < encode.length(); ii++)
                if (message.charAt(i) == encode.charAt(ii)) {
                    sb.append(decode.charAt(ii));
                    break;
                }
        return sb.toString();
    }
}

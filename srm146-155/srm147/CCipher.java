package topcoder;

public class CCipher {
    public String decode(String cipherText, int shift) {
        StringBuilder sb = new StringBuilder();
        for(char c : cipherText.toCharArray()) {
            if (c - shift < 'A')
                sb.append(Character.toChars(c - shift + 26));
            else
                sb.append(Character.toChars(c - shift));
        }
        return sb.toString();
    }
}

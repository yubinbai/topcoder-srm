import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class HappyLetterDiv2 {
    public char getHappyLetter(String letters) {
        int[] freq = new int[30];
        for (char c : letters.toCharArray()) {
            freq[c - 'a']++;
        }
        int len = letters.length();
        for (int i = 0; i < 26; ++i) {
            if (freq[i] > len / 2) return (char) ('a' + i);
        }
        return '.';
    }

}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!

package topcoder;

import java.util.HashSet;

public class DivisorDigits {
    public int howMany(int number) {
        String d = Integer.toString(number);
        int[] used = new int[10];
        for (char c : d.toCharArray()) {
            used[c - '0']++;
        }
        int res = 0;
        for(int i = 1;i<10;i++){
            if (used[i] != 0 && number % i == 0){
                res += used[i];
            }
        }
        return res;
    }
}

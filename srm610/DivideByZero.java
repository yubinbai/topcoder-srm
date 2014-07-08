package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class DivideByZero {
    public int CountNumbers(int[] numbers) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        Arrays.sort(numbers);
        for (int i = numbers.length - 1;i>=0;i--){
            s.add(numbers[i]);
        }
        int ret = 0;
        int a = 0;
        while (!s.isEmpty()){
            int size = 0;
            do {
                size = s.size();
                int big = s.last();
                ArrayList<Integer> l = new ArrayList<Integer>();
                for (Integer i : s){
                    if (i != big){
                        l.add(i);
                    }
                }
                for (Integer i : l){
                    a = (big - big % i) / i;
                    if ( a != 0 && a < big) {
                        s.add(a);
                    }
                }
            } while (s.size() > size);
            s.pollLast();
            ret++;
        }

        return ret;

    }
}

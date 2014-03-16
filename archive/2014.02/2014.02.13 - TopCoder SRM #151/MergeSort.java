package topcoder;

import java.util.ArrayList;

public class MergeSort {
    public int howManyComparisons(int[] numbers) {
        Integer[] n = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            n[i] = numbers[i];
        MSort<Integer> m = new MSort<Integer>(n.length, n);
        return m.mergeSort();
    }
}


class MSort<Key extends Comparable<? super Key>> {

    Key[] data;
    int length;

    public MSort(int length, Key[] data) {
        super();
        this.length = length;
        this.data = data;
    }

    public int mergeSort() {
        return mergeSort(0, length - 1);
    }

    private int mergeSort(int start, int end) {
        if (start < end) {
            int n = end - start + 1;
            int mid = 0;
            if (n % 2 == 0) {
                mid = start + n / 2 - 1;
            } else {
                mid = start + (n - 1) / 2 - 1;
            }
//            int mid = (int) Math.floor((start + end) / 2);
            int a = mergeSort(start, mid);
            int b = mergeSort(mid + 1, end);
            int c = merge(start, mid, end);
            return a + b + c;
        } else
            return 0;
    }

    private int merge(int start, int mid, int end) {
        int res = 0;
        int sizeL = mid - start + 1;
        int sizeR = end - mid;
        ArrayList<Key> l = new ArrayList<Key>(), r = new ArrayList<Key>();
        for (int i = start; i <= mid; i++)
            l.add(data[i]);
        for (int i = mid + 1; i <= end; i++)
            r.add(data[i]);

        int i = 0, j = 0;
        int curr = start;
        for (; i < sizeL && j < sizeR && curr <= end; curr++) {
            int cmp = l.get(i).compareTo(r.get(j));
            if (cmp < 0) {
                data[curr] = l.get(i);
                i++;
            } else if (cmp > 0) {
                data[curr] = r.get(j);
                j++;
            } else{
                data[curr] = l.get(i);
                curr++;
                data[curr] = r.get(j);
                i++;
                j++;
            }
            res += 1;
        }
        while (i < sizeL && curr <= end) {
            data[curr] = l.get(i);
            i++;
            curr++;
        }
        while (j < sizeR && curr <= end) {
            data[curr] = r.get(j);
            j++;
            curr++;
        }
        return res;
    }

}

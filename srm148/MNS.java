package topcoder;

public class MNS {
    public int combos(int[] numbers) {
        int[] counters = count(numbers);
        return comb(numbers, counters, 0);
    }

    int comb(int[] numbers, int[] counters, int k) {
        if (k >= numbers.length) {
            return check(numbers) ? 1 : 0;
        }
        int counter = 0;
        for (int i = 0; i <= 9; i++) {
            if (counters[i] > 0) {
                counters[i]--;
                numbers[k] = i;
                counter += comb(numbers, counters, k + 1);
                counters[i]++;
            }
        }
        return counter;
    }

    int[] count(int[] numbers) {
        int[] counters = new int[10];
        for (int e : numbers) {
            counters[e]++;
        }
        return counters;
    }

    boolean check(int[] numbers) {
        int sum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < 3; i++) {
            if (numbers[3 * i] + numbers[3 * i + 1] + numbers[3 * i + 2] != sum ||
                    numbers[i] + numbers[3 + i] + numbers[6 + i] != sum) {
                return false;
            }
        }
        return true;
    }
}

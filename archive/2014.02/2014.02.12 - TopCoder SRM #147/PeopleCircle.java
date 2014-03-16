package topcoder;


public class PeopleCircle {
    public String order(int numMales, int numFemales, int K) {
        int N = numMales + numFemales;
        char[] res = new char[N];
        for (int i = 0; i < N; i++)
            res[i] = 'M';
        int curr = 0;
        boolean[] used = new boolean[N];
        for (int i = 0; i < numFemales; i++) {
            int currC = K;
            while (currC > 0) {
                if (!used[curr]) {
                    currC--;
                }
                curr++;
                if (curr == N) curr = 0;
            }
            curr--;
            if (curr == -1) curr = N - 1;
            used[curr] = true;
            res[curr] = 'F';
        }
        return String.valueOf(res);
    }
}

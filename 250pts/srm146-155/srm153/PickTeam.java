package topcoder;

import java.util.Arrays;

public class PickTeam {
    private String[] names;
    private int N;
    private int[][] rating;
    private int resMax;
    private String[] team;

    public String[] pickPeople(int teamSize, String[] people) {
        resMax = Integer.MIN_VALUE;
        N = people.length;
        names = new String[N];
        rating = new int[N][N];
        for (int i = 0; i<N; i++) {
            String[] s = people[i].split(" ");
            names[i] = s[0];
            for(int j =0; j<N; j++)
                rating[i][j] = Integer.parseInt(s[j+1]);
        }

        combination(new int[teamSize], 0, N-1, 0, teamSize);
        Arrays.sort(team);
        return team;
    }

    void combination(int v[], int start, int n, int k, int maxK) {

        if (k >= maxK) {
            int tMax = 0;
            String[] tTeam= new String[v.length];
            for (int j =0; j<v.length; j++) {
                for (int jj = j + 1; jj < v.length; jj++) {
                    tMax += rating[v[j]][v[jj]];
                }
                tTeam[j] = names[v[j]];
            }
            if (tMax > resMax) {
                resMax = tMax;
                team = tTeam;
            }
            return;
        }

        for (int i = start; i<=n; i++) {
            v[k] = i;
            combination(v, i + 1, n, k + 1, maxK);
        }
    }
}

package topcoder;

import java.util.Arrays;

public class ContestScore {
    private int N;
    private int M;
    private int[][] ranking;
    private int[][] score;
    private String[] name;

    class Rank implements Comparable<Rank> {
        public int s;
        public int id;

        public Rank(int s, int i) {
            this.s = s;
            this.id = i;
        }

        @Override
        public int compareTo(Rank o) {
            return Integer.valueOf(s).compareTo(Integer.valueOf(o.s)) * -1;
        }
    }

    class Team implements Comparable<Team> {
        public String name;
        public int rating;
        public int score;

        public Team(String name, int r, int s) {
            this.name = name;
            this.rating = r;
            this.score = s;
        }

        @Override
        public int compareTo(Team o) {
            int cmp = Integer.valueOf(this.rating).compareTo(o.rating);
            if (cmp == 0){
                int cmp1 =  Integer.valueOf(this.score).compareTo(o.score) * -1;
                if (cmp1 == 0)
                    return this.name.compareTo(o.name);
                else
                    return cmp1;
            }
            else
                return cmp;
        }

        @Override
        public String toString() {
            return String.format("%s %d %2.1f", this.name, this.rating, this.score / 10.0);
        }
    }

    public String[] sortResults(String[] data) {

        N = data.length;
        if (N == 0)
            return new String[0];
        M = data[0].split(" ").length - 1;
        ranking = new int[N][M];
        score = new int[N][M];
        name = new String[N];
        for (int i = 0; i < N; i++) {
            String[] s = data[i].split(" ");
            name[i] = s[0];
            for (int j = 0; j < M; j++)
                score[i][j] = (int)(Double.parseDouble(s[j + 1]) * 10);
        }

        for (int col = 0; col < M; col++) {
            Rank[] curr = new Rank[N];
            for (int row = 0; row < N; row++)
                curr[row] = new Rank(score[row][col], row);
            Arrays.sort(curr);
            int prevRank = 1;
            for (int i = 0; i < N; i++) {
                if (i == 0 || curr[i].s == curr[i - 1].s)
                    ranking[curr[i].id][col] = prevRank;
                else {
                    ranking[curr[i].id][col] = i + 1;
                    prevRank = i + 1;
                }
            }
        }

        Team[] ts = new Team[N];
        for (int i = 0; i < N; i++) {
            int r = 0;
            for (int ii = 0; ii < M; ii++)
                r += ranking[i][ii];
            int s = 0;
            for (int ii = 0; ii < M; ii++)
                s += score[i][ii];

            ts[i] = new Team(name[i], r, s);
        }
        Arrays.sort(ts);
        String[] ret = new String[N];
        for (int i = 0; i < N; i++)
            ret[i] = ts[i].toString();

        return ret;
    }
}

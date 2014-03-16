package topcoder;

public class MostProfitable {
    public String bestItem(int[] costs, int[] prices, int[] sales, String[] items) {
        int N = costs.length;
        int rev = 0;
        int res = -1;
        for (int i = 0;i<N;i++){
            int currRev = sales[i] * (prices[i] - costs[i]);
            if (currRev > rev){
                rev = sales[i] * (prices[i] - costs[i]);
                res = i;
            }
        }
        if (res == -1)
            return "";
        else
            return items[res];
    }
}

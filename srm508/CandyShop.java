package topcoder;

public class CandyShop {
    public int countProbablePlaces(int[] X, int[] Y, int[] R) {
        int c = 0;
        for (int sx = -200; sx<=200; sx++) {
            for (int sy = -200; sy<=200; sy++) {
                boolean good = true;
                // For each point, get the Manhattan distance, to each
                // (X[i],Y[i]) if the distances are always <= R[i]
                // the point can be a valid position for the store.
                //
                for (int i=0; i<X.length; i++) {
                    int manhattan = Math.abs(X[i]-sx) + Math.abs(Y[i]-sy) ;
                    good &= (manhattan <= R[i]);
                }
                if ( good ) {
                    c++;
                }
            }
        }
        return c;
    }
}

package topcoder;

import java.util.BitSet;

public class TheMatrix {
    public int MaxArea(String[] board) {
        int N = board.length;
        int M = board[0].length();
        int ret = 1;
        BitSet[] b = new BitSet[N];
        for (int i = 0; i < N; i++) {
            b[i] = new BitSet(M);
            for (int j = 0; j < M; j++) {
                b[i].set(j, (board[i].charAt(j) == '1'));
            }
        }

        for (int startRow = 0; startRow < N; startRow++)
            for (int startCol = 0; startCol < M; startCol++)
                for (int endCol = startCol + 1; endCol <= M; endCol++) {
                    boolean flag = true;
                    for (int i = startCol + 1; i < endCol; i++)
                        if (b[startRow].get(i - 1) == b[startRow].get(i))
                            flag = false;

                    if (flag) {
                        ret = Math.max(ret, endCol - startCol);
                        for (int endRow = startRow + 1; endRow < N; endRow++) {
                            BitSet s1 = b[endRow - 1].get(startCol, endCol);
                            BitSet s2 = b[endRow].get(startCol, endCol);
                            s1.flip(0, endCol - startCol);
                            if (!s1.equals(s2)) {
                                break;
                            } else {
                                ret = Math.max(ret, (endRow - startRow + 1) * (endCol - startCol));
                            }
                        }
                    }
                }
        return ret;
    }
}

package topcoder;

public class RectangularGrid {
    public long countRectangles(int width, int height) {
        long res = 0;
        for (int i = 1; i <= height; i++)
            for (int j = 1; j <= width; j++) {
                if (j == i)
                    continue;
                res += (height - i + 1) * (width - j + 1);

            }
        return res;
    }
}

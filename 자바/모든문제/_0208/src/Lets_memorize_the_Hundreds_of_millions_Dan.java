import java.util.Arrays;
import java.util.Comparator;

public class Lets_memorize_the_Hundreds_of_millions_Dan {
    public Point[] dp;

    public class Point {
        int n, c;

        public Point(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }

    public void calDp(int e) {
        dp = new Point[e];

        for (int i = 1; i <= e; i++) {
            dp[i - 1] = new Point(i, 1);
        }

        for (int i = 2; i <= e; i++) {
            for (int j = 1; j <= e / i; j++) {
                dp[i * j - 1].c++;
            }
        }

        Arrays.sort(dp, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.c < o2.c) return 1;
                else if (o1.c > o2.c) return -1;
                else {
                    if (o1.n > o2.n) return 1;
                    else if (o1.n < o2.n) return -1;
                    else return 0;
                }
            }
        });
    }

    public int[] solution(int e, int[] starts) {
        int[] res = new int[starts.length];
        calDp(e);

        for (int i = 0; i < starts.length; i++) {
            int s = starts[i];
            for (int j = 0; j < e; j++) {
                if (dp[j].n >= s) {
                    res[i] = dp[j].n;
                    break;
                }
            }
        }
        return res;
    }
}

/**
 * @description https://blog.csdn.net/qq_35078278/article/details/106991824
 *
 * @author DEAiFISH
 * @date 2025/2/9 13:47
 */
public class 抢数字 {
    private static int NUM = 8;
    private static int STEP = 2;
    public static void main(String[] args) {
        int n = (NUM -  1) % (STEP + 1);

        for (int i = NUM - 1; i >= n; i -= (STEP + 1)) {
            System.out.print(i + " ");
        }
    }
}
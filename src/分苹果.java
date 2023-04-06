import java.util.Scanner;

/**
 * 差分数组
 * https://www.dotcpp.com/oj/problem1501.html
 */
public class 分苹果 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int num[] = new int[n + 2];

        for (int i = 0; i < m; i++) {
            int li = in.nextInt();
            int ri = in.nextInt();
            int ci = in.nextInt();
            num[li] += ci;
            num[ri + 1] -= ci;
        }

        for (int i = 1; i <= n; i++) {
            num[i] += num[i - 1];
            System.out.print(num[i] + " ");
        }
    }
}

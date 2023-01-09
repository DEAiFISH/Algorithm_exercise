import java.util.Scanner;

/**
 * 题目：https://www.dotcpp.com/oj/problem1447.html
 * 解析：https://blog.dotcpp.com/a/81462
 */
public class 格子刷油漆 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mod = 1000000007;
        long[] a = new long[n + 1];
        long[] b = new long[n + 1];
        a[1] = 1;
        a[2] = 6;
        b[1] = 1;
        b[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            b[i] = b[i - 1] * 2;
            a[i] = a[i - 1] * 2 + b[i] + 4 * a[i - 2];
        }
        long ans = a[n] * 4 % mod;
        for (int i = 2; i < n; i++) {
            ans = (ans + b[i] * a[n - i] * 4) % mod;
            ans = (ans + b[n - i + 1] * a[i - 1] * 4) % mod;
        }
        System.out.println(ans % mod);
    }
}

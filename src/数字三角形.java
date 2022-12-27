import java.util.Scanner;

public class 数字三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }

        if (N % 2 == 0) {
            System.out.println(dp[N - 1][N / 2]);
        } else {
            System.out.println(Math.max(dp[N - 1][N / 2], dp[N - 1][N / 2 - 1]));
        }
    }
}
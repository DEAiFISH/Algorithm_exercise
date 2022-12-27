import java.util.Scanner;

/**
 * 区间DP
 */
public class 合并石子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //石子堆数
        int[] arr = new int[n + 1]; //记录每堆石子的质量
        int[] s = new int[n + 1];   //记录前缀和
        int[][] dp = new int[n + 1][n + 1]; //dp[l][r]表示从l到r合并成一堆的最小代价

        //预处理
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
            s[i] = s[i - 1] + arr[i];
            dp[i][i] = 0;
        }

        //状态计算
        for (int len = 2; len <= n; len++) {    //阶段：枚举区间长度
            for (int l = 1; l + len - 1 <= n; l++) { //状态：枚举区间起点
                int r = l + len - 1;    //区间终点
                for (int k = l; k < r; k++) {   //决策：决策分隔点
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }

        System.out.println(dp[1][n]);

    }
}

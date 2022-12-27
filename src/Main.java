import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //记录能量珠个数
        int arrays[] = new int[n];  //记录每个能量珠能量
        int dp[][] = new int[n][n]; //dp[l][r]表示合并l到r能量珠释放的能量

        //预处理
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = scanner.nextInt();
        }

        //l 是子问题的珠子数
        for (int l = 2; l <= n; l++) {  //阶段：枚举区间长度
            for (int i = 0; i < n; i++) {   //状态：枚举区间起点
                int j = (i + l - 1) % n;    //区间终点
                for (int k = i; k < i + l - 1; k++) {   //决策：决策分隔点
                    dp[i][j] = Math.max(dp[i][j], dp[i][k % n] + dp[(k + 1) % n][j] + arrays[i] * arrays[(k + 1) % n] * arrays[(j + 1) % n]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i][(i + n - 1) % n], max);
        }
        System.out.print(max);
    }
}
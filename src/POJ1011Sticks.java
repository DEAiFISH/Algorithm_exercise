import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description https://cloud.tencent.com/developer/article/2044553
 *
 * @author DEAiFISH
 * @date 2024/1/14 14:26
 */
public class POJ1011Sticks {
    static int n,   // 总段数
            m,  // 每段的长度
            num,    // 分成的段数
            sum;    // 总长
    static int[] arr;
    static boolean flag;
    static boolean[] visited;   // 是否被访问

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while ((n = scanner.nextInt()) != 0) {
            arr = new int[n];
            visited = new boolean[n];
            flag = false;
            sum = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                sum += arr[i];
            }

            Arrays.sort(arr);

            for (num = n; num >= 1; num--) { // 分段数，从大到小遍历搜索
                if (sum % num != 0 || arr[n - 1] > (m = sum / num)) {
                    continue;
                }
                dfs(n - 1, 0, 0);
                if (flag) {
                    break;
                }
            }

            System.out.println(m);
        }

    }

    /**
     * @description TODO
     *
     * @author DEAiFISH
     * @date 2024/1/13 16:11
     * @param index 从哪开始（逆序）
     * @param cur 已经拼接的长度
     * @param cnt 拼接完成的段数
     * @return void
     */
    private static void dfs(int index, int cur, int cnt) {
        if (flag || cnt == num) {    // 拼接完成
            flag = true;
            return;
        }

        for (int i = index; i >= 0; i--) {
            if (visited[i] || cur + arr[i] > m) {
                // 访问过的木棍加上当前木棍长度后超过了目标长度，则跳过本次循环
                continue;
            }
            if (i + 1 < n && !visited[i + 1] && arr[i] == arr[i + 1]) {
                // 若当前木棍和上一根木棍长度同样而且上一根木棍没用到，则跳过本次循环。
                continue;
            }
            if (cur + arr[i] < m) {
                visited[i] = true;
                dfs(i - 1, cur + arr[i], cnt);
                visited[i] = false;
                if (cur == 0) {   // arr[index]遍历完，返回上一层
                    return;
                }
            }
            if (cur + arr[i] == m) {    // 循环里后面的值都在dfs中求过了。这里直接返回上一层
                visited[i] = true;
                dfs(n - 1, 0, cnt + 1);
                visited[i] = false;
                return;
            }
        }
    }
}
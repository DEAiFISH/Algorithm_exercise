import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：https://www.dotcpp.com/oj/problem1445.html
 * 解析：https://www.cnblogs.com/GodA/p/5237061.html
 *
 * 将最大子矩阵 --> 最大子数组
 */
public class 最大子矩阵 {
    //将多行的数据加起来形成一行，就可以转换成最大子数组问题
    public static int maxSubMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] sumOfCol = new int[cols]; //存放每列之和
        int max = matrix[0][0];
        for (int beginRow = 0; beginRow < rows; beginRow++) {    //起始行
            for (int i = beginRow; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sumOfCol[j] += matrix[i][j];
                }
                //转换成求子数组最大和问题
                int t = maxSubArray(sumOfCol);
                if (t > max) {
                    max = t;
                }
            }
            Arrays.fill(sumOfCol, 0);  //进行下一轮之前先初始化sumOfCol
        }
        return max;
    }


    /**
     * 最大子数组
     *
     * @param arr 列数组
     * @return 最大子数组和
     */
    public static int maxSubArray(int[] arr) {
        if (arr.length == 0) return 0;

        int sum = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //大于等于0就可以带上，否则就丢弃，然后从新开始
            if (sum > 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int ans = maxSubMatrix(matrix);
        System.out.println(ans);
    }
}
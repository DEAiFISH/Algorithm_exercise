import java.util.Scanner;

public class 回形取数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] arr = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int n = (int) Math.ceil(1.0 * Math.min(x, y) / 2);
        for (int i = 0; i < n; i++) {
            print(arr, i);
        }


    }

    private static void print(int[][] arr, int n) {
        for (int i = n; i < arr.length - n; i++) {  //左
            System.out.print(arr[i][n] + " ");
        }
        for (int i = n + 1; i < arr[0].length - n; i++) {  //下
            System.out.print(arr[arr.length - n - 1][i] + " ");
        }
        for (int i = arr.length - n - 2; i >= n && n != arr[0].length - n - 1; i--) {  //右
            System.out.print(arr[i][arr[0].length - n - 1] + " ");
        }
        for (int i = arr[0].length - n - 2; i > n && n != arr.length - n - 1; i--) {  //上
            System.out.print(arr[n][i] + " ");
        }
    }
}
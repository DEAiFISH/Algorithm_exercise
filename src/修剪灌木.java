import java.util.Scanner;

public class 修剪灌木 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.max(i, n - i - 1) * 2;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }
}

import java.util.Scanner;

public class 买不到的数目 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int[] arr = new int[100];

        arr[a] = 1;
        arr[b] = 1;

        int res = 0;
        for (int i = 0; i < a * b; i++) {
            if (arr[i] == 1) {
                arr[i + a] = 1;
                arr[i + b] = 1;
            }
            if (arr[i] == 0) {
                res = i;
            }
        }

        System.out.println(res);
        System.out.println(a * b - a - b);
    }
}

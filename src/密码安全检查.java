import java.util.Scanner;

public class 密码安全检查 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        while (N != 0) {
            String password = scanner.nextLine();
            int res = 0;
            if (password.length() >= 8 && password.length() < 16) {
                if (password.matches(".*\\d.*")) {
                    res++;
                }
                if (password.matches(".*[a-z].*")) {
                    res++;
                }
                if (password.matches(".*[A-Z].*")) {
                    res++;
                }
                if (password.matches(".*[~!@#$%^].*")) {
                    res++;
                }
                if (res >= 3) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                N--;
            }
        }
    }
}
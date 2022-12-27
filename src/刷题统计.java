import java.util.Scanner;

public class 刷题统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();//周一到周五每天刷题数
        int b = scanner.nextInt();//周六周日每天刷题数
        int n = scanner.nextInt();//总题目

        int x = n / (7 * a + 2 * b);//共多少种完整周
        int y = n % (7 * a + 2 * b);//最后一周多少题

        int day = 1;
        while (y > 0) {
            if (day <= 5) {
                y -= a;
            } else {
                y -= b;
            }
            day++;
        }

        System.out.println(x * 7 + day - 1);
    }
}

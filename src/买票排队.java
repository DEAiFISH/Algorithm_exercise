import java.util.Scanner;

/**
 * 有M个小孩到公园玩，门票是1元。其中N个小孩带的钱为1元，K个小孩带的钱为2元。
 * 售票员没有零钱，问这些小孩共有多少种排队方法，使得售票员总能找得开零钱。
 * 注意：两个拿一元零钱的小孩，他们的位置互换，也算是一种新的排法。（M<=10）
 */
public class 买票排队 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(f(a, b) * jicheng(a) * jicheng(b));//所有可行情况
    }

    public static int f(int a, int b) {//深搜
        if (b > a) return 0;
        if (b == 0) return 1;
        return f(a - 1, b) + f(a, b - 1);
    }

    public static int jicheng(int x) {//内部排列
        int sum = 1;
        for (int i = 1; i <= x; i++) {
            sum *= i;
        }
        return sum;
    }
}
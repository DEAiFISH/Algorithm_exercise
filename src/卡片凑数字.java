import java.util.HashMap;

public class 卡片凑数字 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, 2021);
        }


        for (int i = 1; ; i++) {

            int t = i;
            while (t > 0) {
                int m = t % 10;
                int n;

                if ((n = map.get(m)) > 0) {
                    map.put(m, --n);
                } else {
                    System.out.println("结束");
                    System.out.println("i = " + (i - 1));
                    return;
                }
                t /= 10;
            }
        }
    }
}



public class 顺子日期 {
    public void test() {
        int date = 20200101;
        int count = 0;

        while (date <= 20201231) {
            String strDate = Integer.toString(date);
            if (strDate.indexOf("123") != -1) {
                count++;
            }

            date++;
        }

        System.out.println(count);

    }
}

import java.util.Arrays;

/**
 * @description TODO
 *
 * @author DEAiFISH
 * @date 2024/7/14 14:46
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]  = (int)(Math.random() * 100);
        }

        System.out.println(Arrays.toString(new 冒泡排序().sort(arr)));
    }

    private int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }

            if(flag) {
                break;
            }
        }
        return arr;
    }
}

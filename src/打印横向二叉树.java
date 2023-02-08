import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 打印横向二叉树 {

    /**
     * 向二叉树中插入数据
     * @param tree 数组（模拟二叉树）
     * @param n 需要插入的数字
     * @param i 下标
     */
    public static void Insert(int[] tree, int n, int i) {
        if (tree[i] == 0) { //如果没有变动过
            tree[i] = n;
            return;
        }
        if (n > tree[i]) {
            Insert(tree, n, 2 * i + 1);
        } else {
            Insert(tree, n, 2 * i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = 500;
        while (in.hasNext()) {
            String str = in.nextLine();
            ArrayList<Integer> list = new ArrayList<>();
            int[] tree = new int[N];
            for (String num :str.split(" ")) {
                int t = Integer.parseInt(num);
                list.add(t);
                Insert(tree, t, 1);
            }
            Collections.sort(list);
            tree[0] = tree[1];
            String[] ans = new String[list.size() + 1];
            ArrayList<Integer> queue = new ArrayList<>();
            queue.add(1);
            while (queue.size() != 0) {
                int value = queue.get(0), index = list.indexOf(tree[value]) + 1;
                if (value == 1) ans[index] = tree[value] + "";
                else {
                    String t = ans[list.indexOf(tree[value / 2]) + 1];
                    t = t.replaceAll("\\d|-", ".").substring(0, t.length() - 1);
                    if (tree[value] < tree[value / 2] && tree[value / 2] <= tree[value / 4] ||
                            tree[value] > tree[value / 2] && tree[value / 2] > tree[value / 4]) {
                        StringBuilder sb = new StringBuilder(t);
                        for (int k = t.length() - 1; k >= 0; k--) {
                            if (sb.charAt(k) == '|') {
                                sb.setCharAt(k, '.');
                                break;
                            }
                        }
                        t = sb.toString();
                    }
                    ans[index] = t + "|-" + tree[value];
                }
                int flag = 0;
                if (tree[2 * value] != 0) {
                    flag = 1;
                    queue.add(2 * value);
                }
                if (tree[2 * value + 1] != 0) {
                    flag = 1;
                    queue.add(2 * value + 1);
                }
                if (flag == 1) {
                    ans[index] += "-|";
                }
                queue.remove(0);
            }
            for (int i = list.size(); i >= 1; i--)
                System.out.println(ans[i]);
        }
        in.close();
    }
}

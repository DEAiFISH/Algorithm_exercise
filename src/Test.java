import java.util.HashSet;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int count = 1000000, sum = 0;

        for (int i = 0; i < count; i++) {
            sum += flipCards();
        }

        System.out.println("平均总数：" + sum / count);
    }

    private static int flipCards() {
        int count = 0, cards = 0;
        Random random = new Random();
        while (cards != 511) {
            int flipCount = random.nextInt(3) + 1;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < flipCount; i++) {
                int index;
                while (set.contains(index = random.nextInt(9))) {
                }
                set.add(index);
                cards ^= (1 << index);
            }
            count++;
        }

        return count;
    }
}

class Solution {
    public int swapPairs(int i) {
        return i + 2;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

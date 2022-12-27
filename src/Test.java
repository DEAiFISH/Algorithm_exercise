import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.getMaximumGenerated(3));
    }


    /**
     * 最小公约数
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}

class Solution {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            if(i % 2 == 0){
                arr[i] = arr[i / 2];
            }else{
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
        }
        Arrays.sort(arr);
        return arr[n - 1];
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
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

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val + " ";
    }
}
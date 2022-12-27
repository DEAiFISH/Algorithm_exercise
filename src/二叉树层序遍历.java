public class 二叉树层序遍历 {
    /*public int maxDepth(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        LinkedList<Integer> links = new LinkedList<>();

        if (root != null) {
            deque.offer(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                links.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }

            lists.add(new ArrayList<>(links));
            links.clear();
        }

        return lists.size();
    }*/

}

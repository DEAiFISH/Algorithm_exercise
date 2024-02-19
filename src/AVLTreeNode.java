/**
 * @description AVL树
 *  平衡因子：节点的「平衡因子 Balance Factor」定义为节点左子树的高度减去右子树的高度，同时规定空节点的平衡因 子为 0 。
 *
 * @author DEAiFISH
 * @date 2024/1/28 16:47
 */
public class AVLTreeNode {
    private int val;
    private int height; //借点高度
    private AVLTreeNode left;
    private AVLTreeNode right;

    public AVLTreeNode(int val) {
        this.val = val;
    }

    /**
     * @description 获取节点高度
     *
     * @author DEAiFISH
     * @date 2024/1/28 16:51
     * @param node
     * @return int
     */
    private int height(AVLTreeNode node) {
        return node == null ? -1 : node.getHeight();
    }

    /**
     * @description 更新节点高度
     *
     * @author DEAiFISH
     * @date 2024/1/28 16:52
     * @param node
     * @return void
     */
    private void updateHeight(AVLTreeNode node) {
        node.setHeight(Math.max(height(node.left), height(node.right)) + 1);
    }

    /**
     * @description 获取平衡因子
     *
     * @author DEAiFISH
     * @date 2024/1/28 16:54
     * @param node
     * @return int
     */
    private int balanceFactor(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    /**
     * @description 右旋
     *
     * @author DEAiFISH
     * @date 2024/1/28 16:59
     * @param node
     * @return AVLTreeNode
     */
    private AVLTreeNode rightRotate(AVLTreeNode node) {
        AVLTreeNode child = node.left;
        AVLTreeNode grandChild = child.right;
        // 已 child 为原点，将 node 向右旋转
        child.right = node;
        node.left = grandChild;
        // 更新节点高度
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    /**
     * @description 左旋
     *
     * @author DEAiFISH
     * @date 2024/1/28 17:00
     * @param node
     * @return AVLTreeNode
     */
    private AVLTreeNode leftRotate(AVLTreeNode node) {
        AVLTreeNode child = node.right;
        AVLTreeNode grandChild = child.left;
        // 已 child 为原点，将 node 向左旋转
        child.left = node;
        node.right = grandChild;
        // 更新节点高度
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    /**
     * @description 执行旋转操作，使该子树重新恢复平衡
     *
     * @author DEAiFISH
     * @date 2024/1/28 17:07
     * @param node
     * @return AVLTreeNode
     */
    private AVLTreeNode rotate(AVLTreeNode node) {
        int balanceFactor = balanceFactor(node);
        // 左偏树
        if (balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                // 右旋
                return rightRotate(node);
            } else {
                // 先左旋再右旋
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        // 右偏树
        if (balanceFactor < 1) {
            if (balanceFactor(node.right) <= 0) {
                // 左旋
                return leftRotate(node);
            } else {
                // 先右旋再左旋
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        // 平衡树，无需旋转
        return node;
    }

    /**
     * @description 插入节点
     *
     * @author DEAiFISH
     * @date 2024/1/28 17:10
     * @param val
     * @return void
     */
    public void insert(AVLTreeNode root,int val) {
        insertHelper(root, val);
    }

    /* 递归插入节点(辅助方法) */
    AVLTreeNode insertHelper(AVLTreeNode node, int val) {
        if (node == null)
            return new AVLTreeNode(val);
        /* 1. 查找插入位置，并插入节点 */
        if (val < node.val)
            node.left = insertHelper(node.left, val);
        else if (val > node.val)
            node.right = insertHelper(node.right, val);
        else
            return node; // 重复节点不插入，直接返回 updateHeight(node); // 更新节点高度
        /* 2. 执行旋转操作，使该子树重新恢复平衡 */
        node = rotate(node);
        // 返回子树的根节点
        return node;
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }
}

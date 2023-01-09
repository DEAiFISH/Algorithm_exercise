import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode treeNode = new TreeNode(scanner.nextInt());
        TreeNode temp = treeNode;
        while(scanner.hasNext()){
            int x = scanner.nextInt();
            if(x < temp.val){
                temp.left  = new TreeNode(x);
                temp = temp.left;
            }else{
                temp.right = new TreeNode(x);
                temp = temp.right;
            }
        }


    }

}
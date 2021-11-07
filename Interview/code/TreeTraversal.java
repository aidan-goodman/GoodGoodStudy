package beiye;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Aidan on 2021/10/26 14:02
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class TreeTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        layerTraversal(root);
    }

    public static void layerTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 使用队列存放结点
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode currentNode;
        while (!list.isEmpty()) {
            currentNode = list.poll();
            // 输出当前结点的值
            System.out.println(currentNode.val);
            // 将下一层放到对尾
            if (currentNode.left != null) {
                list.add(currentNode.left);
            }
            if (currentNode.right != null) {
                list.add(currentNode.right);
            }
        }
    }
}

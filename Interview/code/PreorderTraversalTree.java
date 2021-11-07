package quickhand;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aidan on 2021/10/8 16:43
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class PreorderTraversalTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    void recursion() {
        System.out.println(preorderTraversalRecursion(root));
    }

    @Test
    void iteration() {
        System.out.println(preorderTraversalIteration(root));
    }

    // 初始化
    TreeNode leftLeaf = new TreeNode(5, null, null);
    TreeNode rightLeaf = new TreeNode(4, null, null);
    TreeNode root = new TreeNode(1, leftLeaf, rightLeaf);

    // 迭代实现
    public List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }


    // 递归实现
    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}

package middle.aboutTree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class uniqueBinarySearchTreeII_95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }

        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private  TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
    public void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+" ");
        travel(root.left);
        travel(root.right);
    }
    public static void main(String[] args) {
        uniqueBinarySearchTreeII_95 binarySearchTreeII_95 = new uniqueBinarySearchTreeII_95();
        List<TreeNode> res = binarySearchTreeII_95.generateTrees(3);
        for (TreeNode node:res) {
            binarySearchTreeII_95.travel(node);
            System.out.println();
        }
    }
}

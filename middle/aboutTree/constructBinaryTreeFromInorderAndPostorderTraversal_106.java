package middle.aboutTree;

import common.TreeNode;

/**
* @Description: 给定一颗二叉树的中序遍历+（先序或者后序遍历）
* @Author: chenpeng
* @Date: 13:56 2018/11/20
* @param:
* @return:
*/
public class constructBinaryTreeFromInorderAndPostorderTraversal_106 {
    /***
     * 已知后序和中序遍历，还原二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode res  = constructTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
        return res;
    }
    public TreeNode constructTree(int[] postOrder,int postStart,int postEnd,int[] inOrder,int inStart,int inEnd ) {
        TreeNode node = new TreeNode(postOrder[postEnd]);
        node.left = null;
        node.right = null;
        if (postStart == postEnd && inStart == inEnd) {
            return node;
        }
        int i = 0;
        for (;i<inEnd;i++) {
            if (postOrder[postEnd] == inOrder[i]) {
                break;
            }
        }
        int leftLength = i-inStart;
        int rightLength = inEnd - i;

        if (leftLength > 0) {
            node.left = constructTree(postOrder, postStart, postStart+leftLength-1, inOrder,inStart,i-1);
        }
        if (rightLength > 0) {
            node.right = constructTree(postOrder, postStart+leftLength, postEnd-1, inOrder,i+1, inEnd);
        }
        return node;

    }

    /***
     * 已知中序遍历和先序遍历还原二叉树
     * @param inOrder
     * @param preOrder
     * @return
     */
    public TreeNode buildTree1(int[] inOrder ,int[] preOrder) {
        if (inOrder == null || preOrder == null) {
            return null;
        }
        TreeNode res  = constructTree1(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
        return res;
    }

    public TreeNode constructTree1(int[] preorder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd ) {
        TreeNode node = new TreeNode(preorder[preStart]);
        node.left = null;
        node.right = null;
        if (preStart == preEnd && inStart == inEnd) {
            return node;
        }
        int i = 0;
        for (;i<inEnd;i++) {
            if (preorder[preStart] == inOrder[i]) {
                break;
            }
        }
        int leftLength = i-inStart;
        int rightLength = inEnd - i;
        if (leftLength > 0) {
            node.left =constructTree1(preorder, preStart+1, preStart+leftLength, inOrder,inStart,i-1);
        }
        if (rightLength > 0) {
            node.right = constructTree1(preorder, preStart+leftLength+1, preEnd, inOrder,i+1, inEnd);
        }
        return node;
    }
    public void travelPre(TreeNode root) {
        if (root == null) {
            return;
        }
        travelPre(root.left);
        travelPre(root.right);
        System.out.print(root.val+",");
    }





    public static void main(String[] args) {
        int[] pre ={1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        int[] post = {7,4,2,5,8,6,3,1};
        constructBinaryTreeFromInorderAndPostorderTraversal_106 postorderTraversal_106 = new constructBinaryTreeFromInorderAndPostorderTraversal_106();
        TreeNode res = postorderTraversal_106.buildTree(in,post);
        postorderTraversal_106.travelPre(res);
    }
}

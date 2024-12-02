/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int ans;
    static int h;
    static int l;
    static void helper(TreeNode root){
        if(root==null) return;
        if(root.val>=l && root.val<=h) ans+=root.val;
        helper(root.left);
        helper(root.right);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        h = high;
        l = low;
        helper(root);
        return ans;
    }
}
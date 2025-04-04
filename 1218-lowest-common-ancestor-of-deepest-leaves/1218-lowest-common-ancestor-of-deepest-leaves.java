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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }
    private Pair<TreeNode,Integer> dfs(TreeNode root){
        if(root==null){
            return new Pair<>(null,0);
        }
        Pair<TreeNode,Integer> l=dfs(root.left);
        Pair<TreeNode,Integer> r=dfs(root.right);
        if(l.getValue()>r.getValue()){
            return new Pair<>(l.getKey(),l.getValue()+1);
        }
        if(r.getValue()>l.getValue()){
            return new Pair<>(r.getKey(),r.getValue()+1);
        }
        return new Pair<>(root,l.getValue()+1);
    }
}
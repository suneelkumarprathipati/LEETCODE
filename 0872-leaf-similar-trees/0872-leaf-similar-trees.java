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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        helper( arr1 , root1 );
        helper( arr2 , root2 );
        if ( arr1.equals(arr2)) return true;
        else return false;
    }
    static void helper( List<Integer> arr , TreeNode root ){
        if ( root == null ) return ;
        else if ( root.left == null && root.right == null ) {
            arr.add(root.val);
            return;
        }
        else {
            helper ( arr , root.left);
            helper ( arr , root.right);
        }
    }
}
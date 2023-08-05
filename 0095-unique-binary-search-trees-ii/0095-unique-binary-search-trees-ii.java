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
    public List<TreeNode> generateTrees(int n) {

        return upvote(1,n);
    }

    private List<TreeNode> upvote(int s, int e){
        List<TreeNode> ans = new ArrayList<>();

        if(s>e){
            ans.add(null);
            return ans;
        }

        for(int i = s;i <= e;i++){
            List<TreeNode> left = upvote(s, i-1);
            List<TreeNode> right = upvote(i+1, e);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode res = new TreeNode(i,l,r);
                    ans.add(res);
                }
            }
        }

        return ans;
    }
}
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
    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 0 || n % 2 == 0) {
            return new ArrayList<>();
        }

        Map<Integer, List<TreeNode>> memo = new HashMap<>();
        return generateFBT(n, memo);
    }

    private List<TreeNode> generateFBT(int n, Map<Integer, List<TreeNode>> memo) {
        if (n == 1) {
            List<TreeNode> singleNodeTree = new ArrayList<>();
            singleNodeTree.add(new TreeNode(0));
            return singleNodeTree;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> result = new ArrayList<>();
        for (int i = 1; i <= n - 1; i += 2) {
            List<TreeNode> leftSubtrees = generateFBT(i, memo);
            List<TreeNode> rightSubtrees = generateFBT(n - i - 1, memo);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        memo.put(n, result);
        return result;
    }
}

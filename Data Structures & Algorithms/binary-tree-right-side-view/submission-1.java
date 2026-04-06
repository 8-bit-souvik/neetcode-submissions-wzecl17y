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
    List<Integer> ans = new ArrayList<>();
    Integer max_depth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){return ans;}
        traverse(root, 1);

        return ans;
    }

    public void traverse(TreeNode node, Integer curr_depth){
        if(curr_depth > max_depth){
            ans.add(node.val);
            max_depth = curr_depth;
        }
        if(node.right != null){
            traverse(node.right, curr_depth+1);
        }
        if(node.left != null){
            traverse(node.left, curr_depth+1);
        }
    }
}

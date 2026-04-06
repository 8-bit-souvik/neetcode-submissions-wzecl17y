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
    int good_nodes = 0;
    public int goodNodes(TreeNode root) {
        if(root == null){return 0;}

        ArrayList<Integer> path = new ArrayList<>();
        traverse(root, path);
        // printInBFS(root);

        return good_nodes;
    }

    void traverse(TreeNode node, ArrayList<Integer> path){
        path.add(node.val);
        if(checkGood(path)){
            good_nodes++;
        }

        if(node.left != null){
            traverse(node.left, path);
        }
        if(node.right != null){
            traverse(node.right, path);
        }
        path.remove(path.size()-1);
    }

    Boolean checkGood(ArrayList<Integer> arr){
        // System.out.println(arr);
        int x = arr.get(arr.size()-1);
        for(Integer c:arr){
            if(x<c){return false;}
        }
        return true;
    }





    // public static void printInBFS(TreeNode node){
    //     if(node == null){return;}

    //     Pair<TreeNode, Integer> p = new Pair<TreeNode, Integer>(node, 1);
    //     Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
    //     q.offer(p);
    //     int lev =1;
    //     while(!q.isEmpty()){
    //         Pair<TreeNode, Integer> tempNode = q.poll();
    //         int depth = tempNode.getValue();
    //         if(tempNode.getValue()!=lev){
    //             System.out.println("");
    //             lev = tempNode.getValue();
    //         }
    //         System.out.print(tempNode.getKey().val+" ");
    //         if(tempNode.getKey().left != null){
    //             q.offer(new Pair<TreeNode, Integer>(tempNode.getKey().left, depth+1));
    //         }
    //         if(tempNode.getKey().right != null){
    //             q.offer(new Pair<TreeNode, Integer>(tempNode.getKey().right, depth+1));
    //         }
    //     }
    // }
}


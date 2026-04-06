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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        if(root == null){return arr;};
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        Pair<TreeNode, Integer> p = new Pair<>(root, 0);
        q.offer(p);
        

        while(!q.isEmpty()){
            Pair<TreeNode, Integer> temp = q.poll();

            if(temp.getKey().left != null){
                q.offer(new Pair<TreeNode, Integer>(temp.getKey().left, temp.getValue()+1));
            } 
            if(temp.getKey().right != null){
                q.offer(new Pair<TreeNode, Integer>(temp.getKey().right, temp.getValue()+1));
            }

            


            if(arr.size() > temp.getValue()){
                arr.get(temp.getValue()).add(temp.getKey().val);
            }else{
                arr.add(new ArrayList<Integer>());
                System.out.println(temp.getKey().val+"-"+arr.size());
                arr.get(temp.getValue()).add(temp.getKey().val);
            }
        }

        return arr;
    }
}

class Pair<k, v>{
    private k key;
    private v value;

    public Pair(k key, v value){
        this.key = key;
        this.value = value;
    }

    public k getKey(){
        return key;
    }

    public v getValue(){
        return value;
    }
}
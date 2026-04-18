class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int x : hand){
            q.offer(x);
        }

        while(!q.isEmpty()){
            int flag = 0;
            for(List<Integer> i : ans){
                if(i.size() < groupSize && i.get(i.size()-1)+1 == q.peek()){
                    i.add(q.poll());
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                ans.add(new ArrayList<>());
                ans.get(ans.size()-1).add(q.poll());
            }
        }

        // System.out.println(ans);

        for(List<Integer> i : ans){
            if(i.size() != groupSize){
                return false;
            }
        }

        return true;
    }
}
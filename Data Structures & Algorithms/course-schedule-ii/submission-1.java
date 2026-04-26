class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> pointer = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        for(int[] pre : prerequisites){
            if(!indegree.containsKey(pre[0])){
                indegree.put(pre[0], 1);
            }else{
                indegree.put(pre[0], indegree.get(pre[0])+1);
            }

            if(!pointer.containsKey(pre[1])){
                pointer.put(pre[1], new ArrayList<>());
                pointer.get(pre[1]).add(pre[0]);
            }else{
                pointer.get(pre[1]).add(pre[0]);
            }
        }

        for(int[] pre : prerequisites){
            if(!indegree.containsKey(pre[1])){
                set.add(pre[1]);
            }
        }

        for(int x : set){
            q.offer(x);
        }


        List<Integer> prior = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            prior.add(node);
            if(!pointer.containsKey(node)){
                continue;
            }

            for(int nei : pointer.get(node)){
                indegree.put(nei, indegree.get(nei)-1);
                if(indegree.get(nei) == 0){
                    indegree.remove(nei);
                    q.offer(nei);
                }
            }
        }

        if(!indegree.isEmpty()){
            return new int[0];
        }

        List<Integer> tempAns = new ArrayList<>();
        for(int x : prior){
            tempAns.add(x);
        }
        for(int i=0; i<numCourses; i++){
            if(!prior.contains(i)){
                tempAns.add(i);
            }
        }


        int[] ans = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            ans[i] = tempAns.get(i);
        }
        return ans;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> pointer = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for(int[] pre : prerequisites){
            if(indegree.containsKey(pre[0])){
                indegree.put(pre[0], indegree.get(pre[0])+1);
            }else{
                indegree.put(pre[0], 0);
                indegree.put(pre[0], indegree.get(pre[0])+1);
            }
            
            if(pointer.containsKey(pre[1])){
                pointer.get(pre[1]).add(pre[0]);
            }else{
                pointer.put(pre[1], new ArrayList<>());
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


        System.out.println(pointer);
        System.out.println(indegree);
        System.out.println(q);

        while(!q.isEmpty()){
            Integer opt = q.peek();
            if(!pointer.containsKey(opt)){
                q.poll();
                continue;
            }
            List<Integer> nodeList = pointer.get(opt);
            // System.out.println(opt+": "+nodeList);
            for(Integer node : nodeList){
                // if(!indegree.containsKey(node)){
                //     continue;
                // }
                indegree.put(node, indegree.get(node)-1);
                // System.out.println(node+" "+indegree.get(node));
                if(indegree.get(node) == 0){
                    q.offer(node);
                    indegree.remove(node);
                }
            }
            // System.out.println("----");
            q.poll();
        }

        System.out.println(pointer);
        System.out.println(indegree);



        if(!indegree.isEmpty()){
            return false;
        }else{
            return true;
        }

        // System.out.println(indegree);
        // int size = indegree.size();
        // Set<Integer> keys = indegree.keySet(); 
        // for(Integer key: keys){
        //     if(indegree.get(key)==0){
        //         size--;
        //     }
        // }

        // if(size > 0){
        //     return false;
        // }else{
        //     return true
        //     ;
        // }
    }
}

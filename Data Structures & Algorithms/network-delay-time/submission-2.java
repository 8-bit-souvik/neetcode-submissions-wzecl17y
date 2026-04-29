class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visited = new HashSet<>();

        for(int i=1; i<=n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] time: times){
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }

        for(int[] edge : map.get(k)){
            pq.offer(new int[]{edge[0], edge[1]});
            visited.add(k);
        }

        
        int curNode, curWt, t;
        while(!pq.isEmpty()){
            curNode = pq.peek()[0];
            curWt = pq.poll()[1];
            if(visited.contains(curNode)){
                continue;
            }

            visited.add(curNode);
            if(visited.size() == n){
                return curWt;
            }

            if(map.containsKey(curNode)){
                for(int[] edge : map.get(curNode)){
                    // if(visited.contains(edge[0])){
                    //     continue;
                    // }
                    pq.offer(new int[]{edge[0], edge[1]+curWt});
                }
            }
        }

        return -1;
    }
}

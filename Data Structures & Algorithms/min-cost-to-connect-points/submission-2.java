class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        for(int i=0; i<points.length; i++){
            for(int j=0; j<points.length; j++){
                if(!map.containsKey(i)){map.put(i, new ArrayList<>());}
                if(!map.containsKey(j)){map.put(j, new ArrayList<>());}
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                map.get(i).add(new Integer[]{j, dist});
                map.get(j).add(new Integer[]{i, dist});
            }
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        visited.add(0);
        for(Integer[] edge : map.get(0)){
            pq.offer(new Integer[]{edge[1], 0, edge[0]});
        }

        int sum = 0;

        while(!pq.isEmpty()){
            if(visited.size() == points.length){
                return sum;
            }

            if(visited.contains(pq.peek()[2])){
                pq.poll();
                continue;
            }

            Integer[] adj = pq.poll();
            visited.add(adj[2]);
            sum += adj[0];
            for(Integer[] edge : map.get(adj[2])){
                if(visited.contains(edge[0])){
                    continue;
                }
                pq.offer(new Integer[]{edge[1], adj[2], edge[0]});
            }
        }

        return sum;
    }
}

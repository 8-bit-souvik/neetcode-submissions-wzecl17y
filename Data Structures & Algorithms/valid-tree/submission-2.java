class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q =  new LinkedList<>();

        q.offer(new int[]{0, -1});
        visited.add(0);

        while(!q.isEmpty()){
            int[] tmpair = q.poll();
            int node = tmpair[0];
            int parent = tmpair[1];

            for(int child : adj.get(node)){
                if(child==parent){
                    continue;
                }

                if(visited.contains(child)){
                    return false;
                }

                visited.add(child);
                q.add(new int[]{child, node});
            }
        }

        return visited.size() == n;
    }
}

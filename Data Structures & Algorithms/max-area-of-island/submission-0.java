class Solution {
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[r].length; c++){
                if(grid[r][c]==1 && !visited.contains(new Pair<>(r, c))){
                    ans = Math.max(ans, captureIsland(grid, r, c));
                }
            }
        }

        return ans;
    }

    int captureIsland(int[][] grid, int row, int col){
        int area = 1;
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(row, col));
        visited.add(new Pair<>(row, col));
        while(!q.isEmpty()){
            row = q.peek().getKey();
            col = q.peek().getValue();
            for(int[] path : direction){
                if(row+path[0]<0 || row+path[0]>grid.length-1 || col+path[1]<0 || col+path[1]>grid[row].length-1 || grid[row+path[0]][col+path[1]] != 1 || visited.contains(new Pair<>(row+path[0], col+path[1]))){
                    continue;
                }else{
                    q.offer(new Pair<>(row+path[0], col+path[1]));
                    area += 1;
                    visited.add(new Pair<>(row+path[0], col+path[1]));
                }
            }
            q.poll();
        }

        return area;
    }

    class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }

        @Override
        public int hashCode(){
            return Objects.hash(key, value);
        }

        @Override
        public boolean equals(Object o){
            if(o == this) return true;
            if(o == null || this.getClass() != o.getClass()) return false;

            Pair that = (Pair) o;
            return Objects.equals(this.key, that.key) && Objects.equals(this.value, that.value);
        }

    }
}

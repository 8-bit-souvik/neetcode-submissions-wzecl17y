class Solution {
    public int orangesRotting(int[][] grid) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        int total = 0;
        int[][] sGrid = new int[grid.length][grid[0].length];
        for(int[] sRow : sGrid){
            Arrays.fill(sRow, 99999);
        }
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 2){
                    visited.add(new Pair<>(i, j));
                    q.offer(new Pair<>(i, j));
                    sGrid[i][j] = 0;
                    total+=1;
                }
                if(grid[i][j] == 1){
                    total+=1;
                }
            }
        }

        int ans = 0;
        int row, col;
        while(!q.isEmpty()){
            row = q.peek().getKey();
            col = q.peek().getValue();
            int flag = 0;
            if(row > 0 && grid[row-1][col]==1 && !visited.contains(new Pair<>(row-1, col))){
                visited.add(new Pair<>(row-1, col));
                q.offer(new Pair<>(row-1, col));
                sGrid[row-1][col] = Math.min(sGrid[row-1][col], sGrid[row][col]+1);
                ans = Math.max(ans, sGrid[row-1][col]);
            }
            if(row < grid.length-1 && grid[row+1][col]==1 && !visited.contains(new Pair<>(row+1, col))){
                visited.add(new Pair<>(row+1, col));
                q.offer(new Pair<>(row+1, col));
                sGrid[row+1][col] = Math.min(sGrid[row+1][col], sGrid[row][col]+1);
                ans = Math.max(ans, sGrid[row+1][col]);
            }
            if(col > 0 && grid[row][col-1]==1 && !visited.contains(new Pair<>(row, col-1))){
                visited.add(new Pair<>(row, col-1));
                q.offer(new Pair<>(row, col-1));
                sGrid[row][col-1] = Math.min(sGrid[row][col-1], sGrid[row][col]+1);
                ans = Math.max(ans, sGrid[row][col-1]);
            }
            if(col < grid[row].length-1 && grid[row][col+1]==1 && !visited.contains(new Pair<>(row, col+1))){
                visited.add(new Pair<>(row, col+1));
                q.offer(new Pair<>(row, col+1));
                sGrid[row][col+1] = Math.min(sGrid[row][col+1], sGrid[row][col]+1);
                ans = Math.max(ans, sGrid[row][col+1]);
            }

            q.poll();
        }

        if(total == visited.size()){
            return ans;
        }else{
            return -1;
        }
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
            return Objects.equals(this.key, that.key) && Objects.equals(this.key, that.key);
        }
    }
}

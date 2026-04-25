class Solution {
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[r].length; c++){
                if(!visited.contains(new Pair<>(r, c)) && grid[r][c] == '1'){
                    ans += 1;
                    visited.add(new Pair<>(r, c));
                    captureIsland(grid, r, c);
                }
            }
        }
        return ans;
    }

    void captureIsland(char[][] grid, int row, int col){
        if((row>0 && grid[row-1][col]=='1') && !visited.contains(new Pair<>(row-1, col))){
            visited.add(new Pair<>(row-1, col));
            captureIsland(grid, row-1, col);
        }
        
        if((row<grid.length-1 && grid[row+1][col]=='1') && !visited.contains(new Pair<>(row+1, col))){
            visited.add(new Pair<>(row+1, col));
            captureIsland(grid, row+1, col);
        }

        if((col>0 && grid[row][col-1]=='1') && !visited.contains(new Pair<>(row, col-1))){
            visited.add(new Pair<>(row, col-1));
            captureIsland(grid, row, col-1);
        }
        
        if((col<grid[row].length-1 && grid[row][col+1]=='1') && !visited.contains(new Pair<>(row, col+1))){
            visited.add(new Pair<>(row, col+1));
            captureIsland(grid, row, col+1);
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
            if(o == this){ return true;};
            if(o == null || this.getClass() != o.getClass()){
                    return false;
            }

            Pair that = (Pair) o;
            return Objects.equals(this.key, that.key) && Objects.equals(this.value, that.value);
        }
    }
}

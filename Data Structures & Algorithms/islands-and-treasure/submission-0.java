class Solution {
    int wall = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[r].length; c++){
                if(grid[r][c] == 0){
                    visited.add(new Pair<>(r, c));
                    q.offer(new Pair<>(r, c));
                }
            }
        }

        int row;
        int col;
        while(!q.isEmpty()){
            row = q.peek().getKey();
            col = q.peek().getValue();
            if(row > 0 && grid[row-1][col]!=-1 && grid[row-1][col]!=0 && !visited.contains(new Pair<>(row-1, col))){
                visited.add(new Pair<>(row-1, col));
                q.offer(new Pair<>(row-1, col));
                grid[row-1][col] = Math.min(grid[row-1][col], grid[row][col]+1);
            }
            if(row < grid.length-1 && grid[row+1][col]!=-1 && grid[row+1][col]!=0 && !visited.contains(new Pair<>(row+1, col))){
                visited.add(new Pair<>(row+1, col));
                q.offer(new Pair<>(row+1, col));
                grid[row+1][col] = Math.min(grid[row+1][col], grid[row][col]+1);
            }
            if(col > 0 && grid[row][col-1]!=-1 && grid[row][col-1]!=0 && !visited.contains(new Pair<>(row, col-1))){
                visited.add(new Pair<>(row, col-1));
                q.offer(new Pair<>(row, col-1));
                grid[row][col-1] = Math.min(grid[row][col-1], grid[row][col]+1);
            }
            if(col < grid[row].length-1 && grid[row][col+1]!=-1 && grid[row][col+1]!=0 && !visited.contains(new Pair<>(row, col+1))){
                visited.add(new Pair<>(row, col+1));
                q.offer(new Pair<>(row, col+1));
                grid[row][col+1] = Math.min(grid[row][col+1], grid[row][col]+1);
            }

            q.poll();
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
            return Objects.equals(this.key, that.key) && Objects.equals(this.value, that.value);
        }
    }
}

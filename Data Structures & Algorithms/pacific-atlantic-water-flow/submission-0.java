class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        
        for(int i=0; i<rows; i++){
            dfs(i, 0, pac, heights);
            dfs(i, cols-1, atl, heights);
        }

        for(int i=0; i<cols; i++){
            dfs(0, i, pac, heights);
            dfs(rows-1, i, atl, heights);
        }

        // for(boolean[] row : pac){
        //     for(boolean x : row){
        //         System.out.print(x+" ");
        //     }
        //     System.out.println();
        // }
        //     System.out.println();

        // for(boolean[] row : atl){
        //     for(boolean x : row){
        //         System.out.print(x+" ");
        //     }
        //     System.out.println();
        // }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                if(pac[i][j] && atl[i][j]){
                    ans.add(new ArrayList<>());
                    ans.get(ans.size()-1).add(i);
                    ans.get(ans.size()-1).add(j);
                }
            }
        }
        return ans;
    }

    void dfs(int row, int col, boolean[][] ocean, int[][] heights){
        ocean[row][col] = true;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int[] d : dirs){
            int nr = row+d[0], nc = col+d[1];
            if(nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length 
                || ocean[nr][nc] || heights[nr][nc] < heights[row][col]){
                    continue;
            }else{
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> 
            Integer.compare(x[0]*x[0] + x[1]*x[1] , y[0]*y[0] + y[1]*y[1]));
        

        for(int[] point : points){
            maxHeap.offer(point);
        }

        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++){
            ans[i] = maxHeap.poll();
        }

        return ans;
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // cost[cost.length-2] = Math.min(cost[cost.length-2], cost[cost.length-1]);

        for(int i=cost.length-3; i>=0; i--){
            cost[i] = Math.min(cost[i]+cost[i+1], cost[i]+cost[i+2]);
        }

        for(int x : cost){
            System.out.print(x+" ");
        }
        System.out.println("");

        return Math.min(cost[0], cost[1]);
    }
}

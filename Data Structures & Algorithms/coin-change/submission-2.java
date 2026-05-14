class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = dfs(coins, amount, map);
        return ans == 99999 ? -1 : ans;
    }

    public int dfs(int[] coins, int amt, Map<Integer, Integer> map){
        if(amt == 0){
            return 0;
        }

        if(map.containsKey(amt)){
            return map.get(amt);
        }

        int minVal = 99999;
        for(int coin : coins){
            if(amt-coin >= 0){
               minVal = Math.min(minVal, 1+dfs(coins, amt-coin, map));
            }
        }

        map.put(amt, minVal);

        return minVal;
    }
}

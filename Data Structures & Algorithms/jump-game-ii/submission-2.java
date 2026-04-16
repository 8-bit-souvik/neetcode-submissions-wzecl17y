class Solution {
    public int jump(int[] nums) {
        int[] store = new int[nums.length];
        Arrays.fill(store, -1);
        int ans = dfs(nums, 0, store);

        return ans;
    }

    public static int dfs(int[] nums, int pointer, int[] store){
        if(pointer == nums.length-1){
            return 0;
        }
        if(nums[pointer] == 0){
            return 0;
        }

        if(store[pointer] != -1){
            return store[pointer];
        }

        int range =  Math.min(nums.length-1, pointer+nums[pointer]);
        int val = 99999;
        for(int i=pointer+1; i<=range; i++){
            int tmp = dfs(nums, i, store);
            if(i < nums.length-1 && tmp==0){
                continue;
            };
            val = Math.min(val, 1+tmp);
        }

        store[pointer] = val;
        return val;
    }
}

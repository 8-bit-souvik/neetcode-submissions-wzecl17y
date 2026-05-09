class Solution {
    public int rob(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }

        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];

        for(int i=0; i<nums.length-1; i++){
            nums1[i] = nums[i];
            nums2[i] = nums[i+1];
        }
        
        int[] memo = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            memo[i] = -1;
        }

        int ans1 = dfs(nums1, 0, memo);

        for(int i=0; i<nums.length; i++){
            memo[i] = -1;
        }

        int ans2 = dfs(nums2, 0, memo);


        return Math.max(ans1, ans2);
    }

    public int dfs(int[] nums, int i, int[] memo){
        if(i >= nums.length){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }


        memo[i] = Math.max(dfs(nums, i+1, memo), dfs(nums, i+2, memo)+nums[i]);
        return memo[i];
    }
}

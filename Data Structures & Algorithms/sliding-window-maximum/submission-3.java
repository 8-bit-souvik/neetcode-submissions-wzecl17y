class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> window = new ArrayList<Integer>();
        int ans[] = new int[nums.length-k+1];

        for(int x : Arrays.copyOfRange(nums, 0, k)){
            window.add(x);
        }

        int j=0;
        // System.out.println(getMax(window));
        ans[j] = getMax(window);
        j++;
        for(int i=k; i<nums.length; i++){
            window.add(nums[i]);
            window.remove(0);
            // System.out.println(getMax(window));
            ans[j] = getMax(window);
            j++;
        }
        return ans;
    }

    static int getMax(ArrayList<Integer> arr){
        int max = arr.get(0);
        for(int i=1; i<arr.size(); i++){
            max = Math.max(max, arr.get(i));
        }
        return max;
    } 
}

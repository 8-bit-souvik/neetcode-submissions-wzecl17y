class Solution {
    static int count = 0;
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int ans = intervals.length - dfs(intervals, 0, -1);
        // System.out.println(count);
        return ans;
    }

    int dfs(int[][] intervals, int ptr, int pre){
        count++;
        if(ptr == intervals.length){
            return 0;
        }

        int val1 = 0;
        int val2 = 0;
        val1 = dfs(intervals, ptr+1, pre);
        if(pre==-1 || intervals[pre][1]<=intervals[ptr][0]){
            val2 = 1+dfs(intervals, ptr+1, ptr);
        }

        return Math.max(val1, val2);

    }
}

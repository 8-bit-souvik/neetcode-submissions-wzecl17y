// class Solution {
//     static int count = 0;
//     public int eraseOverlapIntervals(int[][] intervals) {
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
//         int[] store = new int[intervals.length];
//         Arrays.fill(store, -1);
//         int ans = intervals.length - dfs(intervals, 0, store);
//         // System.out.println(count);
//         return ans;
//     }

//     int dfs(int[][] intervals, int ptr, int[] store){
//         count++;
//         if(ptr == intervals.length){
//             return 0;
//         }

//         int val1 = 0;
//         int val2 = 0;

//         if(store[ptr] != -1){
//             return store[ptr];
//         }

//         int res = 1;
//         for(int j=ptr+1; j<intervals.length; j++){
//             if(intervals[ptr][1] <= intervals[j][0]){
//                 res = Math.max(res, 1+dfs(intervals, j, store));
//             }
//         }

//         store[ptr] = res; 
//         return store[ptr];

//     }
// }






class Solution {
    static int count = 0;
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

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
        
        if(pre==-1 || intervals[pre][1]<=intervals[ptr][0]){
            val2 = 1+dfs(intervals, ptr+1, ptr);
        }

        val1 = dfs(intervals, ptr+1, pre);

        return Math.max(val1, val2);

    }
}

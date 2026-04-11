class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> tmp = new ArrayList<>();
        return intervals.length - dfs(intervals, 0, tmp);
    }

    int dfs(int[][] intervals, int ptr, List<int[]> tmp){
        if(ptr == intervals.length){
            return tmp.size();
        }

        int val1 = 0;
        int val2 = 0;

        if(tmp.isEmpty() || (tmp.get(tmp.size()-1)[1] <= intervals[ptr][0])){
            tmp.add(intervals[ptr]);
            val1 = dfs(intervals, ptr+1, tmp);
            tmp.remove(tmp.size()-1);
        }

        val2 = dfs(intervals, ptr+1, tmp);

        return Math.max(val1, val2);
    }
}

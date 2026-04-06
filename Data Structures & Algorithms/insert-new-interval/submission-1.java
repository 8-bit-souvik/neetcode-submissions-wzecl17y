class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        // newIntervalStart = Math.min(intervals[i][0], newInterval[0]);

        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        res.add(newInterval);

        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[res.size()][2];
        for(int j=0; j<res.size(); j++){
            ans[j] = res.get(j);
        }

        return ans;
    }
}

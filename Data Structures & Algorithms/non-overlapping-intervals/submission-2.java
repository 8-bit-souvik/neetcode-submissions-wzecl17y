class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Map<Pair<List<int[]>, Integer>, Integer> store = new HashMap<>();
        List<int[]> tmp = new ArrayList<>();
        return intervals.length - dfs(intervals, 0, tmp, store);
    }

    int dfs(int[][] intervals, int ptr, List<int[]> tmp, Map<Pair<List<int[]>, Integer>, Integer> store){
        if(ptr == intervals.length){
            return tmp.size();
        }

        if(store.containsKey(new Pair<>(tmp, ptr))){
            return store.get(new Pair<>(tmp, ptr));
        }

        int val1 = 0;
        int val2 = 0;

        if(tmp.isEmpty() || (tmp.get(tmp.size()-1)[1] <= intervals[ptr][0])){
            tmp.add(intervals[ptr]);
            val1 = dfs(intervals, ptr+1, tmp, store);
            tmp.remove(tmp.size()-1);
        }

        val2 = dfs(intervals, ptr+1, tmp, store);

        store.put(new Pair<>(tmp, ptr), Math.max(val1, val2));
        return store.get(new Pair<>(tmp, ptr));

        // return Math.max(val1, val2);
    }
}

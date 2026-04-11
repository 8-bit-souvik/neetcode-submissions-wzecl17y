/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
        int ans = 0;

        for(Interval interval : intervals){
            if(!pq.isEmpty() && pq.peek().end <= interval.start){
                pq.poll();
                pq.offer(interval);
            }else{
                pq.offer(interval);
            }
            ans = Math.max(pq.size(), ans);
        }
        return ans;
    }
}

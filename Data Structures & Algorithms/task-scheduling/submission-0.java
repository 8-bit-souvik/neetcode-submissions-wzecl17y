class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charmap = new HashMap<>();
        for(char task : tasks){
            if(charmap.containsKey(task)){
                charmap.put(task, charmap.get(task)+1);
            }else{
                charmap.put(task, 1);
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : charmap.values().toArray(new Integer[0])){
            maxHeap.offer(x);
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            }else{
                if(maxHeap.peek() > 1){
                    q.offer(new int[]{maxHeap.poll()-1, time+n});
                }else{
                    maxHeap.poll();
                }
            }

            while(!q.isEmpty() && time == q.peek()[1]){
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){
            int one = maxHeap.poll();
            int two = maxHeap.poll();

            maxHeap.offer(Math.abs(one-two));
        }

        return maxHeap.poll();

    }
}

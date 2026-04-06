class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){
            maxHeap.offer(Math.abs(maxHeap.poll()-maxHeap.poll()));
        }

        return maxHeap.poll();

    }
}

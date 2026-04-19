class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] close = {0, 0, 0};
        for(int[] triplet : triplets){
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]){
                continue;
            }
            close[0] = Math.max(close[0], triplet[0]);
            close[1] = Math.max(close[1], triplet[1]);
            close[2] = Math.max(close[2], triplet[2]);
        }

        if(close[0] != target[0] || close[1] != target[1] || close[2] != target[2]){
            return false;
        }
        return true;
    }
}

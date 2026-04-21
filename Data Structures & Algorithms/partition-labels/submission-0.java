class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            lastIndex.put(s.charAt(i), i);
        }

        int end = 0;
        int start = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if(i == end){
                ans.add(end-start+1);
                start = i+1;
            }
        }

        return ans;
    }
}

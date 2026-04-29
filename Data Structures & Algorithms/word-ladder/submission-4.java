class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        // for(String neigWord : wordList){
        //     int mismatch = 0;
        //     for(int i=0; i<beginWord.length(); i++){
        //         if(beginWord.charAt(i) != neigWord.charAt(i)){
        //             mismatch++;
        //         }
        //     }
        //     if(mismatch == 1){
        //             map.put(beginWord, new HashSet<>());
        //             map.get(beginWord).add(neigWord);
        //     }
        // }
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }
        
        for(String word : wordList){
            if(!map.containsKey(word)){
                map.put(word, new HashSet<>());
            }
            for(String neigWord : wordList){
                int mismatch = 0;
                for(int i=0; i<word.length(); i++){
                    if(word.charAt(i) != neigWord.charAt(i)){
                        mismatch++;
                    }
                }
                if(mismatch == 1){
                    map.get(word).add(neigWord);
                }
            }
        }

        // System.out.println(map);

        Set<String> visited = new HashSet<>();
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord, 1));
        visited.add(beginWord);
        while(!q.isEmpty()){
            // System.out.println(q.peek().getKey() +" "+endWord+" "+q.peek().getValue());
            if(q.peek().getKey().equals(endWord)){
                return q.peek().getValue();
            }

            String w = q.peek().getKey();
            int c = q.peek().getValue();
            for(String nw : map.get(w)){
                if(!visited.contains(nw)){
                    q.offer(new Pair<>(nw, c+1));
                    visited.add(nw);
                }
            }

            q.poll();
        }

        return 0;
    }

    class Pair<K, V>{
        final K key;
        final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }

        public int hashCode(){
            return Objects.hash(key, value);
        }
        public boolean equals(Object o){
            if(this == o){return true;}
            if(o == null && o.getClass() != getClass()){return false;}
            Pair that = (Pair) o;
            return Objects.equals(this.key, that.key) && Objects.equals(this.value, that.value);
        }
    }
}

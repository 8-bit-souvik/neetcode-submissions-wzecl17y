class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> pointer = new HashMap<>();
      Map<Character, Set<Character>> indegree = new HashMap<>();

      for(String word : words){
        for(int i=0; i<word.length(); i++){
            pointer.put(word.charAt(i), new HashSet<>());
            indegree.put(word.charAt(i), new HashSet<>());
        }
      }

      for(int i=0; i<words.length-1; i++){
        String w1 = words[i];
        String w2 = words[i+1];
        int minLen = Math.min(w1.length(), w2.length());
        if(w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))){
            return "";
        }
        for(int j=0; j<minLen; j++){
            if(w1.charAt(j) != w2.charAt(j)){
                pointer.get(w1.charAt(j)).add(w2.charAt(j));
                indegree.get(w2.charAt(j)).add(w1.charAt(j));

                break;
            }
        }
      }

    //   System.out.println("pointer: "+pointer);
    //   System.out.println("indegree: "+indegree);

      Set<Character> visited = new HashSet<>();
      Queue<Character> q = new LinkedList<>();
      String ans = "";

      for(Character c : pointer.keySet()){
        if(indegree.get(c).isEmpty()){
          q.offer(c);
        }
      }

    //   System.out.println(q);

      while(!q.isEmpty()){
        Character node = q.poll();
        if(visited.contains(node)){
          continue;
        }
        visited.add(node);
        ans += node;

        for(Character c : pointer.get(node)){
          indegree.get(c).remove(node);
          if(indegree.get(c).isEmpty()){
            q.offer(c);
          }
        }
        if(ans.length() == indegree.size()){
            return ans;
        }
      }

      return "";
    }
}

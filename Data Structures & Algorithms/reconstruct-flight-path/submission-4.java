class Solution {
    List<String> ans = new ArrayList<>();
    // Map<Pair<String, String>, Integer> paths = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        // for(List<String> ticket : tickets){
        //     Pair<String, String> p = new Pair<>(ticket.get(0), ticket.get(1));
        //     if(!paths.containsKey(p)){
        //         paths.put(p, 0);
        //     }
        //     paths.put(p, paths.get(p)+1);
        // }
        for(List<String> ticket: tickets){
            if(!map.containsKey(ticket.get(0))){
                map.put(ticket.get(0), new ArrayList<>());
            }
            if(!map.containsKey(ticket.get(1))){
                map.put(ticket.get(1), new ArrayList<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
            Collections.sort(map.get(ticket.get(0)));
        }
        List<String> tmpList = new ArrayList<>();
        // System.out.println(map);
        tmpList.add("JFK");
        dfs(map, "JFK", tmpList);


        return ans;
    }

    void dfs(Map<String, List<String>> map, String curr, List<String> tmpList){
        // System.out.println("- " + tmpList);
        // System.out.println("+ " + curr + " | " + paths);
        // System.out.println("= " + curr + " | " + map);
        // System.out.println("--");
        // System.out.println(map);
        boolean emptyMap = true;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            // System.out.print(entry.getKey());
            // System.out.print(" : ");
            // System.out.println(entry.getValue());
            if(!entry.getValue().isEmpty()){
                emptyMap = false;
            }
        }
        if(emptyMap){
            // System.out.println("Final!");
            if(ans.isEmpty()){
                ans = new ArrayList<>(tmpList);
            }
            return;
        }

        Set<String> branches = new TreeSet<>(map.get(curr));
        for(String node : branches){

            // Pair<String, String> p = new Pair<>(curr, node);
            // if(paths.get(p) > 0){
                tmpList.add(node);
                map.get(curr).remove(node);
                // paths.put(p, paths.get(p)-1);
                if(ans.isEmpty()){
                    dfs(map, node, tmpList);
                }
                // paths.put(p, paths.get(p)+1);
                map.get(curr).add(tmpList.remove(tmpList.size()-1));
                // tmpList.remove(node);
            // }
        }
    }
}
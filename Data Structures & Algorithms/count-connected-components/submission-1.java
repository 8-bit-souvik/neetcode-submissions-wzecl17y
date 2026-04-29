class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n, edges);
        int components = dsu.countComponents();
        return components;
    }
}


class DSU{
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> size = new HashMap<>();
    int components;

    public DSU(int n, int[][] edges){
        // for(int[] edge : edges){
        //     parent.put(edge[0], edge[0]);
        //     parent.put(edge[1], edge[1]);
        //     size.put(edge[0], 1);
        //     size.put(edge[1], 1);
        // }
        for(int i=0; i<n; i++){
            parent.put(i, i);
            size.put(i, 1);
        }
        components = parent.size();
        for(int[] edge : edges){
            union(edge);
        }
    }

    public int findParent(int node){
        int parentNode = node;
        while(parent.get(parentNode) != parentNode){
            parentNode = parent.get(parentNode);
        }
        return parentNode;
    }

    public void union(int[] edge){
        int u = edge[0];
        int v = edge[1];
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv){return;}
        if(size.get(pv) > size.get(pu)){
            int tmp = pu;
            pu = pv;
            pv = tmp;
        }

        parent.put(pu, pv);
        size.put(pu, size.get(pu)+size.get(pv));
        components--;
    }

    public int countComponents(){
        return components;
    }
}
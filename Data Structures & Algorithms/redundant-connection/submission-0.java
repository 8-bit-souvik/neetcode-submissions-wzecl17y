class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges);
        return dsu.getRedundants();
    }
}

class DSU{
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> size = new HashMap<>();
    int[] redundant = new int[2];

    public DSU(int[][] edges){
        for(int[] edge: edges){
            parent.put(edge[0], edge[0]);
            parent.put(edge[1], edge[1]);
            size.put(edge[0], 1);
            size.put(edge[1], 1);
        }

        for(int[] edge: edges){
            union(edge);
        }
    }

    public int findParent(int node){
        int nodeParent = node;
        while(parent.get(nodeParent) != nodeParent){
            nodeParent = parent.get(nodeParent);
        }
        return nodeParent;
    }

    public void union(int[] edge){
        int u = edge[0];
        int v = edge[1];
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv){
            redundant[0] = u;
            redundant[1] = v;
            return;
        }
        if(size.get(pv) > size.get(pu)){
            int tmp = pu;
            pu = pv;
            pv = tmp;
        }
        parent.put(pv, pu);
        size.put(pu, size.get(pu)+size.get(pv));
        return;
    }

    public int[] getRedundants(){
        return redundant;
    }
}
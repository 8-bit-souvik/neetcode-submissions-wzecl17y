class PrefixTree {
    private TreeNode root;

    public PrefixTree() {
        root = new TreeNode(); 
    }

    public void insert(String word) {
        TreeNode trvs = root;
        for(Character ch : word.toCharArray()){
            if(trvs.children.get(ch) != null){
                trvs = trvs.children.get(ch);
            }else{
                trvs.children.put(ch, new TreeNode());
                trvs = trvs.children.get(ch);
            }
        }
        trvs.endOfWord = true;
    }

    public boolean search(String word) {
        TreeNode trvs = root;
        for(Character ch : word.toCharArray()){
            if(trvs.children.get(ch) != null){
                trvs = trvs.children.get(ch);
            }else{
                return false;
            }
        }
        if(trvs.endOfWord){
            return true;
        }else{
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        TreeNode trvs = root;
        for(Character ch : prefix.toCharArray()){
            if(trvs.children.get(ch) != null){
                trvs = trvs.children.get(ch);
            }else{
                return false;
            }
        }
        return true;
    }
}

class TreeNode {
    HashMap<Character, TreeNode> children = new HashMap<>();
    Boolean endOfWord = false;
}
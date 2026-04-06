class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keymap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> ans = new ArrayList<>();

        if(digits.isEmpty()){
            return ans;
        }
        rec(digits, keymap, 0, "", ans);
        return ans;
    }

    void rec(String digits, String[] keymap, int p, String tmp, List<String> ans){
        if(digits.length()==p){
            ans.add(tmp);
            return;
        }

        int num = digits.charAt(p) - '0';
        for(int i=0; i<keymap[num].length(); i++){
            tmp += keymap[num].charAt(i);
            rec(digits, keymap, p+1, tmp, ans);
            tmp = tmp.substring(0, tmp.length()-1);
        }


    }
}

class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            memo[i] = -1;
        }
        return dfs(0, s, memo);    
    }

    public int dfs(int i, String s, int[] memo){
        if(i == s.length()){
            return 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        int res = dfs(i+1, s, memo);
        if((i < s.length()-1) && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <='6'))){
            res += dfs(i+2, s, memo);
        }

        memo[i] = res;

        return res;

    }


}

class Solution {
    public int countSubstrings(String s) {
        boolean[][] store = new boolean[s.length()][s.length()];
        int res = 0;

        for(int i=s.length()-1; i>=0; i--){
            for(int j=i; j<s.length(); j++){
                if(s.charAt(i)==s.charAt(j) && (j-i+1 <= 3 || store[i+1][j-1])){
                    store[i][j] = true;
                    // System.out.println(s.charAt(i)+" "+s.charAt(j));
                    res++;
                }
            }
        }

        return res;
    }
}

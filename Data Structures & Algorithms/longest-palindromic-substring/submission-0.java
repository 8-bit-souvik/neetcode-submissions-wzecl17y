class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0, resLen = 0;
        int n = s.length();

        boolean[][] store = new boolean[n][n];

        for(int i=n-1; i>= 0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || store[i+1][j-1])){
                    // if((i+1<n && j-1>0) && store[i+1][j-1]){
                    //     System.out.println(i+","+j+" : "+s.charAt(i)+"-"+s.charAt(j));
                    // }
                    store[i][j] = true;
                    if(resLen < j-i+1){
                        resLen = j-i+1;
                        resIdx = i;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx+resLen);
    }
}

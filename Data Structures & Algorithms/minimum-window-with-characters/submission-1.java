class Solution {
    private Boolean isSubstring(String s, String t){
        HashMap<String, Integer> mainString = new HashMap<String, Integer>();
        HashMap<String, Integer> subString = new HashMap<String, Integer>();
        String ans = "";

        for(int i=0; i<s.length(); i++){
            if(mainString.containsKey(s.substring(i, i+1))){
                mainString.replace(s.substring(i, i+1), mainString.get(s.substring(i, i+1))+1);
            }else{
                mainString.put(s.substring(i, i+1), 1);
            }
        }

        for(int i=0; i<t.length(); i++){
            if(subString.containsKey(t.substring(i, i+1))){
                subString.replace(t.substring(i, i+1), subString.get(t.substring(i, i+1))+1);
            }else{
                subString.put(t.substring(i, i+1), 1);
            }
        }

        System.out.println(mainString +" -- "+ subString);
        for(String i : subString.keySet()){
            if(!mainString.keySet().contains(i) || mainString.get(i) < subString.get(i)){
                return false;
            }
        }
        return true;
    }

    private String slideWindow(String s, Integer c, String t){
        String window = s.substring(0, c);
        // System.out.println(window);
        if(isSubstring(window, t)){
            return window;
        }

        for(int i=c; i<s.length(); i++){
            window += s.charAt(i);
            window = window.substring(1, window.length());
            if(isSubstring(window, t)){
                return window;
            }
        }

        return "";
    }

    public String minWindow(String s, String t) {
        int size = t.length();
        String ans = "";
        for(int i=size; i<=s.length(); i++){
            ans = slideWindow(s, i, t);
            if(ans != ""){
                return ans;
            };
        };
        return "";
    }
}

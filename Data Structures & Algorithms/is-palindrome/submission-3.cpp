class Solution {
public:
    bool isPalindrome(string s) {
        for(int i=0; i<s.size(); i++){
            if(s[i] >= 'a' && s[i] <= 'z'){
                continue;
            }else if(s[i] >= '0' && s[i] <= '9'){
                continue;
            }else if(s[i] >= 'A' && s[i] <= 'Z'){
                s[i] = char(int(s[i]) + int('a'-'A'));
            }else{
                s.erase(s.begin()+i);
                i--;
            }
        }

        // for(auto x : s){
        //     cout << x << " ";
        // }
        // cout << "   " << s.size() << endl;


        if(s == ""){
            return true;
        }

        if(!(s.size() & 1)){
            // even
            for(int i=0; i<s.size()/2; i++){
                if(s[i] != s[s.size()-i-1]){
                    return false;
                }        
            }
        }else{
            // odd
            for(int i=0; i<s.size()/2; i++){
                if(s[i] != s[s.size()-i-1]){
                    return false;
                }        
            }
        }

        return true;
    }
};

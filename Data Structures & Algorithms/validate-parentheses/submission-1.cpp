class Solution {
public:
    bool isValid(string s) {
        vector<int> stackbr;

        for(char x : s){
            if(stackbr.size() == 0){
                stackbr.push_back(x);
            }else if(x == '(' || x == '{' || x == '['){
                stackbr.push_back(x);
            }else if(x == ')'){
                if(stackbr[stackbr.size()-1] == '('){
                    stackbr.pop_back();
                }else{
                    stackbr.push_back(x);
                }
            }else if(x == '}'){
                if(stackbr[stackbr.size()-1] == '{'){
                    stackbr.pop_back();
                }else{
                    stackbr.push_back(x);
                }
            }else if(x == ']'){
                if(stackbr[stackbr.size()-1] == '['){
                    stackbr.pop_back();
                }else{
                    stackbr.push_back(x);
                }
            }
        }

        if(stackbr.size() == 0){
            return true;
        }else{
            return false;
        }
    }
};

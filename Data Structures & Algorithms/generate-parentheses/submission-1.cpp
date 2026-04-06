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

    void rec(int op, int cp, string & p, vector<string> & ans ){
        // cout << "p: " << p << "    op: " << op << "cp: " << cp << endl;
        if(op<0 || cp<0){
            return;
        }else if(op==0 && cp==0 && isValid(p)){
            // cout << " ..... " << endl;
            ans.push_back(p);
            return;
        }

        p.push_back('(');
        rec(op-1, cp, p, ans);
        p.pop_back();
        p.push_back(')');
        rec(op, cp-1, p, ans);
        p.pop_back();
    }

    vector<string> generateParenthesis(int n) {
        int op = n;
        int cp = n;
        string p;
        vector<string> ans;

        rec(op, cp, p, ans);

        return ans;

    }
};

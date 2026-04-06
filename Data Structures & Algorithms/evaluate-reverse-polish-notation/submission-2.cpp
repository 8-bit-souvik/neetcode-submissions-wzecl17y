class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        int i=0;
        while(tokens.size()>1){
            // cout << tokens[i] << " " << tokens[i+1] << " " << tokens[i+2] << endl;
            if(tokens[i+2]=="+"){
                tokens[i]=to_string(stoi(tokens[i])+stoi(tokens[i+1]));
                tokens.erase(tokens.begin()+i+1);
                tokens.erase(tokens.begin()+i+1);
                i=0;
            }else if(tokens[i+2]=="-"){
                tokens[i]=to_string(stoi(tokens[i])-stoi(tokens[i+1]));
                tokens.erase(tokens.begin()+i+1);
                tokens.erase(tokens.begin()+i+1);
                i=0;
            }else if(tokens[i+2]=="*"){
                tokens[i]=to_string(stoi(tokens[i])*stoi(tokens[i+1]));
                tokens.erase(tokens.begin()+i+1);
                tokens.erase(tokens.begin()+i+1);
                i=0;
            }else if(tokens[i+2]=="/"){
                tokens[i]=to_string(stoi(tokens[i])/stoi(tokens[i+1]));
                tokens.erase(tokens.begin()+i+1);
                tokens.erase(tokens.begin()+i+1);
                i=0;
            }else{
                i++;
            }
        }

        return stoi(tokens[0]);
    }
};

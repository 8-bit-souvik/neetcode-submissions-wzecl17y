class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        vector<int> leftsmall;
        vector<int> rightsmall;
        vector<vector<int>> tempstack;

        int ans = 0;

        for(int i=0; i<heights.size(); i++){
            while(tempstack.size()!=0 && tempstack[tempstack.size()-1][0] >= heights[i]){
                tempstack.pop_back();
            }
            if(tempstack.size()==0){
                leftsmall.push_back(0);
            }else{
                leftsmall.push_back(tempstack[tempstack.size()-1][1]+1);
            }
            tempstack.push_back({heights[i], i});
        }

        tempstack.clear();

        for(int i=heights.size()-1; i>=0; i--){
            while(tempstack.size()!=0 && tempstack[tempstack.size()-1][0] >= heights[i]){
                tempstack.pop_back();
            }
            if(tempstack.size()==0){
                rightsmall.insert(rightsmall.begin(), heights.size()-1);
            }else{
                rightsmall.insert(rightsmall.begin(), tempstack[tempstack.size()-1][1]-1);
            }
            tempstack.push_back({heights[i], i});
        }

        // ===============================================
        // for(int x : leftsmall){
        //     cout << x << " ";
        // }
        // cout << endl;
        // for(int x : rightsmall){
        //     cout << x << " ";
        // }
        // cout << endl;
        // for(int x : minheights){
        //     cout << x << " ";
        // }
        // cout << endl;
        // ===========================================

        for(int i=0; i<heights.size(); i++){
            ans = max(ans, (rightsmall[i]-leftsmall[i]+1)*heights[i]);
        }


        return ans;
    }
};
class Solution {
public:
    // vector<int> dailyTemperatures(vector<int>& temperatures) {
    //     for(int i=0; i<temperatures.size(); i++){
    //         int j=0;
    //         while(i+j < temperatures.size() && temperatures[i] >= temperatures[i+j]){
    //             j++;
    //         }

    //         if(i+j >= temperatures.size()){
    //             temperatures[i] = 0;
    //         }else{
    //             temperatures[i] = j;
    //         }

    //     }

    //     return temperatures;
    // }


    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<vector<int>> stack;
        vector<int> ans(temperatures.size());

        for(int i=0; i<temperatures.size(); i++){
            int curr = temperatures[i];
            while(stack.size() != 0 && curr > stack[stack.size()-1][0]){
                // cout << i << " - " << stack[stack.size()-1][1] << endl;
                ans[stack[stack.size()-1][1]] = i-stack[stack.size()-1][1];
                stack.pop_back();
            }
            stack.push_back({curr, i});
        }
        
        return ans;
    }
};

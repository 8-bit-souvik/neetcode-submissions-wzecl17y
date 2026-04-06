class Solution {
public:
    int trap(vector<int>& height) {
        vector<int> left_shadow;
        int left_max = height[0];
        vector<int> right_shadow;
        int right_max = height[height.size()-1];

        for(int x : height){
            left_max = max(left_max, x);
            left_shadow.push_back(left_max-x);
        }

        for(int i=height.size()-1; i>=0; i--){
            right_max = max(right_max, height[i]);
            right_shadow.insert(right_shadow.begin(), right_max-height[i]);
        } 

        int ans = 0;

        for(int i=0; i<height.size(); i++){
            ans += min(left_shadow[i], right_shadow[i]);
        }

        // for(int x: left_shadow){
        //     cout << x << " ";
        // }
        // cout << endl;

        // for(int x: right_shadow){
        //     cout << x << " ";
        // }
        // cout << endl;

        return ans;
    }
};

class Solution {
public:
    // void vecSort(vector<int>& nums){
    //     int temp;
    //     for(int i=0; i<nums.size(); i++){
    //         for(int j=0; j<nums.size(); j++){
    //             if(nums[i]<nums[j]){
    //                 temp = nums[j];
    //                 nums[j] = nums[i];
    //                 nums[i] = temp;
    //             }
    //         }
    //     }
    // }
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;

        for(int i=0; i<nums.size()-2; i++){
            // cout << "loop - 1" << endl;
            
            int j=i+1;
            int k=nums.size()-1;

            while(j<k){
                // cout << "loop - 2" << endl;

                if(nums[i]+nums[j]+nums[k] < 0){
                    // cout << "cond - 1" << endl;
                    j++;
                }else if(nums[i]+nums[j]+nums[k] > 0){
                    // cout << "cond - 2" << endl;

                    k--;
                    // j=i+1;
                }else{
                    // cout << "cond - 3" << endl;
                    ans.push_back({nums[i], nums[j], nums[k]});

                    while(j<k && nums[j]==nums[j+1]){
                        // cout << "loop - 3" << endl;

                        j++;
                    }
                    while(j<k && nums[k]==nums[k-1]){
                        // cout << "loop - 4" << endl;

                        k--;
                    }
                    j++;
                }

                while(i<j && nums[i]==nums[i+1]){
                    // cout << "loop - 5" << endl;

                    i++;
                }
            }
        }

        return ans;
    };

};
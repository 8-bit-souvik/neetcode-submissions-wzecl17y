class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        int arrsize = nums.size();
        set<int> mySet(nums.begin(), nums.end());
        int setsize = mySet.size();

        if(arrsize == setsize){
            return false;
        }else{
            return true;
        }
    }
};

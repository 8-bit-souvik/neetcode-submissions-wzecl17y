class Solution {
public:
    int findMin(vector<int> &nums) {
        int l = 0;
        int r = nums.size()-1;
        int pivot = nums.size()-1;

        while(nums[l]>nums[r]){
            pivot = (l+r)/2;
            cout << " l: " << l << " r: " << r << " pivot: " << pivot << endl;
            if(nums[l]>nums[pivot]){
                r = pivot;
            }else if(nums[pivot+1]>nums[r]){
                l = pivot+1;
            }else{
                break;
            }
        }
        // cout << " pivot: i: " << pivot << " r: " << r << " val: " << nums[pivot] << endl;

        if(pivot == nums.size()-1){
            return nums[0];
        }else{
            return nums[pivot+1];
        }
    }
};

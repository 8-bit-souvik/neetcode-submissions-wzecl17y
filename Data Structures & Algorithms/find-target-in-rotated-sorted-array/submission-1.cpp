class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0;
        int r = nums.size()-1;
        int pivot = nums.size()-1;

        int min;
        int max;

        while(nums[l]>nums[r]){
            pivot = (l+r)/2;
            // cout << " l: " << l << " r: " << r << " pivot: " << pivot << endl;
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
            min = 0;
            max = nums.size()-1;
        }else{
            // min = pivot+1;
            if(target >= nums[0] && target <= nums[pivot]){
                min = 0;
                max = pivot;
            }else if(target >= nums[pivot+1] && target <= nums[nums.size()-1]){
                min = pivot+1;
                max = nums.size()-1;
            }else{
                return -1;
            };
        }

        cout << "min: " << min << " max: " << max << endl;

        int mid;
        cout << " target: " << target << endl; 
        while(min <= max){
            cout << " min: " << min << " max: " << max  << endl;
            mid = (min+max)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                max = mid-1;
            }else if(target > nums[mid]){
                min = mid+1;
            }
        }

        return -1;
    }
};

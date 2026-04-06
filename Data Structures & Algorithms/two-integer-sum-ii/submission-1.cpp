class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int left = 0;
        int right = numbers.size()-1;

        while(left < right && (left >= 0 && right < numbers.size())){
            // cout << left << "  " << right << endl;
            if(target == numbers[left]+numbers[right]){
                return {left+1, right+1};
            }else if(target < numbers[left]+numbers[right]){
                right--;
            }else if(target > numbers[left]+numbers[right]){
                left++;
            }
        }
    }
};

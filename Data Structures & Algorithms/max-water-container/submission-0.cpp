class Solution {
public:
    int maxArea(vector<int>& heights) {
        int left = 0;
        int right = heights.size()-1;

        int ans = min(heights[right], heights[left])*(right-left);

        while(right>left){
            if(heights[right]>heights[left]){
                left++;
                ans = max(ans, min(heights[right], heights[left])*(right-left)) ;
            }else{
                right--;
                ans = max(ans, min(heights[right], heights[left])*(right-left)) ;
            }
        }

        return ans;
        
    }
};

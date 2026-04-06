class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int left = 0;
        int right = matrix.size()*matrix[0].size()-1;
        int mid, row, col;
        int n = matrix[0].size();

        // cout << " left: " << left << " right: " << right << endl;
        // cout << "n: " << n << endl;

        while(right >= left){
            mid = (left+right)/2;
            row = mid/n;
            col = mid%n;

            // cout << mid << " || row: " << row << " col: " << col << endl;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                left = mid+1; 
            }else if(matrix[row][col] > target){
                right = mid-1;
            }
        }

        return false;
    }
};

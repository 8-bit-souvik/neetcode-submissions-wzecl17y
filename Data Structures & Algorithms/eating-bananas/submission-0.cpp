class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int left = 1;
        int right = piles[0];
        for(int pile : piles){
            right = max(right, pile);
        }
        int hrs_spnt = 0;
        int mid;

        while(left<right){
            hrs_spnt = 0;
            mid = (left+right)/2;
            cout << "left: " << left << " mid: " << mid << " right: " << right << endl;
            for(auto pile : piles){
                hrs_spnt += ceil(double(pile)/double(mid));
            }
            cout << "hrs_spnt: " << hrs_spnt << endl;

            if(hrs_spnt <= h){
                right = mid;
            }else{
                left = mid+1;
            }
        } 

        return right;
    }
};

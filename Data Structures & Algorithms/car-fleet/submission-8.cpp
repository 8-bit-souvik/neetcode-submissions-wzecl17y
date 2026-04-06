class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<vector<float>> sortedcars;
        for(int i=0; i<position.size(); i++){
            sortedcars.push_back({position[i], speed[i], float(float(target-position[i])/float(speed[i]))});
        }

        sort(sortedcars.rbegin(), sortedcars.rend());

        for(auto x:sortedcars){
            cout << x[0] << " " << x[1] << " " << x[2] << endl;
        }

        int currentfleet = 0;
        int ans = 1;
        for(int i=1; i<sortedcars.size(); i++){
            if(sortedcars[i][2] > sortedcars[currentfleet][2]){
                ans++;
                currentfleet = i;
            }
        }

        return ans;
    }
};

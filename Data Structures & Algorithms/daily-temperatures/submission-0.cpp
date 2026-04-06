class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        for(int i=0; i<temperatures.size(); i++){
            int j=0;
            while(i+j < temperatures.size() && temperatures[i] >= temperatures[i+j]){
                j++;
            }

            if(i+j >= temperatures.size()){
                temperatures[i] = 0;
            }else{
                temperatures[i] = j;
            }

        }

        return temperatures;
    }
};

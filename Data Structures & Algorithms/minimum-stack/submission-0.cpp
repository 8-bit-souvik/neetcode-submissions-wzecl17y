class MinStack {
public:

    vector<int> stack;

    MinStack() {
        
    }
    
    void push(int val) {
        stack.push_back(val);
    }
    
    void pop() {
        stack.pop_back();
    }
    
    int top() {
        return stack[stack.size()-1];
    }
    
    int getMin() {
        int minVal = stack[0];
        for(int x:stack){
            minVal = min(x, minVal);
        }
        return minVal;
    }
};

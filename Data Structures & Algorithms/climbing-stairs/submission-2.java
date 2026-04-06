// class Solution {
//     public int climbStairs(int n) {
//         int one = 1;
//         int two = 1;

//         for(int i=0; i<n-1; i++){
//             int temp = two;
//             two = one+two;
//             one = temp;
//         }

//         return two;
//     }
// }

public class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if (i >= n) return i == n ? 1 : 0;
        if (cache[i] != -1) return cache[i];
        return cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}
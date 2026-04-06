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
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;
        double psi = (1 - sqrt5) / 2;
        n++;
        return (int) Math.round((Math.pow(phi, n) -
                     Math.pow(psi, n)) / sqrt5);
    }
}
class Solution {
    public double myPow(double x, int n) {
        //direct multiplting is O(n) times so try this for O(logn) binary bit shfting approach
        //https://leetcode.com/problems/powx-n/solutions/1337794/java-c-simple-o-log-n-easy-faster-than-100-explained/
        //for negative powers as (x)^-3 = (1/x^3)
        if(n < 0){
            n = -n;
            x = 1 / x;
        }

        double ans = 1;
        while (n != 0){
            //get LSB, if 1 multiply it with x
            if ((n&1) == 1){
                ans *= x;
            }
            n >>>= 1;
            x *= x; //imp, everytime we right shift, x needs to be squared
            //e.g. 3^11 = 3^1 * 3^2* 3^8. skipped 3^4 as MSB at that time is 0
        }
    
        return ans;
    }
}
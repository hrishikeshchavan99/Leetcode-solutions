public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        System.out.println(n);
        /* Not working for signed int eg 3
        while (n != 0){
            count += n%2;
            System.out.println(n);
            n = n/2;
        }
        */
        while (n != 0){
            count += (n&1);
            n = n >>> 1;
        }
        
        
        
        return count;            
    }
}
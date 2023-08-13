class Solution {
    //a&b gives carry, a^b gives sum
    //left shift carry by 1 and add to sum everytime
    //carry needs to be calculated separately as XOR doesn't care of carry(1^1 = 0)
    public int getSum(int a, int b) {
        int carry;
        while (b!=0){
            carry = a&b; 
            a = a^b;
            b = (carry << 1);
        }
        return a;
    }
}
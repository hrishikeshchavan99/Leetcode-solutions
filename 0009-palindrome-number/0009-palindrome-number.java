class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int end = str.length()-1;
        for (int i = 0; i < str.length()/2; i++){
            if (str.charAt(i) != str.charAt(end--))
                return false;
        }
        return true;
            
    }
}
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[70];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i)-'A']++;
        int flag = 0;
        int finalcount = 0;
        for (int i=0; i<70; i++ ){
            if (count[i] % 2 == 0)
                finalcount += count[i];
            else
                finalcount += count[i]-1;
            
            if (flag == 0 && count[i] % 2 == 1)    
                flag = 1;
        }
        if (flag == 1) return finalcount+1;
        else return finalcount;
    }
}
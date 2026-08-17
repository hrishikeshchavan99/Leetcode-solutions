class Solution {
    public int maximumLengthSubstring(String s) {
        int l = 0, r = 0, max = 0; 
        int[] count = new int[26];

        while (r < s.length()){
            char ch = s.charAt(r);
            count[ch - 'a']++;

            if (count[ch - 'a'] > 2){
                while(count[ch - 'a'] > 2) {
                    count[s.charAt(l) - 'a']--;
                    l++;
                }
            }

            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
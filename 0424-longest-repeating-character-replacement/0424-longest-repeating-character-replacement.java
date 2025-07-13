class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, len = s.length(), maxCount = 0, maxlen = 0;
        int[] count = new int[26];

        for (end = 0; end < len; end++){
            count[s.charAt(end)-'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end)-'A']);
            //sliding window len: end-start+1
            //maxCount- max count of single char in sliding window
            while (end - start + 1 - maxCount > k){
                count[s.charAt(start)-'A']--;
                start++;
            }
            maxlen = Math.max(maxlen, end-start+1);
        } 
        return maxlen;
    }
}
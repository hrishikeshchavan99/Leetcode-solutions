
class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length(), start = 0, end = 0;
        int maxLen = 0, res = 0;
        int[] count = new int[26];
        while (end < len) {
            count[s.charAt(end)-'A']++;

            maxLen = Math.max(maxLen, count[s.charAt(end)-'A']);
            while (end-start+1-maxLen > k){
                count[s.charAt(start)-'A']--;
                start++;
                maxLen = 0;
                for (int i = 0; i < 26; i++){
                    maxLen = Math.max(maxLen, count[i]);
                }
            }

            if (end-start+1-maxLen <= k){
                res = Math.max(res, end-start+1);
            }
            end++;
        }
        return res;
    }
}

/*
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
*/
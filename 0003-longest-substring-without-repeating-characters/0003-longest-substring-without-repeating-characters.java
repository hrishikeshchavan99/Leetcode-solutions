class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        String sub = "";
        for (int i = 0; i < s.length(); i++){
            if (!sub.contains(Character.toString(s.charAt(i)))){
                sub += s.charAt(i);
                if (sub.length() > count) count = sub.length();
            }
                
            else{ 
                i = i - sub.length() + sub.indexOf(s.charAt(i));
                sub = "";
            }
        }
        return count;
    }
}
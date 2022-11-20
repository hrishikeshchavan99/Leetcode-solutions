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
                sub = sub.substring(sub.indexOf(s.charAt(i))+1);
                sub += s.charAt(i);
            }
        }
        return count;
    }
}
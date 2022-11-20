class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0, index;
        String sub = "";
        for (int i = 0; i < s.length(); i++){
            if (!sub.contains(Character.toString(s.charAt(i)))){
                sub += s.charAt(i);
                if (sub.length() > count) count = sub.length();
            }
                
            else{ 
                index = sub.indexOf(s.charAt(i));
                sub = sub.substring(index+1);
                sub += s.charAt(i);
                System.out.println(sub);
                //i = i - sub.length() + index;
                //sub = "";
            }
        }
        return count;
    }
}
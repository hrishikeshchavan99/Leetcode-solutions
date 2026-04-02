class Solution {
    public boolean checkStrings(String s1, String s2) {
        int len = s1.length();

        int[] count = new int[52];

        for (int i = 0; i < len; i++){
            int offset = (i % 2) * 26;
            count[offset + s1.charAt(i) - 'a']++;
            count[offset + s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 52; i++){
            if (count[i] != 0) return false;
        }

        return true;

    }
}
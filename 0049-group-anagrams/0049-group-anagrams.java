class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String str: strs){
            char[] key = new char[26];
            for (char c: str.toCharArray()) key[c-'a']++;
            String temp = String.valueOf(key);
            if (!map.containsKey(temp))
                map.put(temp, new ArrayList());
            map.get(temp).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
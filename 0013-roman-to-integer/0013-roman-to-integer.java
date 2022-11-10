class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int sum = 0;
        for (int i=0; i < s.length()-1; i++){
            if (map.get(Character.toString(s.charAt(i))) < map.get(Character.toString(s.charAt(i+1))))
                sum -= map.get(Character.toString(s.charAt(i)));
            else
                sum += map.get(Character.toString(s.charAt(i)));
        }
        sum += map.get(Character.toString(s.charAt(s.length()-1)));
        return sum;
        
        
    }
}
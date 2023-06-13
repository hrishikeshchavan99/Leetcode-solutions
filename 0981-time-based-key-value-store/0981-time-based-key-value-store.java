class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)){
            TreeMap<Integer, String> tm = new TreeMap();
            tm.put(timestamp, value);
            map.put(key, tm);
        }
        else{
            map.get(key).put(timestamp, value);
        }
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)){
            if (map.get(key).containsKey(timestamp)){
                return map.get(key).get(timestamp);
            }
            else{
                Integer prev_ts = map.get(key).floorKey(timestamp);
                if (prev_ts != null){
                    return map.get(key).get(prev_ts);
               }
            }
        }
        return "";
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
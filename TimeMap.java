package OOD;

import com.sun.source.tree.Tree;
import java.util.*;

//use 2 maps, otherwise it will exceed time limit

public class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!this.map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        else {
            TreeMap<Integer, String> t = map.get(key);
            Integer floor = t.floorKey(timestamp);
            if (floor == null){
                return "";
            }
            else {
                return t.get(floor);
            }
        }
    }
}


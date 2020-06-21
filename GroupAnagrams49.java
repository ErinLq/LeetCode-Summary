import java.util.*;

public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null) return null;
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ca = new char[26];
            for(char c : s.toCharArray()){
                ca[c - 'a']++;
            }
            // String temp = Arrays.toString(ca);
            // Far faster than above
            String temp = String.valueOf(ca);
            // List<String> list = new ArrayList<>();
            // if(map.containsKey(temp)) list = map.get(temp);
            // Same result
            List<String> list = map.getOrDefault(temp, new ArrayList<>());
            list.add(s);
            map.put(temp, list);
        }
        return new ArrayList<>(map.values());
    }

}

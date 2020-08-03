import java.util.HashMap;
import java.util.HashSet;

public class WordPatternII291 {
    public static boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        return isMatch(pattern, str, 0, 0, map, set);

    }

    public static boolean isMatch(String pattern, String str, int p, int s, HashMap<Character, String> map, HashSet<String> set) {
        if (p == pattern.length() && s == str.length()) {
            return true;
        }
        else if (p == pattern.length() || s == str.length()) {
            return false;
        }

        char c = pattern.charAt(p);
        // if "c" has appeared
        if (map.containsKey(c)) {
            String temp = map.get(c);
            if (!str.startsWith(temp, s)) {
                return false;
            }
            else {
                return isMatch(pattern, str, p + 1, s + temp.length(), map, set);
            }
        }
        else {
            for (int i = s; i < str.length(); i++) {
                String t = str.substring(s, i + 1);
                //reduce duplication
                if (!set.contains(t)) {
                    map.put(c, t);
                    set.add(t);
                    if (isMatch(pattern, str, p + 1, i + 1, map, set)) {
                        return true;
                    }
                    map.remove(c);
                    set.remove(t);
                }
            }
        }
        return false;
    }

}

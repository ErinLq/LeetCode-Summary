import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain1048 {
    public int longestStrChain(String[] words) {
        if(words == null || words.length == 0) return 0;

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int maxLen = 0;
        Map<String, Integer> map = new HashMap<>();

        for(String s : words){
            //mark down the max of this word
            int len = 0;
            for(int i = 0; i < s.length(); i++){
                String temp = s.substring(0, i) + s.substring(i + 1);
                len = Math.max(len, map.getOrDefault(temp, 0) + 1);
            }
            map.put(s, len);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}

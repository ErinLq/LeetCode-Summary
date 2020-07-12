package SlidingWindow;

import java.util.*;

public class LongestSubstringwithAtMostTwoDistinctCharacters159 {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;

        int res = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
                res = Math.max(right - left + 1, res);
            }
            //new character
            else{
                map.put(c, 1);
                count++;
                if(count > 2){
                    while (left < right){
                        char l = s.charAt(left);
                        if(map.get(l) > 1){
                            map.put(l, map.get(l) - 1);
                        }
                        else {
                            map.remove(l);
                            break;
                        }
                        left++;
                    }
                    //remove the last one
                    left++;
                    count--;
                }
                res = Math.max(right - left + 1, res);
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ecebae";

        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }
}

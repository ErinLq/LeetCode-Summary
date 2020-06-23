import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()){
            return res;
        }
        int[] ca = new int[26];
        for(char c : p.toCharArray()){
            ca[c - 'a']++;
        }

        int start = 0, end = 0;
        int len = p.length();
        int diff = len;

        char temp;

        while(end < len){
            temp = s.charAt(end);
            ca[temp - 'a']--;
            if(ca[temp - 'a'] >= 0){
                diff--;
            }
            end++;
        }

        if(diff == 0){
            res.add(0);
        }

        while(end < s.length()){
            temp = s.charAt(start);
            //diff++ when elements out
            if(ca[temp - 'a'] >= 0) diff++;
            //increment for the elements out
            ca[temp - 'a']++;
            start++;

            temp = s.charAt(end);
            //diff-- when elements in, since it has been decreased above
            if(ca[temp - 'a'] > 0) diff--;
            //decrement for the elements in
            ca[temp - 'a']--;
            end++;
            if(diff == 0) {
                res.add(start);
            }
        }
        return res;

    }
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);
        for(Integer i : res){
            System.out.println("------------------");
            System.out.println(i);

        }

    }
}

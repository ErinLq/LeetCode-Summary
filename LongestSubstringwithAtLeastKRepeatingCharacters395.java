import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestSubstringwithAtLeastKRepeatingCharacters395 {
    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (k <= 0) {
            return s.length();
        }

        int[] count = new int[26];
        int unique = 0;
        int noLessThanK = 0;
        int res = 0;

        int left, right, index;

        for (int h = 1; h <= 26; h++) {
            Arrays.fill(count, 0);
            left = 0;
            right = 0;
            unique = 0;
            noLessThanK = 0;

            while (right < s.length()) {
                if (unique <= h) {
                    index = s.charAt(right) - 'a';
                    if (count[index] == 0) {
                        unique++;
                    }
                    count[index]++;
                    if (count[index] == k) {
                        noLessThanK++;
                    }
                    right++;
                }
                else {
                    index = s.charAt(left) - 'a';
                    if (count[index] == k) {
                        noLessThanK--;
                    }
                    count[index]--;
                    if (count[index] == 0) {
                        unique--;
                    }
                    left++;
                }
                if (unique == h && noLessThanK == h) {
                    res = Math.max(right - left, res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb",3));
    }
}

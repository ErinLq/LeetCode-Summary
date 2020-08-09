public class FirstUniqueCharacterinaString387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] chars = new int[26];

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            chars[c - 'a']++;
            i++;
        }
        i = 0;
        while (i < s.length()) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                break;
            }
            i++;
        }
        return (i < s.length()) ? i : -1;
    }
}

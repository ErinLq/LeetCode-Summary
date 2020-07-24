public class PermutatioinString567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] chars = new int[26];
        char temp;

        for(int i = 0; i < s1.length(); i++){
            temp = s1.charAt(i);
            chars[temp - 'a']++;
        }

        int start = 0, end = 0;
        int diff = s1.length();

        while (end < s1.length()){
            temp = s2.charAt(end);
            chars[temp - 'a']--;
            if(chars[temp - 'a'] >= 0) diff--;
            end++;
        }
        if(diff == 0) return true;
        else{
            while(end < s2.length()){
                temp = s2.charAt(start);
                chars[temp - 'a']++;
                if(chars[temp - 'a'] > 0) diff++;
                start++;

                temp = s2.charAt(end);
                chars[temp - 'a']--;
                if(chars[temp - 'a'] >= 0) diff--;
                end++;

                if(diff == 0) return true;
            }
            return false;
        }
    }
}

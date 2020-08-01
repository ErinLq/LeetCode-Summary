import java.util.*;

public class WordPattern290 {
    public static boolean wordPattern(String pattern, String str) {

        String[] words = str.split(" ");
        if (pattern.length() != words.length){
            return false;
        }
        //To separate type "char" and "string"
        HashMap map = new HashMap();

        for (int i = 0; i < words.length; i++){
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), i);
            }
            if (!map.containsKey(words[i])) {
                map.put(words[i], i);
            }


            if (map.get(pattern.charAt(i)) != map.get(words[i])) {
                return false;
            }
        }
        return true;
    }

//    public static boolean wordPattern2(String pattern, String str) {
//        HashMap map_index = new HashMap();
//        String[] words = str.split(" ");
//
//        if (words.length != pattern.length())
//            return false;
//
//        for (Integer i = 0; i < words.length; i++) {
//            char c = pattern.charAt(i);
//            String w = words[i];
//
//            if (!map_index.containsKey(c))
//                map_index.put(c, i);
//
//            if (!map_index.containsKey(w))
//                map_index.put(w, i);
//
//            if (map_index.get(c) != map_index.get(w))
//                return false;
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        String pattern = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println((wordPattern(pattern, str)) ? 1 : 2);
    }

}

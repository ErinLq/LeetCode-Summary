import ListNode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class FlipGame293 {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= 1) {
            return res;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                res.add(new String(s.substring(0, i) ) + "--" + s.substring(i + 2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "+++";
        List<String> res = generatePossibleNextMoves(s);
        for(String str : res){
            System.out.println(str);
        }
        System.out.println(s.substring(s.length()));
    }
}

package Backtracking;
import java.util.*;

public class LetterCombinationsofaPhoneNumber17 {
    public static List<String> letterCombinations(String digits) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder str = new StringBuilder();
        List<String> res = new ArrayList<>();

        letterCom(digits, str, mapping, res, digits.length(), 0);
        return res;
    }
    public static void letterCom(String digits, StringBuilder str, String[] mapping, List<String> res, int target, int digStart){
        if(str.length() == target){
            res.add(str.toString());
        }
        else{
            int dig = digits.charAt(digStart) - '0';
            for(int i = 0; i < mapping[dig].length(); i++){
                str.append(mapping[dig].charAt(i));
                letterCom(digits, str, mapping, res, target, digStart + 1);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String d = "29";
        List<String> list = letterCombinations(d);

        for(String s : list){
            System.out.println(s);
        }
    }
}

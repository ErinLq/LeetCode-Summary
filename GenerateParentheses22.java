import javax.naming.ldap.StartTlsRequest;
import java.lang.reflect.Array;
import java.util.*;

public class GenerateParentheses22 {
    public static List<String> generateParenthesis(int n) {
        List<List<String>> lists = new ArrayList<>();

        List<String> t = new ArrayList<>();
        t.add("");
        lists.add(t);

        for(int i = 1; i <= n; i++){
            List<String> help = new ArrayList<>();
            for(int j = 0; j < i; j++){
                for(String pre : lists.get(j)){
                    for(String post : lists.get(i - 1 - j)){
                        help.add("(" + pre + ")" + post);
                    }
                }
            }
            lists.add(help);
        }
        return new ArrayList<>(lists.get(n));
    }


    public static void main(String[] args) {
        for(String s : generateParenthesis(3)){
            System.out.println(s);

        }
    }
}

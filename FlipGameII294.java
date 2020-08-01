import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FlipGameII294 {

    //mark down all the fail cases
    HashSet<String> set = new HashSet<>();

    public boolean canWin(String s) {
        if (s.length() <= 1) {
            return false;
        }
        if (set.contains(s)) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String str = s.substring(0, i) + "--" + s.substring(i + 2);
                //只要存在对手必败情况，则己方必胜
                if (!canWin(str)) {
                    set.add(str);
                    return true;
                }
            }
        }
        //必败情况条件苛刻，需要无论如何都无法达到必胜
        return false;
    }
}

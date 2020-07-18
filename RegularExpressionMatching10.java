public class RegularExpressionMatching10 {
    public boolean isMatchI(String s, String p) {
        if(p == null) return false;
        return subMatch(s, p, 0 ,0);
    }

    public boolean subMatch(String s, String p, int starts, int startp){
        if(starts == s.length() && startp == p.length()){
            return true;
        }
        if(starts < s.length() && startp >= p.length()){
            return false;
        }

        if(startp != p.length() - 1 && p.charAt(startp + 1) == '*') {
            if (starts < s.length() && (p.charAt(startp) == '.' || s.charAt(starts) == p.charAt(startp))){
                return subMatch(s, p, starts + 1, startp + 2) || subMatch(s, p, starts + 1, startp) ||subMatch(s, p, starts, startp + 2);
            }
            else{
                return subMatch(s, p, starts, startp + 2);
            }
        }
        else {
            if(starts < s.length() && (s.charAt(starts) == p.charAt(startp) || p.charAt(startp) == '.')){
                return subMatch(s, p, starts + 1, startp + 1);
            }
            else{
                return false;
            }
        }
    }



    public boolean isMatchII(String s, String p) {
        if(p == null) return false;
        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
        res[0][0] = true;
        //only when the second character is * will work
        for(int j = 2; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*'){
                res[0][j] = res[0][j - 2];
            }
        }

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                    res[i][j] = res[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    // not match
                    if(p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.'){
                        res[i][j] = res[i][j - 2];
                    }
                    //match
                    else{
                        res[i][j] = res[i][j - 2] || res[i][j - 1] || res[i - 1][j];
                    }
                }
            }
        }
        return res[s.length() + 1][p.length() + 1];
    }
}

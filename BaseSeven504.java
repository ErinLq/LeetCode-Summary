public class BaseSeven504 {
    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.append(num % 7);
            num /= 7;
        }
        return str.reverse().toString();
    }

}

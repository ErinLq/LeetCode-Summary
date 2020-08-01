public class BinaryNumberwithAlternatingBits693 {
    public static boolean hasAlternatingBits(int n) {
        n ^= n >> 1;
        return (n & n + 1) == 0;

    }

}

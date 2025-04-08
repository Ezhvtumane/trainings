package ogs.leetcode.a07042025.integer.reverse;

public class ReverseInt {

    /*Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.*/
    public static void main(String[] args) {
        System.out.println(reverse(-2147483647));//2147483647
    }

    public static int reverse(int x) {
        int trailedX = delLeftZeros(x);
        int res = 0;
        while (trailedX != 0) {
            int lastDigit = trailedX % 10;
            if (res > 0 && res > ((Integer.MAX_VALUE - lastDigit) / 10)) {
                return 0;
            }
            if (res < 0 && res < ((Integer.MIN_VALUE - lastDigit) / 10)) {
                return 0;
            }
            res = res * 10 + lastDigit;
            trailedX = trailedX / 10;
        }
        return res;
    }

    public static int reverseWithLongCast(int x) {
        int trailedX = delLeftZeros(x);
        long res = 0;
        while (trailedX != 0) {
            int lastDigit = trailedX % 10;
            res = res * 10 + lastDigit;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            trailedX = trailedX / 10;
        }
        return (int) res;
    }

    public static int reverseByString(int x) {

        int trailedX = delLeftZeros(x);

        char[] charArray = String.valueOf(trailedX).toCharArray();
        char[] charArrayReversed = new char[charArray.length];

        if (charArray[0] == '-') {
            charArrayReversed[0] = '-';
            for (int i = 1; i < charArray.length; i++) {
                charArrayReversed[i] = charArray[charArray.length - i];
            }
        } else {
            for (int i = 0; i < charArray.length; i++) {
                charArrayReversed[i] = charArray[charArray.length - 1 - i];
            }
        }
        String reversed = String.valueOf(charArrayReversed);

        long l = Long.parseLong(reversed);
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }

        return Integer.parseInt(reversed);
    }

    public static int delLeftZeros(int x) {
        if (x == 0) {
            return 0;
        }
        if (x % 10 == 0) {
            return delLeftZeros(x / 10);
        } else {
            return x;
        }
    }

}

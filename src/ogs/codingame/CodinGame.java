package ogs.codingame;

public class CodinGame {
    //Your program must encode a string into a series of zeros.
    public static void main(String[] args) {
        String message = "%";
        byte[] kek = message.getBytes();
        final StringBuilder sb = new StringBuilder();
        for (byte b : kek) {
            String s = Integer.toBinaryString(b);
            while (s.length() < 7) {
                s = "0".concat(s);
            }
            sb.append(s);
        }
        String binart = sb.toString();
        char[] arr = binart.toCharArray();
        int prev = -1;
        for (char c : arr) {
            if (c == 49) { //49 == '1'
                if (prev == 0 || prev == -1) {
                    if (prev == -1) {
                        System.out.print("0 0");
                    } else {
                        System.out.print(" 0 0");
                    }
                } else {
                    System.out.print("0");
                }
                prev = 1;
            } else {
                if (prev == 1 || prev == -1) {
                    if (prev == -1) {
                        System.out.print("00 0");
                    } else {
                        System.out.print(" 00 0");
                    }
                } else {
                    System.out.print("0");
                }
                prev = 0;
            }
        }
    }
}

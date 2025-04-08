package ogs.leetcode.a07042025.integer.palindrome;

public class Main {
    /*
Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Constraints:

    -231 <= x <= 231 - 1
    * */
    public static void main(String[] args) {
        //System.out.println(palindromeIntByString(10101));

        System.out.println(palindromeInt(1101011));

/*        Integer i = 2147483647;
        Integer r = 0;
        Integer multiplier = 10;
        do {
            System.out.println("start r: " + r + ", i: " + i + ", m:" + multiplier);
            r = r * multiplier;
            r = r + (i % multiplier);
            i = i / multiplier;
            System.out.println("end r: " + r + ", i: " + i);
        } while (i != 0);*/

        //System.out.println(i % 10);
        //System.out.println(i / 10);
    }

    public static boolean palindromeInt(int x) {
        if (x < 0) return false;
        int i = x;
        int r = 0;
        int multiplier = 10;
        do {
            //System.out.println("start r: " + r + ", i: " + i + ", m:" + multiplier);
            r = r * multiplier;
            r = r + (x % multiplier);
            x = x / multiplier;
            //System.out.println("end r: " + r + ", i: " + i);
        } while (x != 0);
        return r - i == 0;
    }

    public static boolean palindromeIntByString(int num) {
        String start = Integer.toString(num);
        String reversed = new StringBuilder(start).reverse().toString();
        return start.equals(reversed);
    }

}
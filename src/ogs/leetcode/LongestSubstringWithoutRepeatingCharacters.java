package ogs.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
     * Input: s = "pwwkew","dvdf", "anviaj", "abcabcbb"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a
     * substring.
     */
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        String s = "anviaj"; 
        //5 потому что вторая подстрока - то есть надо возвращаться не на предыдущие ближайшие значения, 
        //а на позицию после начала текущей подстроки!!
        int i = l.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        // идем по массиву
        // считаем количество букв и запоминаем их в коллекцию
        // если уже есть в коллекции, то запоминаем текущее значение счетчика и обнуляем
        // все, начаинаем заново с места остановки.
        //проблема - если повторки не подряд - то забываем один счет. Надо чекать, что было до постора и менять позицию либо на 1 символ либо на 2
        int globalCounter = 0;
        final Set<Character> alreadyBeenChar = new HashSet<>();

        char[] kek = s.toCharArray();
        int c = 0;
        for (int i = 0; i < kek.length; i++) {
            System.out.println("i=" + i);
            boolean resOfAdd = alreadyBeenChar.add(kek[i]);
            if (!resOfAdd) {
                if (globalCounter < c) {
                    globalCounter = c;
                }
                alreadyBeenChar.clear();
                if (kek[i] == (kek[i-1])) {   //ArrayOutOfBound? 
                    i--;    
                } else {
                    i--;
                    i--;
                }
                c = 0;
                System.out.println("gCount=" + globalCounter + ", i=" + i);
                continue;
            }
            c++;
            System.out.println("Char:" + kek[i] + ", local counter=" + c);
        }

        return globalCounter < c ? c : globalCounter;
    }
}

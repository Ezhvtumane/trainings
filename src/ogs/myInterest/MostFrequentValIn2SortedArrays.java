package ogs.myInterest;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentValIn2SortedArrays {

    /*
     * Найти, сколько раз встречается самый частый элемент в объединении двух отсортированных по возрастанию массивов.
     * Элементы могут повторяться.
     * */
    public static void main(String[] args) {
        System.out.println("Hello Java");
        MostFrequentValIn2SortedArrays code = new MostFrequentValIn2SortedArrays();
        int[] first = {1, 2, 2, 3};
        int[] second = {3, 3, 4, 5};
        System.out.println(code.getElement(first, second));
    }

    private int getElement(int[] arr1, int[] arr2) {
        final Map<Integer, Integer> fin = new HashMap<>();
        int countFirst = 0;
        int countSecond = 0;
        while (countFirst < arr1.length) {
            int first = arr1[countFirst];
            putToMap(fin, first);
            countFirst++;
        }
        while (countSecond < arr2.length) {
            int second = arr2[countSecond];
            putToMap(fin, second);
            countSecond++;
        }
        int count = 0;
        for (int i = 0; i < fin.values().size(); i++) {
            if (fin.get(i) > count) {
                count = fin.get(i);
            }
        }
        return count;
    }

    private void putToMap(Map<Integer, Integer> fin, int element) {
        Integer curr = fin.get(element);
        if (curr == null) {
            fin.put(element, 1);
        } else {
            fin.put(element, curr++);
        }
    }
}

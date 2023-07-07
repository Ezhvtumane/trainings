package ogs.myInterest;

public class MergeTwoSortedArrays {

    /*
     * You have 2 sorted arrays by ascending.
     * Merge them.
     */

    public static void main(String[] args) {
        int[] first = {1, 2, 2, 3};
        int[] second = {3, 3, 4, 5};
        int[] res = mergeSortedArrays();
        for (int i : res) {
            System.out.println(i + "\n");
        }
    }

    private static int[] mergeSortedArrays() {
        int[] first = {1, 2, 2, 3, 4, 5, 6, 7};
        int[] second = {3, 4, 5, 6, 7};
        int[] res = new int[first.length + second.length];

        int fCounter = 0;
        int sCounter = 0;
        for (int globalCounter = 0; globalCounter < first.length + second.length; globalCounter++) {
            if (fCounter >= first.length) {
                res[globalCounter] = second[sCounter];
                sCounter++;
                continue;
            }
            if (sCounter >= second.length) {
                res[globalCounter] = first[fCounter];
                fCounter++;
                continue;
            }

            int f = first[fCounter];
            int s = second[sCounter];

            if (f < s) {
                res[globalCounter] = f;
                fCounter++;
            } else if (f > s) {
                res[globalCounter] = s;
                sCounter++;
            } else {
                res[globalCounter] = f;
                fCounter++;
            }
        }
        return res;
    }

}

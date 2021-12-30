package ogs.myInterest;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TryCatchFinally kek = new TryCatchFinally();
        kek.kek();
        /*

        OuterSort os = new OuterSort();
        os.init();
        int[] bigArray = {6, 5, 8, 4, 9, 2, 3, 1, 7, 0, 11, 34};//new int[10];//
        *//*Random random = new Random();
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = random.nextInt();
        }*//*
        int[] kek = os.sort(bigArray);
        for (int k : kek) {
            System.out.print(k + ", ");
        }
        int memLimit = 6;
        int[] mem = new int[memLimit];

        int k = (int) Math.ceil(bigArray.length / memLimit);
        int[][] arrayOfArrays = new int[k][memLimit];
        int counterCol = 0;
        int counterRow = 0;
        for (int i = 0; i < bigArray.length; i++) {
            if (i != 0 && i % (memLimit) == 0) {
                counterCol++;
                counterRow -= memLimit;
            }
            arrayOfArrays[counterCol][counterRow] = bigArray[i];
            counterRow++;
        }

        int[][] sortedArrays = new int[k][memLimit];

        for (int i = 0, j = 1; i <= k / 2 && j <= k; i += 2, j += 2) {//only for chetnie
            int[] first = arrayOfArrays[i];
            int[] second = arrayOfArrays[j];
            sortedArrays[i] = os.sort(first);
            sortedArrays[j] = os.sort(second);
        }

        int[] one = new int[memLimit / 2];
        int[] two = new int[memLimit / 2];
        int[] three = new int[memLimit / 2];
        int[] four = new int[memLimit / 2];
        for (int i = 0; i < memLimit / 2; i++) {
            one[i] = sortedArrays[0][i];
            two[i] = sortedArrays[0][i + (memLimit / 2)];
            three[i] = sortedArrays[1][i];
            four[i] = sortedArrays[1][i + (memLimit / 2)];
        }
        int[] fiveSix = os.sliceByAsc(one, three);
        int[] sevenEight = os.sliceByAsc(two, four);

        int[] five = new int[memLimit / 2];
        int[] six = new int[memLimit / 2];
        int[] seven = new int[memLimit / 2];
        int[] eight = new int[memLimit / 2];

        for (int i = 0; i < memLimit / 2; i++) {
            five[i] = fiveSix[i];
            six[i] = fiveSix[i + (memLimit / 2)];
            seven[i] = sevenEight[i];
            eight[i] = sevenEight[i + (memLimit / 2)];
        }

        int[] middle = os.sliceByAsc(six, seven);

        int[] result = os.slice(five, os.slice(middle, eight));

        for (int ka : result) {
            System.out.print(ka + ", ");
        }
*/

    }

}

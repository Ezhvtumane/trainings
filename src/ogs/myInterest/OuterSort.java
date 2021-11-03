package ogs.myInterest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OuterSort {
    private int[] bigArray = new int[10];
    private Random random = new Random();

    public void init() {
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = random.nextInt();
        }
    }

    public int[] slice(int[] left, int[] right) {
        int[] slicedAscArray = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < left.length) {
            slicedAscArray[i] = left[l];
            l++;
            i++;
        }
        while (r < right.length) {
            slicedAscArray[i] = right[r];
            r++;
            i++;
        }
        return slicedAscArray;
    }

    public int[] sliceByAsc(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] slicedAscArray = new int[leftLength + rightLength];
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < leftLength && r < rightLength) {
            if (left[l] < right[r]) {
                slicedAscArray[i] = left[l];
                l++;
            } else {
                slicedAscArray[i] = right[r];
                r++;
            }
            i++;
        }
        while (l < leftLength) {
            slicedAscArray[i] = left[l];
            l++;
            i++;
        }
        while (r < rightLength) {
            slicedAscArray[i] = right[r];
            r++;
            i++;
        }
        return slicedAscArray;
    }

    public int[] sort(int[] innerArray) {
        if (innerArray.length == 1 || innerArray.length == 0) {
            return innerArray;
        } else if (innerArray.length == 2) {
            if (innerArray[0] < innerArray[1]) {
                return new int[]{innerArray[0], innerArray[1]};
            } else {
                return new int[]{innerArray[1], innerArray[0]};
            }
        } else {
            int middle = innerArray.length / 2;
            int[] left = new int[middle];
            int[] right = new int[innerArray.length - middle];
            for (int i = 0; i < middle; i++) {
                left[i] = innerArray[i];
            }
            for (int i = 0; i < innerArray.length - middle; i++) {
                right[i] = innerArray[middle + i];
            }
            int[] sortedLeft = sort(left);
            int[] sortedRight = sort(right);
            return sliceByAsc(sortedLeft, sortedRight);
        }
    }


}

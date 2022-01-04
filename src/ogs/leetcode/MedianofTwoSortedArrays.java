package ogs.leetcode;

public class MedianofTwoSortedArrays {

    /*
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
     * the median of the two sorted arrays.
     * 
     * The overall run time complexity should be O(log (m+n)).
     */

    /*
     * Т.е. такое значение, которое после сортировки массива A[1...n] будет равно:
     * элементу A[n / 2 + 1], при нечетном n и (A[n / 2] + A[n / 2 + 1]) / 2.0, при
     * четном n.
     */
    public static void main(String[] args) {
        MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3 };
        int[] arr = { 1, 8, 3 };
        m.findMedianSortedArrays(nums1, nums2);

        // System.arraycopy(src, srcPos, dest, destPos, length);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sortedSlicedArr = sliceByAsc(nums1, nums2);
        return findMedianOfSortedArray(sortedSlicedArr);
    }

    private double findMedianOfSortedArray(int[] inputArr) {
        if (inputArr.length % 2 == 0) {
            int firstIndex = (inputArr.length / 2) - 1;
            int secondIndex = (inputArr.length / 2);
            return (inputArr[firstIndex] + inputArr[secondIndex]) / 2.0;
        } else {
            int medianIndex = inputArr.length / 2;
            return inputArr[medianIndex];
        }
    }

    private int[] sliceByAsc(int[] left, int[] right) {
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

}

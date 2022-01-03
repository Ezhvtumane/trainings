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
        int[] nums1 = null;
        int[] nums2 = null;
        m.findMedianSortedArrays(nums1, nums2);

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       return 0.0;
    }

}

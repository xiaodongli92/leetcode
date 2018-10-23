package com.leetcode.main;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 不同时为空。
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class TwoArraysMidNum {

    public static void main(String[] args) {
        TwoArraysMidNum twoArraysMidNum = new TwoArraysMidNum();
        int[] nums1 = new int[] {1};
        int[] nums2 = new int[] {};

        System.out.println(twoArraysMidNum.findMedianSortedArrays2(nums1, nums2));
    }

    /**
     * 两个数组从前往后遍历 到中间值停止
     * o (log(m+n))
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int lengthAll = length1 + length2;
        int idx1 = 0;
        int idx2 = 0;
        int midVal1 = -1;
        int midVal2 = -1;
        while (idx1 + idx2 < lengthAll) {
            if (idx1 < length1) {
                while (idx2 == length2 || nums1[idx1] <= nums2[idx2]) {
                    idx1 ++;
                    if (idx1 + idx2 == (lengthAll + 1) / 2) {
                        midVal1 = nums1[idx1 - 1];
                    }
                    if (idx1 + idx2 == (lengthAll + 2) / 2) {
                        midVal2 = nums1[idx1 - 1];
                        return (midVal1 + midVal2) * 1.0 / 2;
                    }
                    if (idx1 == length1) {
                        break;
                    }
                }
            }
            if (idx2 < length2) {
                while (idx1 == length1 || nums2[idx2] <= nums1[idx1]) {
                    idx2 ++;
                    if (idx1 + idx2 == (lengthAll + 1) / 2) {
                        midVal1 = nums2[idx2 - 1];
                    }
                    if (idx1 + idx2 == (lengthAll + 2) / 2) {
                        midVal2 = nums2[idx2 - 1];
                        return (midVal1 + midVal2) * 1.0 / 2;
                    }
                    if (idx2 == length2) {
                        break;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 两个数组合并为一个新的有序数组
     * 复杂度o(m + n)
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int allLength = length1 + length2;
        int[] allArr = new int[allLength];
        int k = 0, i=0, j=0;
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                allArr[k++] = nums1[i];
                i++;
            } else {
                allArr[k++] = nums2[j];
                j++;
            }
        }
        while (i < length1) {
            allArr[k++] = nums1[i++];
        }
        while (j < length2) {
            allArr[k++] = nums2[j++];
        }
        if (allLength % 2 == 1) {//奇数
            return allArr[allLength / 2] * 1.0;
        } else {//偶数
            int mid = allLength / 2;
            return (allArr[mid-1] + allArr[mid]) * 1.0 / 2;
        }
    }
}

package com.leetcode.main;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch1(arr, 0, arr.length-1, 5));
        System.out.println(binarySearch2(arr, 5));
    }

    /**
     * 非递归方式
     */
    public static int binarySearch2(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归方式
     * 时间复杂度 log n
     */
    public static int binarySearch1(int[] arr, int start, int end, int target) {
        if (start < end) {
            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target > arr[mid]) {
                return binarySearch1(arr, mid + 1, end, target);
            }
            return binarySearch1(arr, start, mid - 1, target);
        }
        return -1;
    }
}

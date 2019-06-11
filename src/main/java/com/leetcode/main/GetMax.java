package com.leetcode.main;

/**
 * 先升后降的数组求最大值
 */
public class GetMax {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 4, 3, 2, 1};
        System.out.println(getMax1(arr, 0, arr.length - 1));
        System.out.println(getMax2(arr));
    }

    private static int getMax2(int[] arr) {
        int start = 0, end = arr.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid] > arr[mid - 1] && arr[mid + 1] > arr[mid]) {
                start = mid + 1;
            } else if (arr[mid] < arr[mid - 1] && arr[mid + 1] < arr[mid]) {
                end = mid - 1;
            }
        }
        if (start == end) {
            return arr[start];
        }
        return 0;
    }

    private static int getMax1(int[] arr, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                if (mid - 1 >= start) {
                    if (arr[mid - 1] > arr[mid]) {
                        end = mid - 1;
                    } else if (arr[mid - 1] < arr[mid]) {
                        start = mid;
                    } else {
                        int max1 = getMax1(arr, start, mid - 1);
                        int max2 = getMax1(arr, mid + 1, end);
                        return Math.max(max1, max2);
                    }
                } else {
                    return arr[start];
                }
            }
        }
        return arr[start];
    }

}

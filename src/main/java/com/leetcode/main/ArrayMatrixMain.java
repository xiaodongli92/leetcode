package com.leetcode.main;

import java.util.Arrays;

/**
 * 数组和矩阵
 */
public class ArrayMatrixMain {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 4};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        int[][] table = new int[][] {{1, 2}, {3, 4}};
        int[][] result = matrixReshape(table, 4, 4);
        for (int[] item:result) {
            System.out.println(Arrays.toString(item));
        }
        System.out.println();

        int[] arr1 = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr1));
        System.out.println();

        int[] arr2 = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(arr2)));
        System.out.println();

        int[] arr3 = {1,3,4,2,2};
        System.out.println(findDuplicate(arr3));
        System.out.println(findDuplicate1(arr3));
        System.out.println();

    }

    private static int findDuplicate1(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        return slow;
    }

    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
     * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     */
    private static int findDuplicate(int[] nums) {
        int i = 1, j =nums.length-1;
        while (i <= j) {
            int mid = i + (j-i) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    /**
     * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
     * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     */
    private static int[] findErrorNums(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        for (int item:nums) {
            arr[item-1] ++;
        }
        int[] result = new int[2];
        for (int i=0; i<length; i++) {
            if (arr[i] == 2) {
                result[0] = i+1;
            }
            if (arr[i] == 0) {
                result[1] = i+1;
            }
        }
        return result;
    }

    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     */
    private static int findMaxConsecutiveOnes(int[] arr) {
        int maxLength = 0;
        int tempLength = 0;
        for (int item : arr) {
            if (1 == item) {
                tempLength++;
            } else {
                maxLength = maxLength > tempLength ? maxLength : tempLength;
                tempLength = 0;
            }
        }
        return maxLength > tempLength ? maxLength : tempLength;
    }

    /**
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     */
    private static int[][] matrixReshape(int[][] arr, int r, int c) {
        int row = arr.length;
        int col = arr[0].length;
        if (row * col != r * c) {
            return arr;
        }
        int[][] result = new int[r][c];
        int index = 0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                result[i][j] = arr[index / row][index % row];
                index++;
            }
        }
        return result;
    }

    /**
     * 将0移动到末尾
     */
    private static void moveZeros(int[] arr) {
        int i = 0;
        for (int item:arr) {
            if (0 != item) {
                arr[i++] = item;
            }
        }
        while (i < arr.length) {
            arr[i++] = 0;
        }
    }
}

package com.leetcode.main;

import java.util.Arrays;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 */
public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        new DuplicateZeros().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {0, 0, 0, 0, 0, 0, 0};
        new DuplicateZeros().duplicateZeros(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public void duplicateZeros(int[] arr) {
        int j;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                j = arr.length - 1;
                while (j > i + 1) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[i + 1] = 0;
                i += 1;
            }
        }
    }
}

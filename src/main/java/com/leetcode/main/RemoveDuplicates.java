package com.leetcode.main;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除排序数组中的重复项
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int size = removeDuplicates1(arr);
        System.out.println(size);
        for (int i=0; i<size; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private static int removeDuplicates1(int[] nums) {
        int i=0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    private static int removeDuplicates(int[] nums) {
        int start = 0, end = nums.length - 1;
        Set<Integer> set = new HashSet<>();
        int temp;
        while (start <= end) {
            if (set.contains(nums[start])) {
                temp = nums[start];
                System.arraycopy(nums, start + 1, nums, start, end - start);
                nums[end] = temp;
                end --;
            } else {
                set.add(nums[start]);
                start ++;
            }
        }
        return set.size();
    }
}

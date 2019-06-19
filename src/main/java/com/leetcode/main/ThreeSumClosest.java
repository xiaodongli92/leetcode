package com.leetcode.main;

/**
 * 最接近的三数之和
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

    private static int threeSumClosest(int[] nums, int target) {
        quickSort(nums, 0, nums.length-1);
        int closestTarget = nums[0] + nums[1] + nums[2];
        for (int i = 0; i< nums.length-2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - closestTarget)) {
                    closestTarget = sum;
                }
                if (sum > target) {
                    end --;
                } else if (sum < target) {
                    start ++;
                } else {
                    return target;
                }
            }
        }
        return closestTarget;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = getMid(nums, start, end);
            quickSort(nums, start, mid - 1);
            quickSort(nums, mid + 1, end);
        }
    }

    private static int getMid(int[] nums, int start, int end) {
        int firstValue = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= firstValue) {
                end --;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= firstValue) {
                start ++;
            }
            nums[end] = nums[start];
        }
        nums[start] = firstValue;
        return start;
    }
}

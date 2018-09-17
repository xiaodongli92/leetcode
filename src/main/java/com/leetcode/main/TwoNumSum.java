package com.leetcode.main;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * nums = [2, 7, 11, 15], target = 9
 * nums[0] + nums[1] = 2 + 7 = 9
 */
public class TwoNumSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 7, 15};
        int sum = 14;
        int[] twoNum = twoSum2(nums, sum);
        if (null == twoNum) {
            System.out.println("not has");
            return;
        }
        System.out.println(twoNum[0] + "\t" + twoNum[1]);
    }

    private static int[] twoSum1(int[] arr, int sum) {
        int count = 0;
        for (int i=0; i<arr.length - 1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                count ++;
                if (arr[i] + arr[j] == sum) {
                    System.out.println("遍历次数:" + count);
                    return new int[]{i ,j};
                }
            }
        }
        return null;
    }

    private static int[] twoSum2(int[] nums, int target) {
        int count = 0;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i=0; i<length; i++) {
            count ++;
            map.put(nums[i], i);
        }
        int temp;
        for (int i=0; i<length; i++) {
            temp = target - nums[i];
            count ++;
            if (map.containsKey(temp) && i!=map.get(temp)) {
                System.out.println("遍历次数:" + count);
                return new int[]{i, map.get(temp)};
            }
        }
        return null;
    }
}

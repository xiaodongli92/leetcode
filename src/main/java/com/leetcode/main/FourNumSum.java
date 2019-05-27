package com.leetcode.main;

import java.util.*;

public class FourNumSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 0, -1, 0, -2, 2};
        System.out.println(new FourNumSum().fourSum(nums, 0));
    }

    private List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (map.containsKey(sum)) {
                    map.get(sum).add(new Integer[]{i, j});
                } else {
                    List<Integer[]> temp = new ArrayList<>();
                    temp.add(new Integer[]{i, j});
                    map.put(sum, temp);
                }
            }
        }
        for (Integer item : map.keySet()) {
            if (map.containsKey(target - item)) {
                List<Integer[]> list1 = map.get(item);
                List<Integer[]> list2 = map.get(target - item);
                for (Integer[] pair1:list1) {
                    int index1 = pair1[0];
                    int index2 = pair1[1];
                    for (Integer[] pair2:list2) {
                        int index3 = pair2[0];
                        int index4 = pair2[1];
                        if (index3 > index2) {
                            result.add(Arrays.asList(nums[index1], nums[index2], nums[index3], nums[index4]));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}

package com.leetcode.main;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs1(4));
        System.out.println(new ClimbStairs().climbStairs2(4));
        System.out.println(new ClimbStairs().climbStairs3(4));
        System.out.println(new ClimbStairs().climbStairs4(4));
    }

    /**
     * 斐波那契数
     * 时间复杂度 n
     * 空间复杂度 1
     */
    private int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1, second = 2;
        for (int i=3; i<=n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 动态规划 dp[i] = dp[i - 1] + dp[i + 1]
     * 时间复杂度 n
     * 空间复杂度 n
     */
    private int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i=3; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    /**
     * 缓存递归
     * 时间复杂度 n
     * 空间复杂度 n
     */
    private int climbStairs2(int n) {
        int[] cache = new int[n+1];
        return climbStairs2(0, n, cache);
    }

    private int climbStairs2(int i, int n, int[] cache) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (cache[i] > 0) {
            return cache[i];
        }
        cache[i] = climbStairs2(i + 1, n, cache) + climbStairs2(i + 2, n, cache);
        return cache[i];
    }

    /**
     * 暴力递归
     * 时间复杂度 2^n
     */
    private int climbStairs1(int n) {
        return climbStairs1(0, n);
    }

    private int climbStairs1(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs1(i + 1, n) + climbStairs1(i + 2, n);
    }
}

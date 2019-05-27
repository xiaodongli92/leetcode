package com.leetcode.main;

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(new IntToRoman().intToRoman(1994));
    }

    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<values.length; i++) {
            int temp = num / values[i];
            if (temp == 0) {
                continue;
            }
            for (int j=temp; j>0; j--) {
                builder.append(strs[i]);
            }
            num -= temp * values[i];
            if (num == 0) {
                break;
            }
        }
        return builder.toString();
    }
}

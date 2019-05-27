package com.leetcode.main;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("LVIII"));
        System.out.println(new RomanToInt().romanToInt1("LVIII"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result = 0;
        int current = 0;
        int next = 0;
        for (int i=0; i<s.length()-1; i++) {
            current = map.get(s.charAt(i));
            next = map.get(s.charAt(i+1));
            if (next / current == 5 || next / current == 10) {
                result -= current;
            } else {
                result += current;
            }
        }
        result += map.get(s.charAt(s.length()-1));
        return result;
    }
    public int romanToInt1(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        for(int j = 0; j < s.length() - 1; j++) {
            switch("" + s.charAt(j) + s.charAt(j+1)) {
                case "IV":
                case "IX":
                    result -= 2;
                    break;
                case "XL":
                case "XC":
                    result -= 20;
                    break;
                case "CD":
                case "CM":
                    result -= 200;
                    break;
            }
        }
        return result;
    }
}

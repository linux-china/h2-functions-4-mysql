package org.mvnsearch.h2.mysql;

import java.util.Stack;

/**
 * math functions
 *
 * @author linux_china
 */
public class MathFunctions {

    private static char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static String numStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static Double pow(Double a, Double b) {
        return Math.pow(a, b);
    }

    public static String conv(String text, Integer originBase, Integer targetBase) {
        String sign = "";
        if (text.startsWith("-")) {
            sign = "-";
        }
        long number = N_to_10(text.replace("-", ""), originBase);
        return sign + _10_to_N(number, targetBase);
    }

    public static String _10_to_N(long number, int N) {
        long rest = number;
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder(0);
        while (rest != 0) {
            stack.add(array[new Long((rest % N)).intValue()]);
            rest = rest / N;
        }
        for (; !stack.isEmpty(); ) {
            result.append(stack.pop());
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static long N_to_10(String number, int N) {
        char ch[] = number.toCharArray();
        int len = ch.length;
        long result = 0;
        if (N == 10) {
            return Long.parseLong(number);
        }
        long base = 1;
        for (int i = len - 1; i >= 0; i--) {
            int index = numStr.indexOf(ch[i]);
            result += index * base;
            base *= N;
        }
        return result;
    }

}

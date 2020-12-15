package com.xd.leetcode.solutions;

/**
 *给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

 （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

 示例 1:

 输入: N = 10
 输出: 9
 示例 2:

 输入: N = 1234
 输出: 1234
 示例 3:

 输入: N = 332
 输出: 299
 说明: N 是在 [0, 10^9] 范围内的一个整数。

 */

public class _738_MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] arr = String.valueOf(N).toCharArray();
        int flag = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i-1] > arr[i]) {
                arr[i-1] -= 1;
                flag = i;
                System.out.printf("arr:%s flag:%d\n", new String(arr), flag);
            }
        }
        for (int j = flag; j < arr.length; j++) {
            arr[j] = '9';
        }
        return Integer.parseInt(new String(arr));
    }

     //

    /**
     * 暴力解法超时
     */
    public int monotoneIncreasingDigitsBF(int N) {
        for (int i = N; i > 0; i--) {
            String s = String.valueOf(i);
            boolean isIncrease = true;
            for (int j = s.length()-1; j > 0; j--) {
                if ((int)s.charAt(j) < (int)s.charAt(j-1)) {
                    isIncrease = false;
                    break;
                }
            }
            if (isIncrease) {
                return i;
            }
        }
        return 0;
    }
}

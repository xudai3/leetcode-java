package com.xd.leetcode.solutions;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *  
 * 示例 1:
 *
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 *
 * 示例 2:
 *
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 *
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *  
 * 提示：
 *
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <= 231 - 1
 *
 */

public class _455_AssignCookies {
    /**
     * 从胃口最小的孩子开始，最小的饼干开始尝试是否能够满足，不能则换下一个大的饼干
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren2(int[] g, int[] s) {
        int numOfChild = g.length;
        int numOfCookie = s.length;
        int cnt = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int j = 0; cnt < numOfChild && j < numOfCookie; j++) {
            if (g[cnt] <= s[j]) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * 从最大的饼干开始，最大胃口的孩子开始尝试，如果不能满足则换下一个胃口小的孩子
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren3(int[] g, int[] s) {
        int numOfChild = g.length;
        int numOfCookie = s.length;
        int cnt = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = numOfChild - 1, j = numOfCookie - 1; i >= 0 && j >= 0; i--) {
            if (g[i] <= s[j]) {
                cnt++;
                j--;
            }
        }
        return cnt;
    }

    /**
     * 从最小的孩子开始，找到最小适合他胃口的饼干，能找到则cnt++
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int numOfChild = g.length;
        int numOfCookie = s.length;
        int cnt = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < numOfChild && j < numOfCookie; i++, j++) {
            while (j < numOfCookie && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookie) {
                cnt++;
            }
        }
        return cnt;
    }
}

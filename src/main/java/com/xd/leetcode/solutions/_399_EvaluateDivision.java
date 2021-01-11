package com.xd.leetcode.solutions;

import java.util.HashMap;
import java.util.List;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 示例 2：
 *
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 *
 * 示例 3：
 *
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 *  
 *
 * 提示：
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 *
 */
public class _399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationLen = equations.size();
        int queryLen = queries.size();
        UnionFind uf = new UnionFind(2 * equationLen);
        HashMap<String, Integer> hash = new HashMap<>(2 * equationLen);
        double[] result = new double[queryLen];
        int idx = 0;
        for (int i = 0; i < equationLen; i++) {
            String str1 = equations.get(i).get(0);
            String str2 = equations.get(i).get(1);
            if (!hash.containsKey(str1)) {
                hash.put(str1, idx);
                idx++;
            }
            if (!hash.containsKey(str2)) {
                hash.put(str2, idx);
                idx++;
            }
            uf.union(hash.get(str1), hash.get(str2), values[i]);
        }
        for (int i = 0; i < queryLen; i++) {
            String str1 = queries.get(i).get(0);
            String str2 = queries.get(i).get(1);
            if (!hash.containsKey(str1) || !hash.containsKey(str2)) {
                result[i] = -1.0d;
            } else {
                result[i] = uf.isConnected(hash.get(str1), hash.get(str2));
            }
        }
        return result;
    }
    private class UnionFind {
        private int[] parent;
        private double[] weight;
        public UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }
        public void union(int p, int q, double val) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            weight[rootP] = weight[q] * val / weight[p];
        }
        public int find(int x) {
            if (parent[x] != x) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }
        public double isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return weight[p] / weight[q];
            } else {
                return -1.0d;
            }
        }
    }
}

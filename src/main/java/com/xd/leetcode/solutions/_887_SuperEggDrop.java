package com.xd.leetcode.solutions;

import java.util.HashMap;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * <p>
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * <p>
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * <p>
 * 你的目标是确切地知道 F 的值是多少。
 * <p>
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 * <p>
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：K = 3, N = 14
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= 100
 * 1 <= N <= 10000
 */
public class _887_SuperEggDrop {

    public int superEggDrop5(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int n = 1; n <= N; n++) {
            dp[0][n] = 0;
            for (int k = 1; k <= K; k++) {
                dp[k][n] = dp[k][n - 1] + dp[k - 1][n - 1] + 1;
                if (dp[k][n] >= N) {
                    return n;
                }
            }
        }
        return N;
    }

    public int superEggDrop4(int K, int N) {
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = i;
        }

        for (int k = 2; k <= K; k++) {
            int[] dp2 = new int[N + 1];
            int x = 1;
            for (int n = 1; n <= N; n++) {
                while (x < n && Math.max(dp[x-1], dp2[n-x]) > Math.max(dp[x], dp2[n-x-1]))
                    x++;
                dp2[n] = 1 + Math.max(dp[x-1], dp2[n-x]);
            }
            dp = dp2;
        }
        return dp[N];
    }
    /**
     * (N, K) = 1<=x<=N min(max((x-1,K-1),(N-x,K))+1)
     * t1 = (x-1,K-1) t2 = (N-x,K) t1随着x单调递增 t2随着x单调递减 交点(离散的不一定相交)就是两者最小的最大值
     * 可以用二分法找到x满足 max(t1,t2)最小
     * @param K
     * @param N
     * @return
     */
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int superEggDrop3(int K, int N) {
        if (K == 1 || N == 0 || N == 1) {
            return N;
        }
        Integer key = N * 1000 + K;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int l = 1;
        int r = N;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int t1 = superEggDrop3(K - 1, mid - 1);
            int t2 = superEggDrop3(K, N - mid);
            if (t1 == t2) {
                l = r = mid;
            } else if (t1 < t2) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int min = 1 + Math.min(
                Math.max(superEggDrop3(K - 1, l - 1), superEggDrop3(K, N - l)),
                Math.max(superEggDrop3(K - 1, r - 1), superEggDrop3(K, N - r))
        );
        memo.put(N * 1000 + K, min);
        return memo.get(N * 1000 + K);
    }

    public int superEggDrop2(int K, int N) {
        if (K == 1 || N == 0 || N == 1) {
            return N;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int i = 1; i <= K; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int l = 1;
                int r = i;
                while (l < r) {
                    int mid = (l + r) >>> 1;
                    int t1 = dp[mid - 1][j - 1];
                    int t2 = dp[i - mid][j];
                    if (t1 == t2) {
                        l = r = mid;
                    } else if (t1 < t2) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                dp[i][j] = Math.max(dp[l - 1][j - 1], dp[i - l][j]) + 1;
            }
        }
        return dp[N][K];
    }

    public int superEggDrop(int K, int N) {
        if (K == 1 || N == 0 || N == 1) {
            return N;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int i = 1; i <= K; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = N;
                for (int x = 1; x <= i; x++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[x - 1][j - 1], dp[i - x][j]) + 1);
                }
            }
        }
        return dp[N][K];
    }
}

package com.xd.leetcode.solutions;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 */
public class _74_SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < m - 1 && j < n - 1) {
            if (matrix[i][j] == target) {
                return true;
            }
            int right = matrix[i][j+1];
            if (target < right) {
                return false;
            }
            int down = matrix[i+1][j];
            if (down <= target) {
                i++;
            } else {
                j++;
            }
        }
        if (matrix[i][j] == target) {
            return true;
        } else {
            return false;
        }
    }
}

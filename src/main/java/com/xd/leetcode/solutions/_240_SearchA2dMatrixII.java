package com.xd.leetcode.solutions;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 *
 */
public class _240_SearchA2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        if (rowLen == 0) {
            return false;
        }
        int colLen = matrix[0].length;
        if (colLen == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[rowLen-1][colLen-1]) {
            return false;
        }
        int i = 0;
        int j = colLen - 1;
        while (i < rowLen && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            }
        }
        return false;
    }
}

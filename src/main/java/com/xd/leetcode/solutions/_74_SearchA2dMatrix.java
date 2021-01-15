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

    /**
     * 这个升序规律可以看成升序的一维数组进行二分查找
     * row = idx / n
     * col = idx % n
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
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
        int left = 0;
        int right = rowLen * colLen - 1;
        while (left <= right) {
            int pivot = left + ((right - left) >> 1);
            int row = pivot / colLen;
            int col = pivot % colLen;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return false;
    }


    /**
     * 从左到右，从上到下都是越来越大，所以从右上角开始，如果matrix[i][j]小于target则i++，大于则j--
     * @param matrix
     * @param target
     * @return
     */
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

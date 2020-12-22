package com.xd.leetcode.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */

public class _102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            queue1.add(root);
        }
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                result.add(levelTraversal(queue1, queue2));
            }
            if (!queue2.isEmpty()) {
                result.add(levelTraversal(queue2, queue1));
            }
        }
        return result;
    }
    public List<Integer> levelTraversal(LinkedList<TreeNode> queue1, LinkedList<TreeNode> queue2) {
        List<Integer> levelResult = new ArrayList<>();
        while(!queue1.isEmpty()) {
            TreeNode top = queue1.removeFirst();
            levelResult.add(top.val);
            if (top.left != null) {
                queue2.addLast(top.left);
            }
            if (top.right != null) {
                queue2.addLast(top.right);
            }
        }
        return levelResult;
    }
}

package com.xd.leetcode.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            queue1.add(root);
        }
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                result.add(leftToRight(queue1, queue2));
            }
            if (!queue2.isEmpty()) {
                result.add(rightToLeft(queue2, queue1));
            }
        }
        return result;
    }

    public List<Integer> leftToRight(LinkedList<TreeNode> queue1, LinkedList<TreeNode> queue2) {
        List<Integer> levelResult = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode top = queue1.removeFirst();
            levelResult.add(top.val);
            if (top.left != null) {
                queue2.addFirst(top.left);
            }
            if (top.right != null) {
                queue2.addFirst(top.right);
            }
        }
        return levelResult;
    }
    public List<Integer> rightToLeft(LinkedList<TreeNode> queue1, LinkedList<TreeNode> queue2) {
        List<Integer> levelResult = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode top = queue1.removeFirst();
            levelResult.add(top.val);
            if (top.right != null) {
                queue2.addFirst(top.right);
            }
            if (top.left != null) {
                queue2.addFirst(top.left);
            }
        }
        return levelResult;
    }
}

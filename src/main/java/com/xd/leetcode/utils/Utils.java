package com.xd.leetcode.utils;

import com.xd.leetcode.solutions.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Utils {
    public TreeNode buildTree(Integer[] treeNodeVals) {
        int n = treeNodeVals.length;
        int idx = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(treeNodeVals[idx++]);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.removeFirst();
            if (idx < n) {
                Integer leftVal = treeNodeVals[idx++];
                if (leftVal != null) {
                    TreeNode left = new TreeNode(leftVal);
                    top.left = left;
                    queue.addLast(left);
                }
            }
            if (idx < n) {
                Integer rightVal = treeNodeVals[idx++];
                if (rightVal != null) {
                    TreeNode right = new TreeNode(rightVal);
                    top.right = right;
                    queue.addLast(right);
                }
            }
        }
        return root;
    }

    public boolean twoDArrayListEquals(List<List<Integer>> list1, List<List<Integer>> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}

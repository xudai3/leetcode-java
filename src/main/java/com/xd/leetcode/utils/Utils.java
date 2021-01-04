package com.xd.leetcode.utils;

import com.xd.leetcode.solutions.ListNode;
import com.xd.leetcode.solutions.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Utils {
    public ListNode buildSinglyLinkedList(int[] vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode p = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode node = new ListNode(vals[i]);
            p.next = node;
            p = p.next;
        }
        p.next = null;
        return head;
    }

    public void printLinkedList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.printf("%d->", p.val);
            p = p.next;
        }
        System.out.println("null");
    }

    public boolean linkedListEquals(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null && p2 == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean intArrayEquals(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }

    public String intArrayToString(int[] nums) {
        String str = "";
        for (int num : nums) {
            str += num;
        }
        return str;
    }

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

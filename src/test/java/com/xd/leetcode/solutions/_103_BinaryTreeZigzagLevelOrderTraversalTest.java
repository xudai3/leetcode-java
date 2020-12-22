package com.xd.leetcode.solutions;

import com.xd.leetcode.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _103_BinaryTreeZigzagLevelOrderTraversalTest {
    _103_BinaryTreeZigzagLevelOrderTraversal b;
    Utils util;

    public _103_BinaryTreeZigzagLevelOrderTraversalTest() {
        b = new _103_BinaryTreeZigzagLevelOrderTraversal();
        util = new Utils();
    }

    @Test
    void zigzagLevelOrder() {
        TreeNode root = util.buildTree(new Integer[]{1,2,3,4,null,null,5});
        System.out.println(b.zigzagLevelOrder(root));
    }
}
package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _448_FindDisappearedNumbersTest {
    @Test
    void findDisappearedNumbers() {
        int[] input = {4,3,2,7,8,2,3,1};
        _448_FindDisappearedNumbers fdn = new _448_FindDisappearedNumbers();
        List<Integer> result = fdn.findDisappearedNumbers(input);
        System.out.println(result);
    }

}
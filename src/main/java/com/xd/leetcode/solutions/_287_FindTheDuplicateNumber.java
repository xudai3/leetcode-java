package com.xd.leetcode.solutions;

/**
 287. 寻找重复数
 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

 示例 1:
 输入: [1,3,4,2,2]
 输出: 2

 示例 2:
 输入: [3,1,3,4,2]
 输出: 3

 说明：
 不能更改原数组（假设数组是只读的）。
 只能使用额外的 O(1) 的空间。
 时间复杂度小于 O(n2) 。
 数组中只有一个重复的数字，但它可能不止重复出现一次。
 通过次数73,185提交次数111,647

 */

public class _287_FindTheDuplicateNumber {
    /**
     * 每个位置i连一条指向nums[i]的边，由于存在重复数字，就至少存在两条指向它的边
     * 因此整张图一定存在环，转化成寻找环的入口的问题
     * */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {break;}
        }
        int detect = nums[0];
        while (detect != slow) {
            slow = nums[slow];
            detect = nums[detect];
        }
        return detect;
    }

    /**
     * 抽屉原理：桌上有十个苹果，要把这十个苹果放到九个抽屉里，无论怎样放，我们会发现至少会有一个抽屉里面放不少于两个苹果。
     * 所以以数组[2,4,5,2,3,1,6,7]为例，一共8个数，n+1=8,n=7
     * 所以根据设定数组中的数字都在[1,7]，left=1,right=7,目标大小中位数mid=(left+right)/2=4
     * 遍历整个数组，如果小于等于4的数>中位数4,说明重复数字在[1,4]这个大小区间，否则是在[5,7]
     * 下一步再次遍历数组，找寻小于等于(1+4)/2的数字的个数,不断二分查找，直至找到
     */
    public int findDuplicate2(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {cnt++;}
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

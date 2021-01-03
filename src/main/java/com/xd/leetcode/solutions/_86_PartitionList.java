package com.xd.leetcode.solutions;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

 你应当保留两个分区中每个节点的初始相对位置。

 示例：

 输入：head = 1->4->3->2->5->2, x = 3
 输出：1->2->2->4->3->5

 */
public class _86_PartitionList {
    /**
     * 两个指针，p1指针找到第一个大于等于x的节点，p2指针从p1后面开始遍历所有节点
     * 遇到比x小的节点就换到p1前面去
     * 由于给的是单链表，所以挪动节点时需要p1,p2的前面节点信息
     * p1的话可以通过给链表头前面插入一个新的头节点，用p1记录前节点，p1.next来找第一个大于等于x的节点
     * p2的话用prev2=p1，p1=prev2.next来开始找所有小于x的节点
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode p1 = newHead;
        p1.next = head;
        // 首先找到p1.next是第一个大于等于x的节点
        while (p1.next != null && p1.next.val < x) {
            p1 = p1.next;
        }
        ListNode p2 = p1.next;
        ListNode prev2 = p1;
        while (p2 != null) {
            // 如果p2小于x则进行挪动
            if (p2.val < x) {
                prev2.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                // 如果有挪动节点，需要把p2继续指向prev2的下一个节点
                p2 = prev2.next;
                // 如果有挪动节点到p1后面，p1也要继续指向第一个大于等于x节点的前节点
                p1 = p1.next;
            } else {
                prev2 = prev2.next;
                p2 = p2.next;
            }
        }
        return newHead.next;
    }
}

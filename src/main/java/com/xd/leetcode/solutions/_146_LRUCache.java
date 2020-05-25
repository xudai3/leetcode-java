package com.xd.leetcode.solutions;

import java.util.HashMap;
import java.util.List;

public class _146_LRUCache {
    private int capacity;
    private int length;
    private int lastKey;
    private HashMap<Integer, ListNode> map;
    private ListNode header;

    public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        map = new HashMap<>();
        header = new ListNode(-1);
        header.key = -1;
        header.prev = header;
        header.next = header;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node != null) {
            update(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        int keyVal = get(key);
        if (keyVal != -1) {
            ListNode node = map.get(key);
            node.val = value;
            update(node);
        } else {
            ListNode node = new ListNode(value);
            node.prev = header;
            node.next = header.next;
            node.next.prev = node;
            header.next = node;
            node.key = key;
            map.put(key, node);
            length++;

            if (length > capacity) {
                ListNode last = header.prev;
                last.prev.next = header;
                header.prev = last.prev;
                last = null;
                map.remove(lastKey);
                length--;
            }
            lastKey = header.prev.key;
        }
    }

    public void update(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = header.next;
        node.prev = header;
        header.next = node;
        node.next.prev = node;
        lastKey = header.prev.key;
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int x) {val = x;}
}


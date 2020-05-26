package com.xd.leetcode.solutions;

import java.util.HashMap;

/**
 146. LRU缓存机制
 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

 示例:

    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // 返回  1
    cache.put(3, 3);    // 该操作会使得关键字 2 作废
    cache.get(2);       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得关键字 1 作废
    cache.get(1);       // 返回 -1 (未找到)
    cache.get(3);       // 返回  3
    cache.get(4);       // 返回  4

 */

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
        header = new ListNode(-1, -1);
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
            ListNode node = new ListNode(key, value);
            node.prev = header;
            node.next = header.next;
            node.next.prev = node;
            header.next = node;
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


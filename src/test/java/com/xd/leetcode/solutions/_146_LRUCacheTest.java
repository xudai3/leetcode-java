package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class _146_LRUCacheTest {
    @Test
    public void cacheTest(){
        _146_LRUCache cache = new _146_LRUCache(1);
//        cache.put(1,1);
//        cache.put(2,2);
//        assertEquals(1, cache.get(1));
//        cache.put(3,3);
//        assertEquals(-1, cache.get(2));
//        cache.put(4,4);
//        assertEquals(-1, cache.get(1));
//        assertEquals(3, cache.get(3));
//        assertEquals(4, cache.get(4));
        cache.put(2,1);
        assertEquals(1, cache.get(2));
        cache.put(3,2);
        assertEquals(-1, cache.get(2));
        assertEquals(2, cache.get(3));
    }
}

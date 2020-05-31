package com.xd.leetcode.solutions;

import java.util.*;

public class _15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        if(nums.length<3) {return results;}
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) {break;}
            if(i>0 && nums[i]==nums[i-1]) {continue;}
            int l = i+1;
            int r = nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum==0){
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[l]);
                    result.add(nums[r]);
                    results.add(result);
                    while(l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while(r > l && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                }
            }
        }
        return results;
    }

    public List<List<Integer>> threeSum2(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> outer = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i+1; j < nums.length; j++) {
                int complement = target - nums[j];
                if (map.containsKey(complement)) {
                    List<Integer> inner = new ArrayList<>();
                    inner.add(nums[i]);
                    inner.add(nums[j]);
                    inner.add(complement);
                    outer.add(inner);
                }
                map.put(nums[j],j);
            }
        }
        return new ArrayList<>(outer);
    }
}

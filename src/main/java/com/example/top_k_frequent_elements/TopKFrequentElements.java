package com.example.top_k_frequent_elements;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
        System.out.println(Arrays.toString(topKFrequentHeap(nums, k)));
        System.out.println(Arrays.toString(topKFrequentBucketSort(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (int item : nums) {
            freq.merge(item, 1, Integer::sum);
        }


        List<Integer> list = new ArrayList<>(freq.keySet());

        list.sort((a, b) -> freq.get(b) - freq.get(a));

        int[] result = new int[k];
        for (int index = 0; index < result.length; index++) {
            result[index] = list.get(index);
        }

        return result;
    }


    public static int[] topKFrequentHeap(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (int item : nums) {
            freq.merge(item, 1, Integer::sum);
        }


        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(freq::get));

        int[] result = new int[k];
        for (int key : freq.keySet()) {
            heap.offer(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        for (int index = 0; index < result.length; index++) {
            result[index] = heap.poll();
        }

        return result;
    }


    public static int[] topKFrequentBucketSort(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (int item : nums) {
            freq.merge(item, 1, Integer::sum);
        }


        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freq.keySet()) {
            int f = freq.get(key);
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(key);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = buckets.length -1; i >= 0 && list.size() < k; i--) {
            if (buckets[i] != null) {
                for (int buck :buckets[i]) {
                    list.add(buck);
                    if (list.size() == k) {
                        break;
                    }
                }
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

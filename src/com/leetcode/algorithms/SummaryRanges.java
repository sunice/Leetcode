package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 * Created by Yan on 11/8/15.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        List<String> result = new ArrayList<>();
        int head = 0, tail = 0;
        while (tail < nums.length) {
            if (tail < nums.length - 1 && nums[tail] + 1 == nums[tail + 1])
                tail++;
            else {
                String str;
                if (head == tail)
                    str = "" + nums[head];
                else
                    str = nums[head] + "->" + nums[tail];
                result.add(str);
                tail++;
                head = tail;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges test = new SummaryRanges();
        int[] nums = {1,3,5,7};
        System.out.println(test.summaryRanges(nums));
    }
}
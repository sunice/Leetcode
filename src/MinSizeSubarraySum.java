/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of
 * a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Created by Yan on 2/22/16.
 */
public class MinSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, len = nums.length + 1, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                if (i - start + 1 < len)
                    len = i - start + 1;
                sum -= nums[start];
                start++;
            }
        }
        return len > nums.length ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 4;
        MinSizeSubarraySum test = new MinSizeSubarraySum();
        System.out.println(test.minSubArrayLen(s, nums));
    }
}

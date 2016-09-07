import java.util.Arrays;
import java.util.HashSet;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note: Each element in the result must be unique. The result can be in any order.
 *
 * Created by Yan on 7/11/16.
 */
public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();
        int[] result;
        for (int i : nums1)
            setA.add(i);
        for (int i : nums2)
            if (setA.contains(i))
                temp.add(i);
        result = new int[temp.size()];
        int i = 0;
        for (int num : temp)
            result[i++] = num;
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 1};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}

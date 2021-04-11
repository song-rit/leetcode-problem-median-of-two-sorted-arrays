import java.util.HashMap;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int num1Length = nums1.length;
        int num2Length = nums2.length;

        int[] nums = new int[num1Length + num2Length];

        for (int i = 0; i < num1Length; i++) {
            nums[i] = nums1[i];
        }

        for (int i = num1Length; i < num1Length + num2Length; i++) {
            nums[i] = nums2[i - num1Length];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        int numsLength = nums.length;
        if (numsLength % 2 == 0) {
            return (double) (nums[numsLength / 2 - 1] + nums[numsLength / 2]) / 2;
        }
        return nums[numsLength / 2];
    }
}
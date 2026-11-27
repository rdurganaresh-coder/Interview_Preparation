package com.leetcode.heaps_priority_queues;

class Solution0215 {
    private int[] nums;
    private int k;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.k = nums.length - k;
        return quickSort(0, nums.length - 1);
    }

    private int quickSort(int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int i = l - 1, j = r + 1;
        int x = nums[(l + r) >>> 1];
        while (i < j) {
            while (nums[++i] < x) {
            }
            while (nums[--j] > x) {
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        if (j < k) {
            return quickSort(j + 1, r);
        }
        return quickSort(l, j);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0215 _tcSol = new Solution0215();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,1,5,6,4], k = 2");
        try {
            int[] nums = new int[]{3, 2, 1, 5, 6, 4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKthLargest(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,3,1,2,4,5,5,6], k = 4");
        try {
            int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKthLargest(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}

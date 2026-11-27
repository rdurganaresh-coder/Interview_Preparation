package com.leetcode.arrays_hashing_greedy;

class Solution0912_2 {
    private int[] nums;
    private int[] tmp;

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        mergeSort(0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }
        for (i = l; i <= r; ++i) {
            nums[i] = tmp[i - l];
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0912_2 _tcSol = new Solution0912_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,2,3,1]");
        try {
            int[] nums = new int[]{5, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,1,1,2,0,0]");
        try {
            int[] nums = new int[]{5, 1, 1, 2, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,1,1,2,5]");
        System.out.println();
    }
}

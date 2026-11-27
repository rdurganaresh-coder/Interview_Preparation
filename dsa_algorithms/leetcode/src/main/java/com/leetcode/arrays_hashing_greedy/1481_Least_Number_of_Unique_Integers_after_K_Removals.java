package com.leetcode.arrays_hashing_greedy;

class Solution1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) {
            cnt.merge(x, 1, Integer::sum);
        }
        List<Integer> nums = new ArrayList<>(cnt.values());
        Collections.sort(nums);
        for (int i = 0, m = nums.size(); i < m; ++i) {
            k -= nums.get(i);
            if (k < 0) {
                return m - i;
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1481 _tcSol = new Solution1481();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [5,5,4], k = 1");
        try {
            int[] arr = new int[]{5, 5, 4};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findLeastNumOfUniqueInts(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [4,3,1,1,3,3,2], k = 3");
        try {
            int[] arr = new int[]{4, 3, 1, 1, 3, 3, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findLeastNumOfUniqueInts(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
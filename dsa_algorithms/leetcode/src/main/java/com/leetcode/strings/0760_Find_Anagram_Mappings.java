package com.leetcode.strings;

class Solution0760 {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> d = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            d.put(nums2[i], i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = d.get(nums1[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0760 _tcSol = new Solution0760();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [12,28,46,32,50], nums2 = [50,12,32,46,28]");
        try {
            int[] nums1 = new int[]{12, 28, 46, 32, 50};
            int[] nums2 = new int[]{50, 12, 32, 46, 28};
            System.out.println("  Output  : " + _tcShow(_tcSol.anagramMappings(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,4,3,2,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [84,46], nums2 = [84,46]");
        try {
            int[] nums1 = new int[]{84, 46};
            int[] nums2 = new int[]{84, 46};
            System.out.println("  Output  : " + _tcShow(_tcSol.anagramMappings(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();
    }
}

package com.leetcode.arrays_hashing_greedy;

class Solution2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = convert(nums1);
        Set<Integer> s2 = convert(nums2);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int v : s1) {
            if (!s2.contains(v)) {
                l1.add(v);
            }
        }
        for (int v : s2) {
            if (!s1.contains(v)) {
                l2.add(v);
            }
        }
        return List.of(l1, l2);
    }

    private Set<Integer> convert(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            s.add(v);
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2215 _tcSol = new Solution2215();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,3], nums2 = [2,4,6]");
        try {
            int[] nums1 = new int[]{1, 2, 3};
            int[] nums2 = new int[]{2, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDifference(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,3],[4,6]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,2,3,3], nums2 = [1,1,2,2]");
        try {
            int[] nums1 = new int[]{1, 2, 3, 3};
            int[] nums2 = new int[]{1, 1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDifference(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3],[]]");
        System.out.println();
    }
}
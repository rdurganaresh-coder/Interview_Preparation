package com.leetcode.arrays_hashing_greedy;

class Solution0229 {
    public List<Integer> majorityElement(int[] nums) {
        int n1 = 0, n2 = 0;
        int m1 = 0, m2 = 1;
        for (int m : nums) {
            if (m == m1) {
                ++n1;
            } else if (m == m2) {
                ++n2;
            } else if (n1 == 0) {
                m1 = m;
                ++n1;
            } else if (n2 == 0) {
                m2 = m;
                ++n2;
            } else {
                --n1;
                --n2;
            }
        }
        List<Integer> ans = new ArrayList<>();
        n1 = 0;
        n2 = 0;
        for (int m : nums) {
            if (m == m1) {
                ++n1;
            } else if (m == m2) {
                ++n2;
            }
        }
        if (n1 > nums.length / 3) {
            ans.add(m1);
        }
        if (n2 > nums.length / 3) {
            ans.add(m2);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0229 _tcSol = new Solution0229();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,3]");
        try {
            int[] nums = new int[]{3, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.majorityElement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1]");
        try {
            int[] nums = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.majorityElement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2]");
        try {
            int[] nums = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.majorityElement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();
    }
}
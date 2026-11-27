package com.leetcode.arrays_hashing_greedy;

class Solution2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        if (n <= time * 2) {
            return Collections.emptyList();
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; ++i) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            if (security[i] <= security[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = time; i < n - time; ++i) {
            if (time <= Math.min(left[i], right[i])) {
                ans.add(i);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2100 _tcSol = new Solution2100();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "security = [5,3,3,3,5,6,2], time = 2");
        try {
            int[] security = new int[]{5, 3, 3, 3, 5, 6, 2};
            int time = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.goodDaysToRobBank(security, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "security = [1,1,1,1,1], time = 0");
        try {
            int[] security = new int[]{1, 1, 1, 1, 1};
            int time = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.goodDaysToRobBank(security, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3,4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "security = [1,2,3,4,5,6], time = 2");
        try {
            int[] security = new int[]{1, 2, 3, 4, 5, 6};
            int time = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.goodDaysToRobBank(security, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}
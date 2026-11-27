package com.leetcode.arrays_hashing_greedy;

class Solution2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 == 1) {
            return ans;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        ans.add(ans.remove(ans.size() - 1) + finalSum);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2178 _tcSol = new Solution2178();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "finalSum = 12");
        try {
            long finalSum = 12L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumEvenSplit(finalSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "finalSum = 7");
        try {
            long finalSum = 7L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumEvenSplit(finalSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "finalSum = 28");
        try {
            long finalSum = 28L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumEvenSplit(finalSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,8,2,12]");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution2895 {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        processorTime.sort((a, b) -> a - b);
        tasks.sort((a, b) -> a - b);
        int ans = 0, i = tasks.size() - 1;
        for (int t : processorTime) {
            ans = Math.max(ans, t + tasks.get(i));
            i -= 4;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2895 _tcSol = new Solution2895();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "processorTime = [8,10], tasks = [2,2,3,1,8,7,4,5]");
        try {
            List<Integer> processorTime = _tcL(8, 10);
            List<Integer> tasks = _tcL(2, 2, 3, 1, 8, 7, 4, 5);
            System.out.println("  Output  : " + _tcShow(_tcSol.minProcessingTime(processorTime, tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "processorTime = [10,20], tasks = [2,3,1,2,5,8,4,3]");
        try {
            List<Integer> processorTime = _tcL(10, 20);
            List<Integer> tasks = _tcL(2, 3, 1, 2, 5, 8, 4, 3);
            System.out.println("  Output  : " + _tcShow(_tcSol.minProcessingTime(processorTime, tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();
    }
}
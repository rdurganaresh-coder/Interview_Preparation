package com.leetcode.heaps_priority_queues;

class Solution2365 {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> day = new HashMap<>();
        long ans = 0;
        for (int task : tasks) {
            ++ans;
            ans = Math.max(ans, day.getOrDefault(task, 0L));
            day.put(task, ans + space + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2365 _tcSol = new Solution2365();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tasks = [1,2,1,2,3,1], space = 3");
        try {
            int[] tasks = new int[]{1, 2, 1, 2, 3, 1};
            int space = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.taskSchedulerII(tasks, space)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tasks = [5,8,8,5], space = 2");
        try {
            int[] tasks = new int[]{5, 8, 8, 5};
            int space = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.taskSchedulerII(tasks, space)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
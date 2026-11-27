package com.leetcode.dynamic_programming;

class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int i = q.poll();
            if (arr[i] == 0) {
                return true;
            }
            int x = arr[i];
            arr[i] = -1;
            for (int j : List.of(i + x, i - x)) {
                if (j >= 0 && j < arr.length && arr[j] >= 0) {
                    q.offer(j);
                }
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1306 _tcSol = new Solution1306();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [4,2,3,0,3,1,2], start = 5");
        try {
            int[] arr = new int[]{4, 2, 3, 0, 3, 1, 2};
            int start = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.canReach(arr, start)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [4,2,3,0,3,1,2], start = 0");
        try {
            int[] arr = new int[]{4, 2, 3, 0, 3, 1, 2};
            int start = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.canReach(arr, start)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [3,0,2,1,2], start = 2");
        try {
            int[] arr = new int[]{3, 0, 2, 1, 2};
            int start = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.canReach(arr, start)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
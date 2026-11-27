package com.leetcode.heaps_priority_queues;

class Solution1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int m = slots1.length, n = slots2.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (end - start >= duration) {
                return Arrays.asList(start, start + duration);
            }
            if (slots1[i][1] < slots2[j][1]) {
                ++i;
            } else {
                ++j;
            }
        }
        return Collections.emptyList();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1229 _tcSol = new Solution1229();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8");
        try {
            int[][] slots1 = new int[][]{new int[]{10, 50}, new int[]{60, 120}, new int[]{140, 210}};
            int[][] slots2 = new int[][]{new int[]{0, 15}, new int[]{60, 70}};
            int duration = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAvailableDuration(slots1, slots2, duration)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[60,68]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12");
        try {
            int[][] slots1 = new int[][]{new int[]{10, 50}, new int[]{60, 120}, new int[]{140, 210}};
            int[][] slots2 = new int[][]{new int[]{0, 15}, new int[]{60, 70}};
            int duration = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAvailableDuration(slots1, slots2, duration)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}
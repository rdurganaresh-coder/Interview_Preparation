package com.leetcode.arrays_hashing_greedy;

class Solution1687 {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        long[] ws = new long[n + 1];
        int[] cs = new int[n];
        for (int i = 0; i < n; ++i) {
            int p = boxes[i][0], w = boxes[i][1];
            ws[i + 1] = ws[i] + w;
            if (i < n - 1) {
                cs[i + 1] = cs[i] + (p != boxes[i + 1][0] ? 1 : 0);
            }
        }
        int[] f = new int[n + 1];
        Arrays.fill(f, 1 << 30);
        f[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = Math.max(0, i - maxBoxes); j < i; ++j) {
                if (ws[i] - ws[j] <= maxWeight) {
                    f[i] = Math.min(f[i], f[j] + cs[i - 1] - cs[j] + 2);
                }
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1687 _tcSol = new Solution1687();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "boxes = [[1,1],[2,1],[1,1]], portsCount = 2, maxBoxes = 3, maxWeight = 3");
        try {
            int[][] boxes = new int[][]{new int[]{1, 1}, new int[]{2, 1}, new int[]{1, 1}};
            int portsCount = 2;
            int maxBoxes = 3;
            int maxWeight = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.boxDelivering(boxes, portsCount, maxBoxes, maxWeight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "boxes = [[1,2],[3,3],[3,1],[3,1],[2,4]], portsCount = 3, maxBoxes = 3, maxWeight = 6");
        try {
            int[][] boxes = new int[][]{new int[]{1, 2}, new int[]{3, 3}, new int[]{3, 1}, new int[]{3, 1}, new int[]{2, 4}};
            int portsCount = 3;
            int maxBoxes = 3;
            int maxWeight = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.boxDelivering(boxes, portsCount, maxBoxes, maxWeight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "boxes = [[1,4],[1,2],[2,1],[2,1],[3,2],[3,4]], portsCount = 3, maxBoxes = 6, maxWeight = 7");
        try {
            int[][] boxes = new int[][]{new int[]{1, 4}, new int[]{1, 2}, new int[]{2, 1}, new int[]{2, 1}, new int[]{3, 2}, new int[]{3, 4}};
            int portsCount = 3;
            int maxBoxes = 6;
            int maxWeight = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.boxDelivering(boxes, portsCount, maxBoxes, maxWeight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}

package com.leetcode.sql_database;

class Solution1580 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = warehouse.length;
        int[] left = new int[n];
        int[] right = new int[n];
        final int inf = 1 << 30;
        left[0] = inf;
        right[n - 1] = inf;
        for (int i = 1; i < n; ++i) {
            left[i] = Math.min(left[i - 1], warehouse[i - 1]);
        }
        for (int i = n - 2; i >= 0; --i) {
            right[i] = Math.min(right[i + 1], warehouse[i + 1]);
        }
        for (int i = 0; i < n; ++i) {
            warehouse[i] = Math.min(warehouse[i], Math.max(left[i], right[i]));
        }
        Arrays.sort(boxes);
        Arrays.sort(warehouse);
        int ans = 0, i = 0;
        for (int x : boxes) {
            while (i < n && warehouse[i] < x) {
                ++i;
            }
            if (i == n) {
                break;
            }
            ++ans;
            ++i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1580 _tcSol = new Solution1580();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "boxes = [1,2,2,3,4], warehouse = [3,4,1,2]");
        try {
            int[] boxes = new int[]{1, 2, 2, 3, 4};
            int[] warehouse = new int[]{3, 4, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxBoxesInWarehouse(boxes, warehouse)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "boxes = [3,5,5,2], warehouse = [2,1,3,4,5]");
        try {
            int[] boxes = new int[]{3, 5, 5, 2};
            int[] warehouse = new int[]{2, 1, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxBoxesInWarehouse(boxes, warehouse)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
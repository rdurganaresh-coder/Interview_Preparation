package com.leetcode.sql_database;

class Solution1564 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = warehouse.length;
        int[] left = new int[n];
        left[0] = warehouse[0];
        for (int i = 1; i < n; ++i) {
            left[i] = Math.min(left[i - 1], warehouse[i]);
        }
        Arrays.sort(boxes);
        int i = 0, j = n - 1;
        while (i < boxes.length) {
            while (j >= 0 && left[j] < boxes[i]) {
                --j;
            }
            if (j < 0) {
                break;
            }
            ++i;
            --j;
        }
        return i;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1564 _tcSol = new Solution1564();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "boxes = [4,3,4,1], warehouse = [5,3,3,4,1]");
        try {
            int[] boxes = new int[]{4, 3, 4, 1};
            int[] warehouse = new int[]{5, 3, 3, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxBoxesInWarehouse(boxes, warehouse)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "boxes = [1,2,2,3,4], warehouse = [3,4,1,2]");
        try {
            int[] boxes = new int[]{1, 2, 2, 3, 4};
            int[] warehouse = new int[]{3, 4, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxBoxesInWarehouse(boxes, warehouse)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "boxes = [1,2,3], warehouse = [1,2,3,4]");
        try {
            int[] boxes = new int[]{1, 2, 3};
            int[] warehouse = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxBoxesInWarehouse(boxes, warehouse)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
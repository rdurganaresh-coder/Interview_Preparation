package com.leetcode.matrices_grids;

class Solution0302 {

    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = 0, right = x;
        while (left < right) {
            int mid = (left + right) >> 1;
            int c = 0;
            while (c < n && image[mid][c] == '0') {
                ++c;
            }
            if (c < n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int u = left;
        left = x;
        right = m - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            int c = 0;
            while (c < n && image[mid][c] == '0') {
                ++c;
            }
            if (c < n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int d = left;
        left = 0;
        right = y;
        while (left < right) {
            int mid = (left + right) >> 1;
            int r = 0;
            while (r < m && image[r][mid] == '0') {
                ++r;
            }
            if (r < m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int l = left;
        left = y;
        right = n - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            int r = 0;
            while (r < m && image[r][mid] == '0') {
                ++r;
            }
            if (r < m) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int r = left;
        return (d - u + 1) * (r - l + 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0302 _tcSol = new Solution0302();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "image = [[\"0\",\"0\",\"1\",\"0\"],[\"0\",\"1\",\"1\",\"0\"],[\"0\",\"1\",\"0\",\"0\"]], x = 0, y = 2");
        try {
            char[][] image = new char[][]{new char[]{'0', '0', '1', '0'}, new char[]{'0', '1', '1', '0'}, new char[]{'0', '1', '0', '0'}};
            int x = 0;
            int y = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minArea(image, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "image = [[\"1\"]], x = 0, y = 0");
        try {
            char[][] image = new char[][]{new char[]{'1'}};
            int x = 0;
            int y = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minArea(image, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
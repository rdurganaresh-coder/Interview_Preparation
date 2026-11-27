package com.leetcode.arrays_hashing_greedy;

class Solution1552 {
    private int[] position;

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        this.position = position;
        int l = 1, r = position[position.length - 1];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (count(mid) >= m) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int count(int f) {
        int prev = position[0];
        int cnt = 1;
        for (int curr : position) {
            if (curr - prev >= f) {
                ++cnt;
                prev = curr;
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1552 _tcSol = new Solution1552();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "position = [1,2,3,4,7], m = 3");
        try {
            int[] position = new int[]{1, 2, 3, 4, 7};
            int m = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(position, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "position = [5,4,3,2,1,1000000000], m = 2");
        try {
            int[] position = new int[]{5, 4, 3, 2, 1, 1000000000};
            int m = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(position, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "999999999");
        System.out.println();
    }
}
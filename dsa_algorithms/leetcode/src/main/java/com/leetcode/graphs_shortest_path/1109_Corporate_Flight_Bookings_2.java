package com.leetcode.graphs_shortest_path;

class Solution1109_2 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        BinaryIndexedTree1109_2 tree = new BinaryIndexedTree1109_2(n);
        for (var e : bookings) {
            int first = e[0], last = e[1], seats = e[2];
            tree.update(first, seats);
            tree.update(last + 1, -seats);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = tree.query(i + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1109_2 _tcSol = new Solution1109_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5");
        try {
            int[][] bookings = new int[][]{new int[]{1, 2, 10}, new int[]{2, 3, 20}, new int[]{2, 5, 25}};
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.corpFlightBookings(bookings, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,55,45,25,25]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "bookings = [[1,2,10],[2,2,15]], n = 2");
        try {
            int[][] bookings = new int[][]{new int[]{1, 2, 10}, new int[]{2, 2, 15}};
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.corpFlightBookings(bookings, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,25]");
        System.out.println();
    }
}

class BinaryIndexedTree1109_2 {
    private int n;
    private int[] c;

    public BinaryIndexedTree1109_2(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;
            x += x & -x;
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= x & -x;
        }
        return s;
    }
}
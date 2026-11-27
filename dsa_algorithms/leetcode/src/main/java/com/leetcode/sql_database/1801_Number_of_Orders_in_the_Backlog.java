package com.leetcode.sql_database;

class Solution1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (var e : orders) {
            int p = e[0], a = e[1], t = e[2];
            if (t == 0) {
                while (a > 0 && !sell.isEmpty() && sell.peek()[0] <= p) {
                    var q = sell.poll();
                    int x = q[0], y = q[1];
                    if (a >= y) {
                        a -= y;
                    } else {
                        sell.offer(new int[] {x, y - a});
                        a = 0;
                    }
                }
                if (a > 0) {
                    buy.offer(new int[] {p, a});
                }
            } else {
                while (a > 0 && !buy.isEmpty() && buy.peek()[0] >= p) {
                    var q = buy.poll();
                    int x = q[0], y = q[1];
                    if (a >= y) {
                        a -= y;
                    } else {
                        buy.offer(new int[] {x, y - a});
                        a = 0;
                    }
                }
                if (a > 0) {
                    sell.offer(new int[] {p, a});
                }
            }
        }
        long ans = 0;
        final int mod = (int) 1e9 + 7;
        while (!buy.isEmpty()) {
            ans += buy.poll()[1];
        }
        while (!sell.isEmpty()) {
            ans += sell.poll()[1];
        }
        return (int) (ans % mod);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1801 _tcSol = new Solution1801();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "orders = [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]");
        try {
            int[][] orders = new int[][]{new int[]{10, 5, 0}, new int[]{15, 2, 1}, new int[]{25, 1, 1}, new int[]{30, 4, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getNumberOfBacklogOrders(orders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "orders = [[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]");
        try {
            int[][] orders = new int[][]{new int[]{7, 1000000000, 1}, new int[]{15, 3, 0}, new int[]{5, 999999995, 0}, new int[]{5, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getNumberOfBacklogOrders(orders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "999999984");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution1847 {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = rooms.length;
        int k = queries.length;
        Arrays.sort(rooms, (a, b) -> a[1] - b[1]);
        Integer[] idx = new Integer[k];
        for (int i = 0; i < k; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> queries[i][1] - queries[j][1]);
        int i = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int[] room : rooms) {
            tm.merge(room[0], 1, Integer::sum);
        }
        int[] ans = new int[k];
        Arrays.fill(ans, -1);
        for (int j : idx) {
            int prefer = queries[j][0], minSize = queries[j][1];
            while (i < n && rooms[i][1] < minSize) {
                if (tm.merge(rooms[i][0], -1, Integer::sum) == 0) {
                    tm.remove(rooms[i][0]);
                }
                ++i;
            }
            if (i == n) {
                break;
            }
            Integer p = tm.ceilingKey(prefer);
            if (p != null) {
                ans[j] = p;
            }
            p = tm.floorKey(prefer);
            if (p != null && (ans[j] == -1 || ans[j] - prefer >= prefer - p)) {
                ans[j] = p;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1847 _tcSol = new Solution1847();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rooms = [[2,2],[1,2],[3,2]], queries = [[3,1],[3,3],[5,2]]");
        try {
            int[][] rooms = new int[][]{new int[]{2, 2}, new int[]{1, 2}, new int[]{3, 2}};
            int[][] queries = new int[][]{new int[]{3, 1}, new int[]{3, 3}, new int[]{5, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.closestRoom(rooms, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,-1,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rooms = [[1,4],[2,3],[3,5],[4,1],[5,2]], queries = [[2,3],[2,4],[2,5]]");
        try {
            int[][] rooms = new int[][]{new int[]{1, 4}, new int[]{2, 3}, new int[]{3, 5}, new int[]{4, 1}, new int[]{5, 2}};
            int[][] queries = new int[][]{new int[]{2, 3}, new int[]{2, 4}, new int[]{2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.closestRoom(rooms, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,3]");
        System.out.println();
    }
}
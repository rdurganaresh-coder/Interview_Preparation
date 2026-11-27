package com.leetcode.arrays_hashing_greedy;

class Solution0773_2 {
    private int m = 2;
    private int n = 3;

    public int slidingPuzzle(int[][] board) {
        String start = "";
        String end = "123450";
        String seq = "";
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                start += board[i][j];
                if (board[i][j] != 0) {
                    seq += board[i][j];
                }
            }
        }
        if (!check(seq)) {
            return -1;
        }
        PriorityQueue<Pair<Integer, String>> q
            = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        Map<String, Integer> dist = new HashMap<>();
        dist.put(start, 0);
        q.offer(new Pair<>(f(start), start));
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            String state = q.poll().getValue();
            int step = dist.get(state);
            if (end.equals(state)) {
                return step;
            }
            int p1 = state.indexOf("0");
            int i = p1 / n, j = p1 % n;
            char[] s = state.toCharArray();
            for (int k = 0; k < 4; ++k) {
                int x = i + dirs[k], y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int p2 = x * n + y;
                    swap(s, p1, p2);
                    String next = String.valueOf(s);
                    if (!dist.containsKey(next) || dist.get(next) > step + 1) {
                        dist.put(next, step + 1);
                        q.offer(new Pair<>(step + 1 + f(next), next));
                    }
                    swap(s, p1, p2);
                }
            }
        }
        return -1;
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private int f(String s) {
        int ans = 0;
        for (int i = 0; i < m * n; ++i) {
            if (s.charAt(i) != '0') {
                int num = s.charAt(i) - '1';
                ans += Math.abs(i / n - num / n) + Math.abs(i % n - num % n);
            }
        }
        return ans;
    }

    private boolean check(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) > s.charAt(j)) {
                    ++cnt;
                }
            }
        }
        return cnt % 2 == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0773_2 _tcSol = new Solution0773_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[1,2,3],[4,0,5]]");
        try {
            int[][] board = new int[][]{new int[]{1, 2, 3}, new int[]{4, 0, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.slidingPuzzle(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[1,2,3],[5,4,0]]");
        try {
            int[][] board = new int[][]{new int[]{1, 2, 3}, new int[]{5, 4, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.slidingPuzzle(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "board = [[4,1,2],[5,0,3]]");
        try {
            int[][] board = new int[][]{new int[]{4, 1, 2}, new int[]{5, 0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.slidingPuzzle(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
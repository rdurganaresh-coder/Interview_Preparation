package com.leetcode.arrays_hashing_greedy;

class Solution0874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dirs = {0, 1, 0, -1, 0};
        Set<Long> s = new HashSet<>(obstacles.length);
        for (var e : obstacles) {
            s.add(f(e[0], e[1]));
        }
        int ans = 0, k = 0;
        int x = 0, y = 0;
        for (int c : commands) {
            if (c == -2) {
                k = (k + 3) % 4;
            } else if (c == -1) {
                k = (k + 1) % 4;
            } else {
                while (c-- > 0) {
                    int nx = x + dirs[k], ny = y + dirs[k + 1];
                    if (s.contains(f(nx, ny))) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }

    private long f(int x, int y) {
        return x * 200001L + y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0874 _tcSol = new Solution0874();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "commands = [4,-1,3], obstacles = []");
        try {
            int[] commands = new int[]{4, -1, 3};
            int[][] obstacles = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.robotSim(commands, obstacles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "25");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "commands = [4,-1,4,-2,4], obstacles = [[2,4]]");
        try {
            int[] commands = new int[]{4, -1, 4, -2, 4};
            int[][] obstacles = new int[][]{new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.robotSim(commands, obstacles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "65");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "commands = [6,-1,-1,6], obstacles = [[0,0]]");
        try {
            int[] commands = new int[]{6, -1, -1, 6};
            int[][] obstacles = new int[][]{new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.robotSim(commands, obstacles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "36");
        System.out.println();
    }
}
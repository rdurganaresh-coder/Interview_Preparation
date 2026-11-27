package com.leetcode.matrices_grids;

class Solution3248 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0, y = 0;
        for (var c : commands) {
            switch (c.charAt(0)) {
                case 'U' -> x--;
                case 'D' -> x++;
                case 'L' -> y--;
                case 'R' -> y++;
            }
        }
        return x * n + y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution3248 _tcSol = new Solution3248();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, commands = [\"RIGHT\",\"DOWN\"]");
        try {
            int n = 2;
            List<String> commands = _tcL("RIGHT", "DOWN");
            System.out.println("  Output  : " + _tcShow(_tcSol.finalPositionOfSnake(n, commands)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, commands = [\"DOWN\",\"RIGHT\",\"UP\"]");
        try {
            int n = 3;
            List<String> commands = _tcL("DOWN", "RIGHT", "UP");
            System.out.println("  Output  : " + _tcShow(_tcSol.finalPositionOfSnake(n, commands)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}

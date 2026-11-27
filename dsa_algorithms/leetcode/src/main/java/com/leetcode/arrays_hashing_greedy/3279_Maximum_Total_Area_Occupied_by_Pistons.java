package com.leetcode.arrays_hashing_greedy;

class Solution3279 {
    public long maxArea(int height, int[] positions, String directions) {
        Map<Integer, Integer> delta = new TreeMap<>();
        int diff = 0;
        long res = 0;
        for (int i = 0; i < positions.length; ++i) {
            int pos = positions[i];
            char dir = directions.charAt(i);
            res += pos;
            if (dir == 'U') {
                ++diff;
                delta.merge(height - pos, -2, Integer::sum);
                delta.merge(height * 2 - pos, 2, Integer::sum);
            } else {
                --diff;
                delta.merge(pos, 2, Integer::sum);
                delta.merge(height + pos, -2, Integer::sum);
            }
        }
        long ans = res;
        int pre = 0;
        for (var e : delta.entrySet()) {
            int cur = e.getKey();
            int d = e.getValue();
            res += (long) (cur - pre) * diff;
            pre = cur;
            diff += d;
            ans = Math.max(ans, res);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3279 _tcSol = new Solution3279();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "height = 5, positions = [2,5], directions = \"UD\"");
        try {
            int height = 5;
            int[] positions = new int[]{2, 5};
            String directions = "UD";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArea(height, positions, directions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "height = 6, positions = [0,0,6,3], directions = \"UUDU\"");
        try {
            int height = 6;
            int[] positions = new int[]{0, 0, 6, 3};
            String directions = "UUDU";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArea(height, positions, directions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}

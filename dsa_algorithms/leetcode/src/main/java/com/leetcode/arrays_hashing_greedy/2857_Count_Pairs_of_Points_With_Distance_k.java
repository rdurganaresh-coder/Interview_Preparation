package com.leetcode.arrays_hashing_greedy;

class Solution2857 {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (var c : coordinates) {
            int x2 = c.get(0), y2 = c.get(1);
            for (int a = 0; a <= k; ++a) {
                int b = k - a;
                int x1 = a ^ x2, y1 = b ^ y2;
                ans += cnt.getOrDefault(List.of(x1, y1), 0);
            }
            cnt.merge(c, 1, Integer::sum);
        }
        return ans;
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
        Solution2857 _tcSol = new Solution2857();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coordinates = [[1,2],[4,2],[1,3],[5,2]], k = 5");
        try {
            List<List<Integer>> coordinates = _tcL(_tcL(1, 2), _tcL(4, 2), _tcL(1, 3), _tcL(5, 2));
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(coordinates, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coordinates = [[1,3],[1,3],[1,3],[1,3],[1,3]], k = 0");
        try {
            List<List<Integer>> coordinates = _tcL(_tcL(1, 3), _tcL(1, 3), _tcL(1, 3), _tcL(1, 3), _tcL(1, 3));
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(coordinates, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}
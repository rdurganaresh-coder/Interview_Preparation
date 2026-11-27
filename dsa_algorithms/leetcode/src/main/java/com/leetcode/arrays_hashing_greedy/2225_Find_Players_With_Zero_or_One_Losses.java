package com.leetcode.arrays_hashing_greedy;

class Solution2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (var e : matches) {
            cnt.putIfAbsent(e[0], 0);
            cnt.merge(e[1], 1, Integer::sum);
        }
        List<List<Integer>> ans = List.of(new ArrayList<>(), new ArrayList<>());
        for (var e : cnt.entrySet()) {
            if (e.getValue() < 2) {
                ans.get(e.getValue()).add(e.getKey());
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2225 _tcSol = new Solution2225();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]");
        try {
            int[][] matches = new int[][]{new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 6}, new int[]{5, 6}, new int[]{5, 7}, new int[]{4, 5}, new int[]{4, 8}, new int[]{4, 9}, new int[]{10, 4}, new int[]{10, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findWinners(matches)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,10],[4,5,7,8]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matches = [[2,3],[1,3],[5,4],[6,4]]");
        try {
            int[][] matches = new int[][]{new int[]{2, 3}, new int[]{1, 3}, new int[]{5, 4}, new int[]{6, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findWinners(matches)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,5,6],[]]");
        System.out.println();
    }
}
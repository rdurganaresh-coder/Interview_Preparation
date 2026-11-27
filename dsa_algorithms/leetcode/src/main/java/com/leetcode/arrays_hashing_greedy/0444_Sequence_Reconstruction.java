package com.leetcode.arrays_hashing_greedy;

class Solution0444 {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        int[] indeg = new int[n];
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var seq : sequences) {
            for (int i = 1; i < seq.size(); ++i) {
                int a = seq.get(i - 1) - 1, b = seq.get(i) - 1;
                g[a].add(b);
                ++indeg[b];
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (q.size() == 1) {
            int i = q.poll();
            for (int j : g[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return q.isEmpty();
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
        Solution0444 _tcSol = new Solution0444();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3], sequences = [[1,2],[1,3]]");
        try {
            int[] nums = new int[]{1, 2, 3};
            List<List<Integer>> sequences = _tcL(_tcL(1, 2), _tcL(1, 3));
            System.out.println("  Output  : " + _tcShow(_tcSol.sequenceReconstruction(nums, sequences)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3], sequences = [[1,2]]");
        try {
            int[] nums = new int[]{1, 2, 3};
            List<List<Integer>> sequences = _tcL(_tcL(1, 2));
            System.out.println("  Output  : " + _tcShow(_tcSol.sequenceReconstruction(nums, sequences)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3], sequences = [[1,2],[1,3],[2,3]]");
        try {
            int[] nums = new int[]{1, 2, 3};
            List<List<Integer>> sequences = _tcL(_tcL(1, 2), _tcL(1, 3), _tcL(2, 3));
            System.out.println("  Output  : " + _tcShow(_tcSol.sequenceReconstruction(nums, sequences)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
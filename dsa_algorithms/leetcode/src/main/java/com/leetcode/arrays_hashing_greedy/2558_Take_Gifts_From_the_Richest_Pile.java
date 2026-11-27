package com.leetcode.arrays_hashing_greedy;

class Solution2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int v : gifts) {
            pq.offer(v);
        }
        while (k-- > 0) {
            pq.offer((int) Math.sqrt(pq.poll()));
        }
        long ans = 0;
        for (int v : pq) {
            ans += v;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2558 _tcSol = new Solution2558();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "gifts = [25,64,9,4,100], k = 4");
        try {
            int[] gifts = new int[]{25, 64, 9, 4, 100};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.pickGifts(gifts, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "29");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "gifts = [1,1,1,1], k = 4");
        try {
            int[] gifts = new int[]{1, 1, 1, 1};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.pickGifts(gifts, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
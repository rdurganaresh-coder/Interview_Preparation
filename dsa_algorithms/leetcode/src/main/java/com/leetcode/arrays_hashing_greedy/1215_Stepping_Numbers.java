package com.leetcode.arrays_hashing_greedy;

class Solution1215 {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        if (low == 0) {
            ans.add(0);
        }
        Deque<Long> q = new ArrayDeque<>();
        for (long i = 1; i < 10; ++i) {
            q.offer(i);
        }
        while (!q.isEmpty()) {
            long v = q.pollFirst();
            if (v > high) {
                break;
            }
            if (v >= low) {
                ans.add((int) v);
            }
            int x = (int) v % 10;
            if (x > 0) {
                q.offer(v * 10 + x - 1);
            }
            if (x < 9) {
                q.offer(v * 10 + x + 1);
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
        Solution1215 _tcSol = new Solution1215();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "low = 0, high = 21");
        try {
            int low = 0;
            int high = 21;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSteppingNumbers(low, high)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3,4,5,6,7,8,9,10,12,21]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "low = 10, high = 15");
        try {
            int low = 10;
            int high = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSteppingNumbers(low, high)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,12]");
        System.out.println();
    }
}
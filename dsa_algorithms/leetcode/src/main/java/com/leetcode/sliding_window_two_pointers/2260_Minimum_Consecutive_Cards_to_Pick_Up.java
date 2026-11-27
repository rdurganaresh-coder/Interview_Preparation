package com.leetcode.sliding_window_two_pointers;

class Solution2260 {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> last = new HashMap<>();
        int n = cards.length;
        int ans = n + 1;
        for (int i = 0; i < n; ++i) {
            if (last.containsKey(cards[i])) {
                ans = Math.min(ans, i - last.get(cards[i]) + 1);
            }
            last.put(cards[i], i);
        }
        return ans > n ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2260 _tcSol = new Solution2260();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cards = [3,4,2,3,4,7]");
        try {
            int[] cards = new int[]{3, 4, 2, 3, 4, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCardPickup(cards)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cards = [1,0,5,3]");
        try {
            int[] cards = new int[]{1, 0, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCardPickup(cards)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
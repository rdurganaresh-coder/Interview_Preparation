package com.leetcode.arrays_hashing_greedy;

class Solution0846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : hand) {
            cnt.merge(x, 1, Integer::sum);
        }
        for (int x : hand) {
            if (cnt.getOrDefault(x, 0) > 0) {
                for (int y = x; y < x + groupSize; ++y) {
                    if (cnt.merge(y, -1, Integer::sum) < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0846 _tcSol = new Solution0846();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "hand = [1,2,3,6,2,3,4,7,8], groupSize = 3");
        try {
            int[] hand = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
            int groupSize = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.isNStraightHand(hand, groupSize)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "hand = [1,2,3,4,5], groupSize = 4");
        try {
            int[] hand = new int[]{1, 2, 3, 4, 5};
            int groupSize = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.isNStraightHand(hand, groupSize)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}

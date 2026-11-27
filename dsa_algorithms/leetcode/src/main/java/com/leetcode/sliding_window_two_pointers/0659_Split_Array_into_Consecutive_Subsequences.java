package com.leetcode.sliding_window_two_pointers;

class Solution0659 {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> d = new HashMap<>();
        for (int v : nums) {
            if (d.containsKey(v - 1)) {
                var q = d.get(v - 1);
                d.computeIfAbsent(v, k -> new PriorityQueue<>()).offer(q.poll() + 1);
                if (q.isEmpty()) {
                    d.remove(v - 1);
                }
            } else {
                d.computeIfAbsent(v, k -> new PriorityQueue<>()).offer(1);
            }
        }
        for (var v : d.values()) {
            if (v.peek() < 3) {
                return false;
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
        Solution0659 _tcSol = new Solution0659();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossible(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,3,4,4,5,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 3, 4, 4, 5, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossible(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossible(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
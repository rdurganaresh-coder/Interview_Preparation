package com.leetcode.arrays_hashing_greedy;

class Solution2856 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : cnt.values()) {
            pq.offer(x);
        }
        int ans = nums.size();
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            x--;
            y--;
            if (x > 0) {
                pq.offer(x);
            }
            if (y > 0) {
                pq.offer(y);
            }
            ans -= 2;
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
        Solution2856 _tcSol = new Solution2856();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            List<Integer> nums = _tcL(1, 2, 3, 4);
            System.out.println("  Output  : " + _tcShow(_tcSol.minLengthAfterRemovals(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,2,2,3,3]");
        try {
            List<Integer> nums = _tcL(1, 1, 2, 2, 3, 3);
            System.out.println("  Output  : " + _tcShow(_tcSol.minLengthAfterRemovals(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1000000000,1000000000]");
        try {
            List<Integer> nums = _tcL(1000000000, 1000000000);
            System.out.println("  Output  : " + _tcShow(_tcSol.minLengthAfterRemovals(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "nums = [2,3,4,4,4]");
        try {
            List<Integer> nums = _tcL(2, 3, 4, 4, 4);
            System.out.println("  Output  : " + _tcShow(_tcSol.minLengthAfterRemovals(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution2780 {
    public int minimumIndex(List<Integer> nums) {
        int x = 0, cnt = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : nums) {
            int t = freq.merge(v, 1, Integer::sum);
            if (cnt < t) {
                cnt = t;
                x = v;
            }
        }
        int cur = 0;
        for (int i = 1; i <= nums.size(); ++i) {
            if (nums.get(i - 1) == x) {
                ++cur;
                if (cur * 2 > i && (cnt - cur) * 2 > nums.size() - i) {
                    return i - 1;
                }
            }
        }
        return -1;
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
        Solution2780 _tcSol = new Solution2780();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,2]");
        try {
            List<Integer> nums = _tcL(1, 2, 2, 2);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumIndex(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1,3,1,1,1,7,1,2,1]");
        try {
            List<Integer> nums = _tcL(2, 1, 3, 1, 1, 1, 7, 1, 2, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumIndex(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,3,3,3,7,2,2]");
        try {
            List<Integer> nums = _tcL(3, 3, 3, 3, 7, 2, 2);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumIndex(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
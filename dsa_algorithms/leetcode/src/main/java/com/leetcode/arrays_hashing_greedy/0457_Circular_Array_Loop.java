package com.leetcode.arrays_hashing_greedy;

class Solution0457 {
    private int n;
    private int[] nums;

    public boolean circularArrayLoop(int[] nums) {
        n = nums.length;
        this.nums = nums;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(i);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(slow)) {
                        return true;
                    }
                    break;
                }
                slow = next(slow);
                fast = next(next(fast));
            }
            int j = i;
            while (nums[j] * nums[next(j)] > 0) {
                nums[j] = 0;
                j = next(j);
            }
        }
        return false;
    }

    private int next(int i) {
        return (i + nums[i] % n + n) % n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0457 _tcSol = new Solution0457();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,-1,1,2,2]");
        try {
            int[] nums = new int[]{2, -1, 1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.circularArrayLoop(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,-2,-3,-4,-5,6]");
        try {
            int[] nums = new int[]{-1, -2, -3, -4, -5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.circularArrayLoop(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,-1,5,1,4]");
        try {
            int[] nums = new int[]{1, -1, 5, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.circularArrayLoop(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution2557 {
    public int maxCount(int[] banned, int n, long maxSum) {
        Set<Integer> black = new HashSet<>();
        black.add(0);
        black.add(n + 1);
        for (int x : banned) {
            black.add(x);
        }
        List<Integer> ban = new ArrayList<>(black);
        Collections.sort(ban);
        int ans = 0;
        for (int k = 1; k < ban.size(); ++k) {
            int i = ban.get(k - 1), j = ban.get(k);
            int left = 0, right = j - i - 1;
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if ((i + 1 + i + mid) * 1L * mid / 2 <= maxSum) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            ans += left;
            maxSum -= (i + 1 + i + left) * 1L * left / 2;
            if (maxSum <= 0) {
                break;
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
        Solution2557 _tcSol = new Solution2557();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "banned = [1,4,6], n = 6, maxSum = 4");
        try {
            int[] banned = new int[]{1, 4, 6};
            int n = 6;
            long maxSum = 4L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCount(banned, n, maxSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "banned = [4,3,5,6], n = 7, maxSum = 18");
        try {
            int[] banned = new int[]{4, 3, 5, 6};
            int n = 7;
            long maxSum = 18L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCount(banned, n, maxSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
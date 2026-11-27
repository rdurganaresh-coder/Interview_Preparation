package com.leetcode.arrays_hashing_greedy;

class Solution3267 {
    public int countPairs(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            Set<Integer> vis = new HashSet<>();
            vis.add(x);
            char[] s = String.valueOf(x).toCharArray();
            for (int j = 0; j < s.length; ++j) {
                for (int i = 0; i < j; ++i) {
                    swap(s, i, j);
                    vis.add(Integer.parseInt(String.valueOf(s)));
                    for (int q = i; q < s.length; ++q) {
                        for (int p = i; p < q; ++p) {
                            swap(s, p, q);
                            vis.add(Integer.parseInt(String.valueOf(s)));
                            swap(s, p, q);
                        }
                    }
                    swap(s, i, j);
                }
            }
            for (int y : vis) {
                ans += cnt.getOrDefault(y, 0);
            }
            cnt.merge(x, 1, Integer::sum);
        }
        return ans;
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3267 _tcSol = new Solution3267();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1023,2310,2130,213]");
        try {
            int[] nums = new int[]{1023, 2310, 2130, 213};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,10,100]");
        try {
            int[] nums = new int[]{1, 10, 100};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}

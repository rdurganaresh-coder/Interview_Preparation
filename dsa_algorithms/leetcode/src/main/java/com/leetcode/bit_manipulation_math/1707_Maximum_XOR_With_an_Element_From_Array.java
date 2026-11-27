package com.leetcode.bit_manipulation_math;

class Trie1707 {
    private Trie1707[] children = new Trie1707[2];

    public void insert(int x) {
        Trie1707 node = this;
        for (int i = 30; i >= 0; --i) {
            int v = x >> i & 1;
            if (node.children[v] == null) {
                node.children[v] = new Trie1707();
            }
            node = node.children[v];
        }
    }

    public int search(int x) {
        Trie1707 node = this;
        int ans = 0;
        for (int i = 30; i >= 0; --i) {
            int v = x >> i & 1;
            if (node.children[v ^ 1] != null) {
                ans |= 1 << i;
                node = node.children[v ^ 1];
            } else if (node.children[v] != null) {
                node = node.children[v];
            } else {
                return -1;
            }
        }
        return ans;
    }
}

class Solution1707 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n = queries.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> queries[i][1] - queries[j][1]);
        int[] ans = new int[n];
        Trie1707 trie = new Trie1707();
        int j = 0;
        for (int i : idx) {
            int x = queries[i][0], m = queries[i][1];
            while (j < nums.length && nums[j] <= m) {
                trie.insert(nums[j++]);
            }
            ans[i] = trie.search(x);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1707 _tcSol = new Solution1707();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]");
        try {
            int[] nums = new int[]{0, 1, 2, 3, 4};
            int[][] queries = new int[][]{new int[]{3, 1}, new int[]{1, 3}, new int[]{5, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeXor(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,7]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]");
        try {
            int[] nums = new int[]{5, 2, 4, 6, 6, 3};
            int[][] queries = new int[][]{new int[]{12, 4}, new int[]{8, 1}, new int[]{6, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeXor(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[15,-1,5]");
        System.out.println();
    }
}
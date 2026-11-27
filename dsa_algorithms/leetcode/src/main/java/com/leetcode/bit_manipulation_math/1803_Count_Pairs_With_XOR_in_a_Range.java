package com.leetcode.bit_manipulation_math;

class Trie1803 {
    private Trie1803[] children = new Trie1803[2];
    private int cnt;

    public void insert(int x) {
        Trie1803 node = this;
        for (int i = 15; i >= 0; --i) {
            int v = (x >> i) & 1;
            if (node.children[v] == null) {
                node.children[v] = new Trie1803();
            }
            node = node.children[v];
            ++node.cnt;
        }
    }

    public int search(int x, int limit) {
        Trie1803 node = this;
        int ans = 0;
        for (int i = 15; i >= 0 && node != null; --i) {
            int v = (x >> i) & 1;
            if (((limit >> i) & 1) == 1) {
                if (node.children[v] != null) {
                    ans += node.children[v].cnt;
                }
                node = node.children[v ^ 1];
            } else {
                node = node.children[v];
            }
        }
        return ans;
    }
}

class Solution1803 {
    public int countPairs(int[] nums, int low, int high) {
        Trie1803 trie = new Trie1803();
        int ans = 0;
        for (int x : nums) {
            ans += trie.search(x, high + 1) - trie.search(x, low);
            trie.insert(x);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1803 _tcSol = new Solution1803();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,2,7], low = 2, high = 6");
        try {
            int[] nums = new int[]{1, 4, 2, 7};
            int low = 2;
            int high = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(nums, low, high)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [9,8,4,2,1], low = 5, high = 14");
        try {
            int[] nums = new int[]{9, 8, 4, 2, 1};
            int low = 5;
            int high = 14;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(nums, low, high)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}
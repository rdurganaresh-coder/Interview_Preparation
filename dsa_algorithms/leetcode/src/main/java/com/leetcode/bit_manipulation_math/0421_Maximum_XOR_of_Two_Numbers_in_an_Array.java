package com.leetcode.bit_manipulation_math;

class Trie0421 {
    private Trie0421[] children = new Trie0421[2];

    public Trie0421() {
    }

    public void insert(int x) {
        Trie0421 node = this;
        for (int i = 30; i >= 0; --i) {
            int v = x >> i & 1;
            if (node.children[v] == null) {
                node.children[v] = new Trie0421();
            }
            node = node.children[v];
        }
    }

    public int search(int x) {
        Trie0421 node = this;
        int ans = 0;
        for (int i = 30; i >= 0; --i) {
            int v = x >> i & 1;
            if (node.children[v ^ 1] != null) {
                ans |= 1 << i;
                node = node.children[v ^ 1];
            } else {
                node = node.children[v];
            }
        }
        return ans;
    }
}

class Solution0421 {
    public int findMaximumXOR(int[] nums) {
        Trie0421 trie = new Trie0421();
        int ans = 0;
        for (int x : nums) {
            trie.insert(x);
            ans = Math.max(ans, trie.search(x));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0421 _tcSol = new Solution0421();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,10,5,25,2,8]");
        try {
            int[] nums = new int[]{3, 10, 5, 25, 2, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximumXOR(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [14,70,53,83,49,91,36,80,92,51,66,70]");
        try {
            int[] nums = new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximumXOR(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "127");
        System.out.println();
    }
}
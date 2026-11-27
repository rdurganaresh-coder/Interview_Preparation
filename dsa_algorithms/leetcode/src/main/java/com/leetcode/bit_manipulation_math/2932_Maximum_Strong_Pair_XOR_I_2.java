package com.leetcode.bit_manipulation_math;

class Trie2932_2 {
    private Trie2932_2[] children = new Trie2932_2[2];
    private int cnt = 0;

    public Trie2932_2() {
    }

    public void insert(int x) {
        Trie2932_2 node = this;
        for (int i = 7; i >= 0; --i) {
            int v = x >> i & 1;
            if (node.children[v] == null) {
                node.children[v] = new Trie2932_2();
            }
            node = node.children[v];
            ++node.cnt;
        }
    }

    public int search(int x) {
        Trie2932_2 node = this;
        int ans = 0;
        for (int i = 7; i >= 0; --i) {
            int v = x >> i & 1;
            if (node.children[v ^ 1] != null && node.children[v ^ 1].cnt > 0) {
                ans |= 1 << i;
                node = node.children[v ^ 1];
            } else {
                node = node.children[v];
            }
        }
        return ans;
    }

    public void remove(int x) {
        Trie2932_2 node = this;
        for (int i = 7; i >= 0; --i) {
            int v = x >> i & 1;
            node = node.children[v];
            --node.cnt;
        }
    }
}

class Solution2932_2 {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        Trie2932_2 tree = new Trie2932_2();
        int ans = 0, i = 0;
        for (int y : nums) {
            tree.insert(y);
            while (y > nums[i] * 2) {
                tree.remove(nums[i++]);
            }
            ans = Math.max(ans, tree.search(y));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2932_2 _tcSol = new Solution2932_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumStrongPairXor(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,100]");
        try {
            int[] nums = new int[]{10, 100};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumStrongPairXor(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,6,25,30]");
        try {
            int[] nums = new int[]{5, 6, 25, 30};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumStrongPairXor(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}
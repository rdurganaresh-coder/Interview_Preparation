package com.leetcode.trees_tries;

class Solution1361_2 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indeg = new int[n];
        for (int c : leftChild) {
            if (c != -1) {
                indeg[c]++;
            }
        }
        for (int c : rightChild) {
            if (c != -1) {
                indeg[c]++;
            }
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                root = i;
                break;
            }
        }
        if (root == -1) {
            return false;
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.add(root);
        Set<Integer> vis = new HashSet<>();
        vis.add(root);

        while (!q.isEmpty()) {
            int i = q.poll();
            int j = leftChild[i];
            if (j != -1) {
                if (vis.contains(j)) {
                    return false;
                }
                vis.add(j);
                q.add(j);
            }

            j = rightChild[i];
            if (j != -1) {
                if (vis.contains(j)) {
                    return false;
                }
                vis.add(j);
                q.add(j);
            }
        }

        return vis.size() == n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1361_2 _tcSol = new Solution1361_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]");
        try {
            int n = 4;
            int[] leftChild = new int[]{1, -1, 3, -1};
            int[] rightChild = new int[]{2, -1, -1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validateBinaryTreeNodes(n, leftChild, rightChild)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]");
        try {
            int n = 4;
            int[] leftChild = new int[]{1, -1, 3, -1};
            int[] rightChild = new int[]{2, 3, -1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validateBinaryTreeNodes(n, leftChild, rightChild)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, leftChild = [1,0], rightChild = [-1,-1]");
        try {
            int n = 2;
            int[] leftChild = new int[]{1, 0};
            int[] rightChild = new int[]{-1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validateBinaryTreeNodes(n, leftChild, rightChild)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
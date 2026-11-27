package com.leetcode.arrays_hashing_greedy;

class Solution0433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Deque<String> q = new ArrayDeque<>();
        q.offer(startGene);
        Set<String> vis = new HashSet<>();
        vis.add(startGene);
        int depth = 0;
        while (!q.isEmpty()) {
            for (int m = q.size(); m > 0; --m) {
                String gene = q.poll();
                if (gene.equals(endGene)) {
                    return depth;
                }
                for (String next : bank) {
                    int c = 2;
                    for (int k = 0; k < 8 && c > 0; ++k) {
                        if (gene.charAt(k) != next.charAt(k)) {
                            --c;
                        }
                    }
                    if (c > 0 && !vis.contains(next)) {
                        q.offer(next);
                        vis.add(next);
                    }
                }
            }
            ++depth;
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0433 _tcSol = new Solution0433();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "startGene = \"AACCGGTT\", endGene = \"AACCGGTA\", bank = [\"AACCGGTA\"]");
        try {
            String startGene = "AACCGGTT";
            String endGene = "AACCGGTA";
            String[] bank = new String[]{"AACCGGTA"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMutation(startGene, endGene, bank)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "startGene = \"AACCGGTT\", endGene = \"AAACGGTA\", bank = [\"AACCGGTA\",\"AACCGCTA\",\"AAACGGTA\"]");
        try {
            String startGene = "AACCGGTT";
            String endGene = "AAACGGTA";
            String[] bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMutation(startGene, endGene, bank)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
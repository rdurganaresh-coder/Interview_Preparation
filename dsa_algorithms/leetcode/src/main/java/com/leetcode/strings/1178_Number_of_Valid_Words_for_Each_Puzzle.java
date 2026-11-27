package com.leetcode.strings;

class Solution1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> cnt = new HashMap<>(words.length);
        for (var w : words) {
            int mask = 0;
            for (int i = 0; i < w.length(); ++i) {
                mask |= 1 << (w.charAt(i) - 'a');
            }
            cnt.merge(mask, 1, Integer::sum);
        }
        List<Integer> ans = new ArrayList<>();
        for (var p : puzzles) {
            int mask = 0;
            for (int i = 0; i < p.length(); ++i) {
                mask |= 1 << (p.charAt(i) - 'a');
            }
            int x = 0;
            int i = p.charAt(0) - 'a';
            for (int j = mask; j > 0; j = (j - 1) & mask) {
                if ((j >> i & 1) == 1) {
                    x += cnt.getOrDefault(j, 0);
                }
            }
            ans.add(x);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1178 _tcSol = new Solution1178();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"aaaa\",\"asas\",\"able\",\"ability\",\"actt\",\"actor\",\"access\"], puzzles = [\"aboveyz\",\"abrodyz\",\"abslute\",\"absoryz\",\"actresz\",\"gaswxyz\"]");
        try {
            String[] words = new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
            String[] puzzles = new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findNumOfValidWords(words, puzzles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,3,2,4,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"apple\",\"pleas\",\"please\"], puzzles = [\"aelwxyz\",\"aelpxyz\",\"aelpsxy\",\"saelpxy\",\"xaelpsy\"]");
        try {
            String[] words = new String[]{"apple", "pleas", "please"};
            String[] puzzles = new String[]{"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findNumOfValidWords(words, puzzles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,3,2,0]");
        System.out.println();
    }
}
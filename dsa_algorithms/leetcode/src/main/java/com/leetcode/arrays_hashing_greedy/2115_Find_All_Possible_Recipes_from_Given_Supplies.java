package com.leetcode.arrays_hashing_greedy;

class Solution2115 {
    public List<String> findAllRecipes(
        String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> g = new HashMap<>();
        Map<String, Integer> indeg = new HashMap<>();
        for (int i = 0; i < recipes.length; ++i) {
            for (String v : ingredients.get(i)) {
                g.computeIfAbsent(v, k -> new ArrayList<>()).add(recipes[i]);
            }
            indeg.put(recipes[i], ingredients.get(i).size());
        }
        Deque<String> q = new ArrayDeque<>();
        for (String s : supplies) {
            q.offer(s);
        }
        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            for (int n = q.size(); n > 0; --n) {
                String i = q.pollFirst();
                for (String j : g.getOrDefault(i, Collections.emptyList())) {
                    indeg.put(j, indeg.get(j) - 1);
                    if (indeg.get(j) == 0) {
                        ans.add(j);
                        q.offer(j);
                    }
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2115 _tcSol = new Solution2115();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "recipes = [\"bread\"], ingredients = [[\"yeast\",\"flour\"]], supplies = [\"yeast\",\"flour\",\"corn\"]");
        try {
            String[] recipes = new String[]{"bread"};
            List<List<String>> ingredients = _tcL(_tcL("yeast", "flour"));
            String[] supplies = new String[]{"yeast", "flour", "corn"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findAllRecipes(recipes, ingredients, supplies)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"bread\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "recipes = [\"bread\",\"sandwich\"], ingredients = [[\"yeast\",\"flour\"],[\"bread\",\"meat\"]], supplies = [\"yeast\",\"flour\",\"meat\"]");
        try {
            String[] recipes = new String[]{"bread", "sandwich"};
            List<List<String>> ingredients = _tcL(_tcL("yeast", "flour"), _tcL("bread", "meat"));
            String[] supplies = new String[]{"yeast", "flour", "meat"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findAllRecipes(recipes, ingredients, supplies)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"bread\",\"sandwich\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "recipes = [\"bread\",\"sandwich\",\"burger\"], ingredients = [[\"yeast\",\"flour\"],[\"bread\",\"meat\"],[\"sandwich\",\"meat\",\"bread\"]], supplies = [\"yeast\",\"flour\",\"meat\"]");
        try {
            String[] recipes = new String[]{"bread", "sandwich", "burger"};
            List<List<String>> ingredients = _tcL(_tcL("yeast", "flour"), _tcL("bread", "meat"), _tcL("sandwich", "meat", "bread"));
            String[] supplies = new String[]{"yeast", "flour", "meat"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findAllRecipes(recipes, ingredients, supplies)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"bread\",\"sandwich\",\"burger\"]");
        System.out.println();
    }
}
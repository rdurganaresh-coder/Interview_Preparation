package com.leetcode.arrays_hashing_greedy;

class ThroneInheritance1600 {
    private String king;
    private Set<String> dead = new HashSet<>();
    private Map<String, List<String>> g = new HashMap<>();
    private List<String> ans = new ArrayList<>();

    public ThroneInheritance1600(String kingName) {
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        g.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        ans.clear();
        dfs(king);
        return ans;
    }

    private void dfs(String x) {
        if (!dead.contains(x)) {
            ans.add(x);
        }
        for (String y : g.getOrDefault(x, List.of())) {
            dfs(y);
        }
    }
}

/**
 * Your ThroneInheritance1600 object will be instantiated and called as such:
 * ThroneInheritance1600 obj = new ThroneInheritance1600(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */

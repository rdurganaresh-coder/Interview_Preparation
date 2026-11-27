package com.leetcode.sql_database;

class SparseVector1570 {
    public Map<Integer, Integer> d = new HashMap<>(128);

    SparseVector1570(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                d.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector1570 vec) {
        var a = d;
        var b = vec.d;
        if (b.size() < a.size()) {
            var t = a;
            a = b;
            b = t;
        }
        int ans = 0;
        for (var e : a.entrySet()) {
            int i = e.getKey(), v = e.getValue();
            ans += v * b.getOrDefault(i, 0);
        }
        return ans;
    }
}

// Your SparseVector1570 object will be instantiated and called as such:
// SparseVector1570 v1 = new SparseVector1570(nums1);
// SparseVector1570 v2 = new SparseVector1570(nums2);
// int ans = v1.dotProduct(v2);
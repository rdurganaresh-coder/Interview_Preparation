package com.leetcode.design_data_structures;

class ParkingSystem1603 {
    private int[] cnt;

    public ParkingSystem1603(int big, int medium, int small) {
        cnt = new int[] {0, big, medium, small};
    }

    public boolean addCar(int carType) {
        if (cnt[carType] == 0) {
            return false;
        }
        --cnt[carType];
        return true;
    }
}

/**
 * Your ParkingSystem1603 object will be instantiated and called as such:
 * ParkingSystem1603 obj = new ParkingSystem1603(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
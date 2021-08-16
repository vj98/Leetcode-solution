class NumArray {
    
    public ArrayList <Integer> list = new ArrayList<>();
    public NumArray(int[] nums) {
        list.add(nums[0]);
        // prefix sum
        for (int i = 1; i < nums.length; i++) {
            list.add(nums[i] + list.get(i-1));
        }
    }
    
    public int sumRange(int left, int right) {
        // removing before that range sum from the left
        left--;
        
        return (left < 0) ? list.get(right) : list.get(right) - list.get(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
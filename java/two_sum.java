class Solution {
    public int[] twoSum(int[] nums, int target) {
         HashMap <Integer, Integer> hash = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hash.containsKey(temp) && i != hash.get(temp)) {
                return new int[]{i, hash.get(temp)};
            }
        }
        
        return new int[]{};
    }
}
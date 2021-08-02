/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
 var twoSum = function(nums, target) {
    let i = 0;
    let hash = {};
    let ans = 0;
    
    for (let i = 0; i < nums.length; i++) {
        hash[nums[i]] = i;
    }
    
    for (let i = 0; i < nums.length; i++) {
        let temp = target - nums[i];
        if (hash[temp] && hash[temp] != i) {
            return [i, hash[temp]];
        }
    }
    
    return [-1, -1];
};
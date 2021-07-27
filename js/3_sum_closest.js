/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
 var threeSumClosest = function(nums, target) {
    if (nums.length < 3) {
        return 0;
    }

    let ans = nums[0] + nums[1] + nums[nums.length-1];

    nums.sort((a,b) => a-b);

    for (let i = 0; i < nums.length-2; i++) {
        let left = i+1, right = nums.length-1;

        while (left < right) {
            let sum = nums[i] + nums[left] + nums[right];

            if (sum == target) {
                return sum;
            }
            else if (sum > target) {
                right--;
            }
            else {
                left++;
            }

            if (Math.abs(sum - target) < Math.abs(ans - target)) {
                ans = sum;
            }
        }
    }

    return ans;
};
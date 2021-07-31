/**
 * @param {number[]} height
 * @return {number}
 */
 var trap = function(height) {
    let ans = 0, leftMax = 0, rightMax = 0;
    let left = 0,right = height.length - 1;
    
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) {
                leftMax = height[left];
            } else {
                ans += (leftMax - height[left]);
            }
            left++;
        } else {
            if (height[right] >= rightMax) {
                rightMax = height[right];
            } else {
                ans += (rightMax - height[right]);
            }
            right--;
        }
    }
    
    return ans;
};
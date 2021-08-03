/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 var subsetsWithDup = function(nums) {
    nums.sort();
    let subsets = [[]];
    let subsetLength = 0;
    
    for (let i = 0; i < nums.length; i++) {
        let startInd = (i >= 1 && nums[i] == nums[i-1]) ? subsetLength : 0; // if duplicate then select from previous size list else add element to all the list
        
        subsetLength = subsets.length;
        for (let j = startInd; j < subsetLength; j++) {
            let currSubset = [];
            if (subsets[j].length == 0) {
                currSubset = [nums[i]];
            } else {
                currSubset = [...subsets[j]];
                currSubset.push(nums[i]);
            }
            subsets.push(currSubset);
        }
    }
    
    return subsets;
};
class Solution {

    public Integer memoCuts[][];
    public Boolean memoPalindrome[][];

    public int minCut(String s) {
        memoCuts = new Integer[s.length()][s.length()];
        memoPalindrome = new Boolean[s.length()][s.length()];
        return findMinimumCuts(s, 0, s.length() - 1, s.length() - 1);
    }

    private int findMinimumCuts(String s, int start, int end, int minimumCut) {
        // base case
        if (start == end || isPalindrome(s, start, end)) {
            return 0;
        }
        
        // check for results in memoCuts
        if (memoCuts[start][end] != null) {
            return memoCuts[start][end];
        }
        
        for (int currentEndIndex = start; currentEndIndex <= end; currentEndIndex++) {
            if (isPalindrome(s, start, currentEndIndex)) {
                minimumCut = Math.min(minimumCut, 1 + findMinimumCuts(s, currentEndIndex + 1, end, minimumCut));
            }
        }
        memoCuts[start][end] = minimumCut;
        
        return memoCuts[start][end];
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        // check for results in memoPalindrome
        if (memoPalindrome[start][end] != null) {
            return memoPalindrome[start][end];
        }
        return memoPalindrome[start][end] = (s.charAt(start) == s.charAt(end))
            && isPalindrome(s, start + 1, end - 1);
    }
}
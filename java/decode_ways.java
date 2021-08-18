class Solution {
    public int memo[];

    public int numDecodings(String s) {
        memo = new int[s.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            memo[i] = -1;
        }
        return solve(0, s);
    }
    
    private int solve(int ind, String s) {
        // already calculated
        if (memo[ind] != -1) {
            return memo[ind];
        }
        
        // we reach all char of the string
        if (ind == s.length()) {
            return 1;
        }
        

        // if string starts with 0, it is not possible
        if (s.charAt(ind) == '0') {
            return 0;
        }

        // reach at the end
        if (ind == s.length() - 1) {
            return 1;
        }


        int ans = solve(ind + 1, s);
        if (Integer.parseInt(s.substring(ind, ind + 2)) <= 26) {
             ans += solve(ind + 2, s);
        }
        
        memo[ind] = ans;

        return ans;
}
class Solution {
    public int minFlipsMonoIncr(String s) {
        int i = 0, oneCount = 0, zeroCount = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == '0') {
            i++;
        }
        
        for (;i < n; i++) {
            char ch = s.charAt(i);
            
            if (ch == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
            
            if (zeroCount > oneCount) {
                zeroCount = oneCount;
            }

        }
        return zeroCount;
    }
}
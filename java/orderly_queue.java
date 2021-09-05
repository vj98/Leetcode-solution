class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char p[] = s.toCharArray();
            Arrays.sort(p);
            return new String(p);
        }
        
        String ans = s;
        for (int i = 1; i < s.length(); i++) {
            String tmp = s.substring(i) + s.substring(0, i);
            
            if (ans.compareTo(tmp) > 0) {
                ans = tmp;
            }
        }
        
        return ans;
    }
}
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder ans = new StringBuilder(s);
        
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
            
        for (int i = 0; i < s.length(); i++) {
            ans.setCharAt(i, (char)((s.charAt(i) - 'a' + shifts[i]) % 26 + 'a'));
        }
        
        return ans.toString();
    }
}
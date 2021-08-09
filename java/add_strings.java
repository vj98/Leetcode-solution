class Solution {
    public String addStrings(String num1, String num2) {
       StringBuilder ans = new StringBuilder();
        
        int carry = 0;
        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;
        
        while (num1Index >= 0 || num2Index >= 0) {
            int x = num1Index >= 0 ? num1.charAt(num1Index) - '0' : 0;
            int y = num2Index >= 0 ? num2.charAt(num2Index) - '0' : 0;
            
            int val = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            ans.append(val);
            num1Index--;
            num2Index--;
        }
        
        if (carry != 0) {
            ans.append(carry);
        }
        
        return ans.reverse().toString(); 
    }
}
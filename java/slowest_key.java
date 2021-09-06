class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        // postfix
        for (int i = releaseTimes.length - 1; i >= 1; i--) {
            releaseTimes[i] = releaseTimes[i] - releaseTimes[i-1];
        }
        
        int mn = releaseTimes[0];
        int asciiVal = keysPressed.charAt(0);
        char ans = keysPressed.charAt(0);
        
        // iterating each character
        for (int i = 1; i < keysPressed.length(); i++) {
            int tmp = releaseTimes[i];
            int newAsciiVal = keysPressed.charAt(i);
            
            if (mn < tmp) {
                mn = tmp;
                asciiVal = newAsciiVal;
                ans = keysPressed.charAt(i);
            }
            else if (mn == tmp && asciiVal < newAsciiVal) {
                asciiVal = newAsciiVal;
                ans = keysPressed.charAt(i);
            }
        }
        
        return ans;
    }
}
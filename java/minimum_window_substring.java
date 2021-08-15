class Solution {
    public String minWindow(String s, String t) {
        int right = 0, left = 0, matched = 0, substrStart = 0, minlength = s.length() + 1;
        HashMap <Character, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }
        
        for (right = 0; right < s.length(); right++) {
            char rightCh = s.charAt(right);
            if (hashMap.containsKey(rightCh)) {
                hashMap.put(rightCh, hashMap.get(rightCh) - 1);
                if (hashMap.get(rightCh) == 0) {
                    matched++;
                }
            }
            
            while (matched == hashMap.size()) {
                if (minlength > right - left + 1) {
                    minlength = right - left + 1;
                    substrStart = left;
                }
                
                char leftCh = s.charAt(left++);
                if (hashMap.containsKey(leftCh)) {
                    if (hashMap.get(leftCh) == 0) {
                        matched--;
                    }
                    hashMap.put(leftCh, hashMap.get(leftCh) + 1);
                }
            }
        }
        
        return (minlength > s.length()) ? "" : s.substring(substrStart, substrStart+minlength);
    }
}
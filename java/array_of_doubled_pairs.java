class Solution {
    public boolean canReorderDoubled(int[] arr) {
         HashMap <Integer, Integer> hashMap = new HashMap<>();
        
        for (int x: arr) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        
        Integer[] ar = new Integer[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            ar[i] = arr[i];
        }
        
        Arrays.sort(ar,(a,b) -> Math.abs(a)-Math.abs(b));
        
        for (int x: ar) {
            if (hashMap.get(x) == 0) {
                continue;
            }
            
            if (hashMap.getOrDefault(2*x, 0) == 0) {
                return false;
            }
            
            hashMap.put(x, hashMap.get(x) - 1);
            hashMap.put(2*x, hashMap.get(2*x) - 1);
        }
        
        return true;
    }
}
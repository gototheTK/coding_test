class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int leftMin = a[0];
        int[] rightMin = new int[a.length];
        rightMin[a.length-1] = a[a.length-1];
        
        for (int i=a.length-2; i>=0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], a[i]);
        }
        
        int count = a.length;
        
        for (int i=0; i<a.length; i++) {
            
            int balloon = a[i];
            
            if (leftMin<balloon && rightMin[i]<balloon) {
                count--;
            }
            
            leftMin = Math.min(leftMin, balloon);
            
        }
        
        answer = count;
        
        return answer;
    }
}
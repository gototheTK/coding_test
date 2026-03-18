class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 1;
        int right = 200_000_000;
        
        while (left<=right) {
            
            int mid = (left+right)/2;
            int empty = 0;
            
            for (int i=0; i<stones.length; i++) {
                
                if (stones[i]<mid) {
                    empty++;
                    if (empty>=k) break;
                }else {
                    empty=0;
                }
                
            }
            
            if (empty<k) {
                answer = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
            
        }
        
        return answer;
    }
}
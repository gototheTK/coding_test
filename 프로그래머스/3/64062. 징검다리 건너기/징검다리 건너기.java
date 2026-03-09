class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = stones[0];
        int right = stones[0];
        
        for (int stone : stones) {
            left = Math.min(left, stone);
            right = Math.max(right, stone);
        }
        
        int count = 0;
        
        while (left<=right) {
            
            int mid = (left+right)/2;
            int empty = 0;
            
            for (int i=0; i<stones.length; i++) {
                
                if (stones[i]<mid) {
                    empty++;
                    if (empty>=k) break;
                }else {
                    empty = 0;
                }
                
            }
            
            if (empty<k) {
                count = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
            
        }
        
        answer = count;
        
        return answer;
    }
}
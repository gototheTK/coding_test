class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int low=1, high=2000_000_00;
        
        while (low<=high) {
            
            int mid = (low+high)/2;
            int empty = 0;
            
            for (int i=0; i<stones.length; i++) {
                if (stones[i]<mid) {
                    empty++;
                    if (empty >= k) break;
                }else {
                    empty=0;
                }
            }
            
            if (empty<k) {
                answer = mid;
                low = mid+1;
            }else {
                high = mid-1;
            }
            
        }
        
        return answer;
    }
}
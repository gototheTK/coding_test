class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        int len = queue1.length + queue2.length;
        long[] nums = new long[len];
        long target = 0;
        long sum = 0;
        
        for (int i=0; i<len; i++) {
            
            if (i<queue1.length) {
                nums[i] = (long) queue1[i];
                sum += queue1[i];
            }else {
                nums[i] = (long) queue2[i-queue1.length];
            }
            
            target += nums[i];
            
        }
        
        if (target%2!=0) return answer;
        
        target/=2;
        
        int left = 0;
        int right = queue1.length-1;
        
        int count = 0;
        
        while (left<=right) {
            
            if (sum==target) {
                return count;
            }else if (sum > target) {
                sum-=nums[left];
                left++;
            }else {
                right++;
                if (right>=len) break;
                sum+=nums[right];
            }
            
            count++;
            
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int num = storey;
        int count = 0;
        
        while (num > 0) {
            
            int remain = num%10;
            num /= 10;
            
            if (remain>5) {
                count += 10 - remain;
                num += 1;
            }else if (remain == 5) {
                count += remain;
                
                int next = num % 10;
                num += next >= 5 ? 1 : 0;
            }else {
                count += remain;
            }
            
        }
        
        answer = count;
        
        return answer;
    }
}
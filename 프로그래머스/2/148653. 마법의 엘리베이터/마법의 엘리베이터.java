class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int count = 0;
        int current = storey;
        
        while (current > 0) {
            
            int left = current % 10;
            
            current /= 10;
            
            if (left > 5) {
                current += 1;
                count += 10-left;
            }else if (left==5) {
                
                count += 5;
                
                int next = current % 10;
                current += next >= 5 ? 1 : 0;
               
                
            }else {
                count += left;
            }
            
        }
        
        answer = count;
        
        return answer;
    }
}
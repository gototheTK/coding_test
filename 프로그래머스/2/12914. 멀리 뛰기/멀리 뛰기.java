class Solution {
    public long solution(int n) {
        long answer = 0;
        
        /**
        n=1, 1
        n=2, 1,1 / 2
        n=3, 1,1,1 / 1,2 / 2,1
        n=4, 1,1,1,1 / 1,1,2, / 1,2,1 / 2,1,1 / 2,2
        n=5, 1,1,1,1,1 / 1,1,1,2 / 1,1,2,1 / 1,2,1,1 / 2,1,1,1 / 1,2,2 / 2,1,2 / 2,2,1 
        **/
        
        long num1 = 1;
        long num2 = 0;
        
        long num = 0;
        
        while (n>0) {
            
            num = (num1 + num2)%1234567;
            num2 = num1;
            num1 = num;
            
            n--;
        }
        
        answer = num;
        
        return answer;
    }
}
class Solution {
    public String solution(int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        String[] numbers = {"4", "1", "2"};
        
        while (n > 0) {
            
            int index = n%3;
            sb.insert(0, numbers[index]);
            
            n = (n-1)/3;
            
        }
        
        answer = sb.toString();
        
        return answer;
    }
}
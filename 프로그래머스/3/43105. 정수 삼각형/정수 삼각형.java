class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for (int i=1; i<triangle.length; i++) {
            
            for (int j=0; j<triangle[i].length; j++) {
                
                int left = triangle[i][j];
                int right = triangle[i][j];
                
                left += j == 0 ? 0 : triangle[i-1][j-1];
                right += j == triangle[i].length-1 ? 0 : triangle[i-1][j];
                
                int max = Math.max(left, right);
                
                triangle[i][j] = max;
                
                answer = Math.max(answer, max);
                
            }
            
        }
        
        
        
        return answer;
    }
}
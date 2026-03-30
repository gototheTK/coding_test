class Solution {
    
    private int dfs (int[] numbers, int sum, int target, int index) {
        
        if (index>=numbers.length) return sum == target ? 1 : 0;
        
        return dfs(numbers, sum + numbers[index], target, index+1) + dfs(numbers, sum - numbers[index], target, index+1);
        
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(numbers, 0, target, 0);
        
        return answer;
    }
}
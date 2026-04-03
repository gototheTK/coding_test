class Solution {
    
    private int dfs (int[] numbers, int index, int sum, int target) {
        
        if (index==numbers.length) return target == sum ? 1 : 0;
        
        return dfs(numbers, index+1, sum+numbers[index], target) + dfs(numbers, index+1, sum-numbers[index], target);
        
    }
    
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
        
        return answer;
    }
}
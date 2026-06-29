class Solution {
    
    public int targetNumber(int[] numbers, int target, int index) {

        if (index >= numbers.length) return target == 0 ? 1 : 0;

        return targetNumber(numbers, target + numbers[index], index + 1)
                + targetNumber(numbers, target - numbers[index], index + 1);

    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer  = targetNumber(numbers, target, 0);

        return answer;
    }
}
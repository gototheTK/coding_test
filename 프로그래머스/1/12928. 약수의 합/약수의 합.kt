class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        
        var sum = 0
        
        for (num in 1..n) {
            
            if (n % num == 0) sum += num
            
        }
        
        answer = sum
        
        return answer
    }
}
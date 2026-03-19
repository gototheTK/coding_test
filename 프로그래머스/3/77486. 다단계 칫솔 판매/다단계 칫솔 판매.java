import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        
        Map<String, String> parentMap = new HashMap<>();
        
        for (int i=0; i<enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
        }
        
        Map<String, Integer> profitMap = new HashMap<>();
        
        for (int i=0; i<seller.length; i++) {
            
            String person = seller[i];
            int revenue = amount[i] * 100;
            
            while (!person.equals("-")) {
                
                int commision = revenue / 10;
                int mine = revenue - commision;
                
                profitMap.put(person, profitMap.getOrDefault(person, 0)+mine);
                
                if (commision<1) break;
                
                person = parentMap.get(person);
                revenue = commision;
                
            }
            
        }
        
        answer = new int[enroll.length];
        
        for (int i=0; i<enroll.length; i++) {
            
            int profit = profitMap.getOrDefault(enroll[i], 0);
            answer[i] = profit;
            
        }
        
        return answer;
    }
}
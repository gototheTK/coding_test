import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();
        
        for (int i=0; i<enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
        }
        
        for (int i=0; i<seller.length; i++) {
            
            String member = seller[i];
            int revenue = amount[i] * 100;
            
            while (!member.equals("-")) {
                
                int commission = revenue / 10;
                int mine = revenue - commission;
                
                profitMap.put(member, profitMap.getOrDefault(member, 0) + mine);
                
                if (commission<1) break;
                
                member = parentMap.get(member);
                revenue = commission;
                
            }
            
        }
        
        answer = new int[enroll.length];
        
        for (int i=0; i<enroll.length; i++) {
            
            String member = enroll[i];
            int profit = profitMap.getOrDefault(member, 0);
            
            answer[i] = profit;
            
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        
        Map<String, String> parentsMap = new HashMap<>();
        
        for (int i=0; i<enroll.length; i++) {
            parentsMap.put(enroll[i], referral[i]);
        }
        
        Map<String, Integer> profitsMap = new HashMap<>();
        
        for (int i=0; i<seller.length; i++) {
            
            String member = seller[i];
            int profits = amount[i] * 100;
            
            while (!member.equals("-")) {
                
                int commission = profits / 10;
                int mine = profits - commission;
                
                profitsMap.put(member, profitsMap.getOrDefault(member, 0) + mine);
                
                if (commission<1) break;
                
                profits = commission;
                member = parentsMap.get(member);
                
            }
            
        }
        
        answer = new int[enroll.length];
        
        for (int i=0; i<enroll.length; i++) {
            
            String member = enroll[i];
            int profits = profitsMap.getOrDefault(member, 0);
            
            answer[i] = profits;
            
        }
        
        return answer;
    }
}
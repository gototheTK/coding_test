class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int playSeconds = convertTimeToSeconds(play_time);
        int advSeconds = convertTimeToSeconds(adv_time);
        
        int[] plays = new int[playSeconds+1];
        
        for (String log : logs) {
            
            String[] split = log.split("-");
            
            int start = convertTimeToSeconds(split[0]);
            int end = convertTimeToSeconds(split[1]);
            
            plays[start] += 1;
            plays[end] -= 1;
            
        }
        
        for (int i=1; i<plays.length; i++) {
            plays[i] += plays[i-1];
        }
        
        long currentSum = 0;
        
        for (int i=0; i<advSeconds; i++) {
            currentSum += plays[i];
        }
        
        long maxSum = currentSum;
        int maxStartSeconds = 0;
        
        for (int i = advSeconds; i<=playSeconds; i++) {
            
            currentSum = currentSum + plays[i] - plays[i-advSeconds];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStartSeconds = i-advSeconds+1;
            }
            
        }
        
        answer = convertSecondsToTime(maxStartSeconds);
        
        return answer;
    }
    
    public int convertTimeToSeconds(String time) {
        
        String[] times = time.split(":");
        
        int hours = Integer.parseInt(times[0]);
        int minutes = Integer.parseInt(times[1]);
        int seconds = Integer.parseInt(times[2]);
        
        return hours * (60 * 60) + minutes * 60 + seconds;
        
    }
    
    public String convertSecondsToTime(int seconds) {
        
        int hours = seconds / (60 * 60);
        seconds %= (60 * 60);
        int minutes = seconds / 60;
        seconds %= 60;
        
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
}
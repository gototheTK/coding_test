import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playSeconds = convertTimeToSeconds(play_time);

        int[] plays = new int[playSeconds+1];

        for (String log : logs) {

            String[] times = log.split("-");

            int start = convertTimeToSeconds(times[0]);
            int end = convertTimeToSeconds(times[1]);

            plays[start] += 1;
            plays[end] -= 1;

        }

        for (int i=1; i<=playSeconds; i++) {
            plays[i] += plays[i-1];
        }

        int advSeconds = convertTimeToSeconds(adv_time);
        long maxSecondsSum = 0;
        int maxStartSeconds = 0;

        for (int i=0; i<advSeconds; i++) {
            maxSecondsSum += plays[i];
        }

        long currentSecondsSum = maxSecondsSum;

        for (int i=advSeconds; i<=playSeconds; i++) {

            currentSecondsSum = currentSecondsSum + plays[i] - plays[i-advSeconds];

            if (maxSecondsSum < currentSecondsSum) {
                maxStartSeconds = i - advSeconds + 1;
                maxSecondsSum = currentSecondsSum;
            }

        }

        answer = convertSecondsToTime(maxStartSeconds);

        return answer;
    }

    private int convertTimeToSeconds(String time) {

        String[] times = time.split(":");

        int hours = Integer.parseInt(times[0]);
        int minutes = Integer.parseInt(times[1]);
        int seconds = Integer.parseInt(times[2]);

        return hours * 60 * 60 + minutes * 60 + seconds;
    }

    private String convertSecondsToTime(int seconds) {

        int hours = seconds / (60 * 60);
        seconds %= (60 * 60);
        int minutes = seconds / 60;
        seconds %= 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);

    }

}
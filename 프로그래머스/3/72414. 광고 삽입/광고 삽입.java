import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playSeconds = convertTimeToSeconds(play_time);
        int[] playCounts = new int[playSeconds+1];

        for (String log : logs) {

            String[] times = log.split("-");

            int start = convertTimeToSeconds(times[0]);
            int end = convertTimeToSeconds(times[1]);

            playCounts[start] += 1;
            playCounts[end] -= 1;

        }

        for (int i=1; i<playCounts.length; i++) {
            playCounts[i] += playCounts[i-1];
        }

        int advSeconds = convertTimeToSeconds(adv_time);
        long maxPlayTimes = 0;
        int startTime = 0;

        for (int i=0; i<advSeconds; i++) {
            maxPlayTimes += playCounts[i];
        }

        long currentPlayTimes = maxPlayTimes;

        for (int i=advSeconds; i<=playSeconds; i++) {

            currentPlayTimes = currentPlayTimes + playCounts[i] - playCounts[i-advSeconds];

            if (maxPlayTimes < currentPlayTimes) {
                startTime = i-advSeconds+1;
                maxPlayTimes = currentPlayTimes;

            }

        }

        answer = convertSecondsToString(startTime);

        return answer;
    }

    private int convertTimeToSeconds(String time) {

        String[] splits = time.split(":");
        int hours = Integer.parseInt(splits[0]);
        int minutes = Integer.parseInt(splits[1]);
        int seconds = Integer.parseInt(splits[2]);

        return hours * 60 * 60 + minutes * 60 + seconds;
    }

    private String convertSecondsToString(int seconds) {

        int hours = seconds / (60 *60);
        seconds %= (60 * 60);
        int minutes = seconds / 60;
        seconds %= 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}
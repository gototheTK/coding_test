import java.util.*;

class Solution {

    public int solution(int[][] maps) {

        int answer = -1;

        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});
        maps[0][0]=0;

        while (!queue.isEmpty()) {

            int[] c = queue.poll();

            if (c[0]==n-1 && c[1]==m-1) {
                answer = c[2];
                break;
            }

            for (int i=0; i<4; i++) {

                int x = c[0] + dx[i]; 
                int y = c[1] + dy[i];
                int move = c[2];

                if (x>=0 && x<n && y>=0 && y<m && maps[x][y]==1) {
                    maps[x][y]=0;
                    queue.add(new int[]{x, y, move+1});
                }

            }
        }


        return answer;

    }

}
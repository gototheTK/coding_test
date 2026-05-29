
class Solution {

    public int solution(int n) {

        int answer = 0;

        int targetCount = Integer.bitCount(n);

        int num = n+1;

        while (true) {

            if (targetCount == Integer.bitCount(num)) {
                return num;
            }

            num++;

        }
    }

}
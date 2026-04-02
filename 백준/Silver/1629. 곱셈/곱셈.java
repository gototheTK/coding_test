import java.util.*;

class Main {

    public static long solution(long a, long b, long c) {

        long answer = 0;
        
        long mid = c;
        long base = a %mid;
        long exp = b;
        

        long rest = 1;

        while (exp>0) {

            if (exp%2 == 1) rest = (rest * base) % mid;

            base = (base * base) % mid;
            
            exp/=2;
        }

        answer = rest;

        return answer;
    }
    
	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        
        long answer = solution(a, b, c);
        
        System.out.println(answer);
	}

}
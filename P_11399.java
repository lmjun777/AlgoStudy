package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P_11399 {
    public static void main(String[] args) {
        int N;
        int leastTime = 0;

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int[] time = new int[N];

        for (int i=0; i<N; i++) {
            time[i] = scanner.nextInt();
        }

        Arrays.sort(time);

        for (int i=0; i<time.length; i++) {
            leastTime += (time[i]*N--);
        }

        System.out.println(leastTime);
    }
}

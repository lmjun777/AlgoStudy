package Greedy;

import java.util.Scanner;

public class P_11047 {
    public static void main(String[] args) {
        int N, K;
        int count = 0;

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();

        int[] coin = new int[N];

        for (int i=0; i<N; i++) {
            coin[i] = scanner.nextInt();
        }

        for (int i=N-1; i>0||K>0; i--) {
            if (coin[i] <= K) {
                count++;
                K -= coin[i];
                i++;
            }
        }

        System.out.println(count);
    }
}

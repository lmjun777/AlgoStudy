package Greedy;

import java.util.Scanner;

public class P_2839 {
    public static void main(String[] args) {
        int N;
        int wholeCount = 0;
        int threeCount = 0;
        int noAnswer = -1;
        int index;
        
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        wholeCount = N/5;

        for (index=wholeCount; index>=0; index--) {
            if ((N - (5*index)) % 3 == 0) {
                threeCount = (N - (5*index)) / 3;
                System.out.println(index + threeCount);
                break;
            }
        }

        if (index == -1) System.out.println(noAnswer);
    }
}

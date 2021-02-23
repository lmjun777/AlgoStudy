package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P_1931 {
    public static void main(String[] args) {
        int N;
        int count = 1; // 정렬 했기 때문에 첫 회의는 무조건 실행 가능
        int lastConference = 0;

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        int[][] timeTable = new int[N][2];

        for (int i=0; i<N*2; i++) {
            timeTable[i/2][i%2] = scanner.nextInt();
        }

        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        lastConference = timeTable[0][1];

        for (int i=1; i<N; i++) {
            if (timeTable[i][0] - lastConference >= 0) {
                count++;
                lastConference = timeTable[i][1];
            }
        }

        System.out.println(count);
    }
}

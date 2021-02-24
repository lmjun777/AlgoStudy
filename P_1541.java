package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> expSplit = new ArrayList<>();
        String expression = sc.nextLine();

        String[] div = expression.split("");

        int temp = 0;
        int sum = 0;
        List<Integer> intStack = new ArrayList<>();
        List<String> strStack = new ArrayList<>();

        // 숫자와 연산자 분리
        for (int i=0; i< div.length; i++) {
            switch (div[i]) {
                case "-":
                case "+":
                    strStack.add(div[i]);
                    break;
                default:
                    if (i == div.length-1) { // 인덱스 넘는 거 방지
                        temp += Integer.parseInt(div[i]);
                        intStack.add(temp);
                        break;
                    }

                    if (div[i+1].equals("+") || div[i+1].equals("-")) { // 숫자 다음 문자
                        temp += Integer.parseInt(div[i]);
                        intStack.add(temp);
                        temp = 0;
                    } else { // 숫자 다음 숫자
                        temp *= 10;
                        temp += Integer.parseInt(div[i])*10;
                    }
                    break;
            }
        }

        // ++,+-,-- -> 그대로 // -+ -> 괄호(+를 -로 변환)
        for (int i=0; i<strStack.size()-1; i++) {
            if (strStack.get(i).equals("-") && strStack.get(i+1).equals("+")) {
                strStack.remove(i+1);
                strStack.add(i, "-");
            }
        }

        sum += intStack.get(0);
        intStack.remove(0);

        while (!strStack.isEmpty() && !intStack.isEmpty()) {
            sum += Integer.parseInt(strStack.get(0)+intStack.get(0));
            strStack.remove(0);
            intStack.remove(0);
        }

        System.out.println(sum);
    }
}

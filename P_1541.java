package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = "";
        expression = sc.nextLine();

        String[] div = expression.split("");

        int temp = 0;
        List<Integer> intStack = new ArrayList<>();
        List<String> stringStack = new ArrayList<>();

        for (int i=0; i< div.length; i++) {
            switch (div[i]) {
                case "-":
                case "+":
                    stringStack.add(div[i]);
                    System.out.println("str: "+div[i]);
                    break;
                default:
                    System.out.println("default: "+div[i]);
                    if (i == div.length-1) { // 인덱스 넘는 거 방지
                        intStack.add(temp);
                        break;
                    }

                    if (div[i+1].equals("+") || div[i+1].equals("-")) { // 숫자 다음 문자
                        System.out.println("숫자 다음 문자");
                        temp += Integer.parseInt(div[i]);
                        intStack.add(temp);
                        temp = 0;
                    } else { // 숫자 다음 숫자
                        System.out.println("숫자 다음 숫자");
                        temp *= 10;
                        temp += Integer.parseInt(div[i])*10;
                    }
                    break;
            }
        }
        System.out.println(stringStack.get(0));
        System.out.println(stringStack.get(1));
        System.out.println(stringStack.get(2));
        System.out.println(intStack.get(0));
        System.out.println(intStack.get(1));
        System.out.println(intStack.get(2));
        System.out.println(intStack.get(3));

        //if ()
    }
}

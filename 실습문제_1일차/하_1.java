package 실습문제_1일차;

/*
[문제]
두 개의 정수 A와 B를 입력받아, 두 수의 덧셈(A+B), 뺄셈(A-B), 곱셈(A*B), 나눗셈의 몫(A/B), 나눗셈의 나머지(A%B)를 계산하여 서식에 맞게 한 줄씩 출력하세요.

        [입력]
        첫째 줄에 두 정수 A와 B가 공백으로 구분되어 주어집니다. (단, B는 0이 아님)
        (예: 20 6)
*/

import java.util.Scanner;

public class 하_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("덧셈: " + (a + b));
        System.out.println("뺄셈: " + (a - b));
        System.out.println("곱셈: " + (a * b));
        System.out.println("몫: " + (a / b));
        System.out.println("나머지: " + (a % b));

        // 여기에 코드를 작성하세요

    }
}

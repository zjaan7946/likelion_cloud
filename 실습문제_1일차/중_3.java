package 실습문제_1일차;

/*
손님이 낸 금액과 상품 금액을 입력받아, 거스름돈을 최소 매수의 화폐(10,000원, 5,000원, 1,000원, 500원, 100원)로 거슬러 주기 위한 단위별 개수를 산출하세요.

[입력]
첫째 줄에 상품 금액과 손님이 낸 금액이 공백으로 주어집니다.
(예: 23700 50000)
 */

import java.util.Scanner;

public class 중_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int itemPrice = sc.nextInt(); // 상품 금액
        int paidAmount = sc.nextInt(); // 받은 금액
        int change = paidAmount - itemPrice; // 거스름 돈 총액

        int count10000 = change / 10000; //장수
        int rem10000 = change % 10000;

        int count5000 = rem10000 / 5000;
        int rem5000 = rem10000 % 5000;

        int count1000 = rem5000 / 1000;
        int rem1000 = rem5000 % 1000;

        int count500 = rem1000 / 500;
        int rem500 = rem1000 % 500;

        int count100 = rem500 / 100;

        System.out.printf("=== 편의점 거스름돈 계산기 ===\n");
        System.out.printf("상품 금액: %,d원\n",itemPrice);
        System.out.printf("받은 금액: %,d원\n",paidAmount);
        System.out.printf("거스름돈 총액: %,d원\n",change);
        System.out.printf("--------------------------------------------\n");
        System.out.printf("10,000원권: %d장\n",count10000);
        System.out.printf("5,000원권: %d장\n",count5000);
        System.out.printf("1,000원권: %d장\n",count1000);
        System.out.printf("500원권: %d장\n",count500);
        System.out.printf("100원권: %d장\n",count100);
    }
}

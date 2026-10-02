package 실습문제_1일차;
/*
카페 포스기(POS)에서 주문받은 음료의 단가와 수량을 입력받아 공급가액, 부가세(VAT 10%), 최종 결제 금액을 계산하여 출력하세요.
(부가세는 공급가액의 10%이며, (int)로 명시적 형변환합니다.)

[입력]
첫째 줄에 아메리카노 단가와 수량, 카페라떼 단가와 수량이 공백으로 구분되어 주어집니다.
(예: 4500 2 5000 3)
*/
import java.util.Scanner;
public class 하_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int americanoPrice = sc.nextInt(); int americanoQty = sc.nextInt();
        int lattePrice = sc.nextInt(); int latteQty = sc.nextInt();
        System.out.printf("=== 스타카페 주문 영수증 ===\n");
        System.out.printf("아메리카노 (%d원 x %d잔): %d원\n",americanoPrice, americanoQty, americanoPrice * americanoQty);
        System.out.printf("카페라떼 (%d원 x %d잔): %d원\n",lattePrice, latteQty, lattePrice * latteQty);
        System.out.printf("-------------------------------------\n");

        int supplyPrice = americanoPrice * americanoQty + lattePrice * latteQty;
        System.out.printf("공급가액: %d원\n",supplyPrice);
        System.out.printf("부가세(10%%): %d원\n",supplyPrice / 10);
        System.out.printf("최종 결제 금액: %d원\n",supplyPrice + supplyPrice / 10);
    }
}

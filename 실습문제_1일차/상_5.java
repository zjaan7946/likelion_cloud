package 실습문제_1일차;
/*
기준 요금, 관람자 나이, 조조 할인 여부(1 또는 0), 통신사 제휴 할인 여부(1 또는 0)를 입력받아 조건에 맞는 최종 예매 금액을 계산하세요.
- 나이 할인: 65세 이상 50%, 19세 미만 30%
- 조조 할인: 2,000원 차감
- 통신사 할인: 추가 10% 감면

[입력]
기준요금, 나이, 조조할인여부(1/0), 통신사할인여부(1/0)가 공백으로 주어집니다.
(예: 15000 17 1 1)
 */
import java.util.Scanner;

public class 상_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int baseRate = sc.nextInt(); // 기준 요금
        int age = sc.nextInt(); // 나이

        boolean isMorning = sc.nextInt() == 1; // 조조 할인 여부
        boolean hasTelecomDiscount = sc.nextInt() == 1; // 통신사 제휴 할인 여부

        double ageDiscountRate = (age >= 65) ? 0.5 : ((age < 19) ? 0.3 : 0.0); // 1단계 나이 할인율
        int priceAfterAge = baseRate - (int)(baseRate * ageDiscountRate); // 나이 할인 금액

        int priceAfterMorning = isMorning ? (priceAfterAge - 2000) : priceAfterAge; // 2단계 조조 할인 금액
        int finalPrice = hasTelecomDiscount ? (int)(priceAfterMorning * 0.9) : priceAfterMorning; // 3단계 통신사 할인 및 최종 금액


        System.out.printf("=== CGV 영화 예매 요금 계산서 ===\n");
        System.out.printf("기준 요금: %,d원\n", baseRate);
        System.out.printf("관람자 나이: %d세 (연령 할인율: %d%%)\n",age,(int)(ageDiscountRate * 100));

        System.out.printf("조조 할인 적용 여부: %s (-2,000원)\n",isMorning==true?"적용":"미적용");
        System.out.printf("통신사 제휴 할인: %s (추가 10%%)\n", hasTelecomDiscount ==true?"적용":"미적용");

        System.out.printf("--------------------------------------------\n");
        System.out.printf("최종 결제 금액: %,d원\n",finalPrice);
    }
}

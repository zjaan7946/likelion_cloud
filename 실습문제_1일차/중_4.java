package 실습문제_1일차;
/*
테마파크 기준 요금, 입장객 나이, 우대 대상 여부(1: 우대, 0: 일반), 연간회원권 보유 여부(1: 보유, 0: 일반)를 입력받아 조건에 맞는 최종 입장료를 계산하세요.
- 연간회원권 보유(1): 무료 입장 (할인율 100%)
- 연간회원이 아닐 때:
* 우대 대상(1)이거나 65세 이상 경로: 50% 할인
* 13세 미만 어린이: 30% 할인
* 그 외 일반 고객: 할인 없음 (0%)

[입력]
기준요금 나이 우대여부(1/0) 연간회원여부(1/0)
(예: 40000 10 0 0)
 */
import java.util.Scanner;

public class 중_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int baseRate = sc.nextInt(); // 기준 요금
        int age = sc.nextInt(); // 나이

        boolean isSpecial = sc.nextInt() == 1; // 우대여부
        boolean hasPass = sc.nextInt() == 1; // 연간회원여부

        double discountRate = hasPass ? 1.0 : ((isSpecial || age >= 65) ? 0.5 : (age < 13 ? 0.3 : 0.0)); // 할인율
        int finalPrice = baseRate - (int)(baseRate * discountRate); // 최종 금액


        System.out.printf("=== 에버드림 테마파크 티켓 발권기 ===\n");
        System.out.printf("기준 요금: %,d원\n", baseRate);
        System.out.printf("입장객 나이: %d세\n",age);

        System.out.printf("우대 혜택 적용: %s\n",isSpecial==true?"적용 (우대 대상)":"미적용");
        System.out.printf("연간 회원 여부: %s\n",hasPass==true?"연간회원 (무료)":"일반 고객");
        System.out.printf("--------------------------------------------\n");
        System.out.printf("최종 결제 금액: %,d원 (할인율: %d%%)\n",finalPrice,(int)(discountRate * 100));
    }
}

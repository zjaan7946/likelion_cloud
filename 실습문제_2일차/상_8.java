package 실습문제_2일차;

import java.util.Scanner;

/*
## 풀이 실패
- 해당 코드는 정답 예시 코드

데이터베이스 관리 시스템(DBMS)의 트랜잭션 원자성(ACID Atomicity)을 보장하는 WAL(Write-Ahead Logging) 엔진을 다중 반복문으로 구현하세요.
초기 계좌 잔액은 0원입니다.
배치로 유입되는 총 트랜잭션 세션 수 T가 주어집니다.
외부 반복문으로 T개의 트랜잭션 세션을 순회하고, 각 세션의 K개 명령어와 금액을 1차원 배열(String[] ops, int[] vals)로 구성된 Write-Ahead Log 버퍼에 적재한 뒤 순차 검증합니다.

[각 트랜잭션 입력 정보]
- 첫 줄: 트랜잭션 식별자(문자열 ID, 예: TX_1), 실행할 명령어 개수 K (1 이상)
- 다음 K개 줄: 명령어(ADD 또는 SUB)와 금액 X가 주어집니다.
* ADD X : 임시 변경분(pending)에 X원 가산 (pending += X)
* SUB X : 임시 변경분(pending)에 X원 차감 (단, 현재 계좌 잔액 + pending 에서 X를 차감했을 때 잔액이 마이너스가 되면 '잔액 부족 충돌' 오류 플래그를 설정합니다)

[커밋 및 롤백 규칙]
- K개 작업을 수행하는 동안 잔액 부족 충돌이 한 번도 발생하지 않으면:
임시 변경분을 실제 계좌 잔액(balance)에 영구 반영(커밋)하고, 커밋 건수 +1
출력: "[{ID}] COMMIT 완료 (변동: {+/-변동액}원 | 현재 잔액: {잔액}원)"
- 작업 중 단 한 번이라도 잔액 부족 충돌이 발생하면:
트랜잭션 전체를 무효화(롤백)하여 실제 계좌 잔액을 변경하지 않고, 롤백 건수 +1
출력: "[{ID}] ROLLBACK 취소 (잔액 부족 충돌 | 현재 잔액: {잔액}원)"
- 모든 트랜잭션 세션(T개)이 종료되면 최종 보고서를 출력합니다:
"=== WAL 트랜잭션 최종 정산 ==="
"최종 계좌 잔액: {잔액}원 | 커밋: {커밋수}건 | 롤백: {롤백수}건"

예제 입력1
2
TX_1 3
ADD 5000
ADD 3000
SUB 2000
TX_2 2
SUB 10000
ADD 5000

예제 출력1
[TX_1] COMMIT 완료 (변동: +6000원 | 현재 잔액: 6000원)
[TX_2] ROLLBACK 취소 (잔액 부족 충돌 | 현재 잔액: 6000원)
=== WAL 트랜잭션 최종 정산 ===
최종 계좌 잔액: 6000원 | 커밋: 1건 | 롤백: 1건
 */
public class 상_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tCount = sc.nextInt();

        int balance = 0;
        int commitCount = 0;
        int rollbackCount = 0;

        for (int t = 1; t <= tCount; t++) {
            String txId = sc.next();
            int k = sc.nextInt();

            // 트랜잭션의 작업 명령어와 금액을 1차원 배열(Write-Ahead Log 버퍼)에 적재
            String[] ops = new String[k];
            int[] vals = new int[k];
            for (int i = 0; i < k; i++) {
                ops[i] = sc.next();
                vals[i] = sc.nextInt();
            }

            int pending = 0;
            boolean hasError = false;

            // 로그 배열을 순차적으로 해석 및 검증
            for (int i = 0; i < k; i++) {
                if (ops[i].equals("ADD")) {
                    pending += vals[i];
                } else if (ops[i].equals("SUB")) {
                    if (balance + pending < vals[i]) {
                        hasError = true;
                    } else {
                        pending -= vals[i];
                    }
                }
            }

            if (!hasError) {
                balance += pending;
                commitCount++;
                System.out.printf("[%s] COMMIT 완료 (변동: %+d원 | 현재 잔액: %d원)\n", txId, pending, balance);
            } else {
                rollbackCount++;
                System.out.printf("[%s] ROLLBACK 취소 (잔액 부족 충돌 | 현재 잔액: %d원)\n", txId, balance);
            }
        }

        System.out.println("=== WAL 트랜잭션 최종 정산 ===");
        System.out.printf("최종 계좌 잔액: %d원 | 커밋: %d건 | 롤백: %d건\n", balance, commitCount, rollbackCount);
    }
}

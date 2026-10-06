package 실습문제_2일차;

import java.util.Scanner;

/*
## 풀이 실패
- 해당 코드는 정답 예시 코드

클라우드 SaaS 멀티테넌시(Multi-Tenancy) 환경에서 각 기업(테넌트)별로 API 트래픽을 제어하는 Rate Limiter를 다중 반복문과 continue 문으로 구현하세요.
시스템으로 유입되는 총 테넌트 수 T가 주어집니다.
외부 반복문으로 T개의 테넌트를 순회하고, 각 테넌트의 M개 요청 비용을 1차원 정수 배열(int[] costs)에 저장한 뒤 내부 반복문과 continue 문으로 순회 판별합니다.

[각 테넌트 입력 정보]
- 첫 줄: 테넌트 식별자(문자열 ID), 버킷 최대 용량 C(정수), 초기 잔여 토큰 K(정수), 요청 개수 M(정수)
- 둘째 줄: M개의 요청이 필요로 하는 토큰 수 M개가 공백으로 구분되어 주어집니다.

[처리 및 continue 규칙]
- 비용이 0인 헬스체크(PING/Heartbeat) 요청 (cost == 0):
시스템 상태 확인용 무상 면제 트래픽입니다. 바이패스 카운트(bypass)를 1 증가시키고,
continue 문을 사용하여 아래의 잔여 토큰 검사 및 차감/차단 로직을 실행하지 않고 즉시 다음 요청으로 건너뜁니다!
- 일반 API 요청 (cost > 0):
* 필요 토큰 <= 현재 잔여 토큰: 토큰 차감(tokens -= cost) 후 '허용(allowed)' 건수 +1
* 필요 토큰 > 현재 잔여 토큰: 토큰 차감 없이 '차단(dropped)' 건수 +1
- 테넌트의 M개 요청 처리가 끝나면 테넌트별 처리 요약을 출력합니다:
"[{ID}] 처리 결과: 허용 {허용건수}건 / 차단 {차단건수}건 / 바이패스 {바이패스건수}건 (잔여 토큰: {잔여토큰})"
- 모든 테넌트(T개) 처리가 완료되면 하단에 전체 시스템 통계를 출력합니다:
"=== 전체 시스템 트래픽 집계 ==="
"총 테넌트: {T}개사 | 총 허용: {총허용}건 | 총 차단: {총차단}건 | 총 바이패스: {총바이패스}건"

예제 입력1
2
TenantA 100 30 4
10 0 15 10
TenantB 50 15 4
0 5 10 5

예제 출력1
[TenantA] 처리 결과: 허용 2건 / 차단 1건 / 바이패스 1건 (잔여 토큰: 5)
[TenantB] 처리 결과: 허용 2건 / 차단 1건 / 바이패스 1건 (잔여 토큰: 0)
=== 전체 시스템 트래픽 집계 ===
총 테넌트: 2개사 | 총 허용: 4건 | 총 차단: 2건 | 총 바이패스: 2건
 */
public class 상_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tCount = sc.nextInt();

        int totalAllowed = 0;
        int totalDropped = 0;
        int totalBypass = 0;

        for (int t = 1; t <= tCount; t++) {
            String tenantId = sc.next();
            int capacity = sc.nextInt();
            int tokens = sc.nextInt();
            int m = sc.nextInt();

            // 테넌트의 요청 비용 목록을 1차원 정수 배열에 저장
            int[] costs = new int[m];
            for (int i = 0; i < m; i++) {
                costs[i] = sc.nextInt();
            }

            int allowed = 0;
            int dropped = 0;
            int bypass = 0;

            // 비용 배열을 순회하며 요청 판별
            for (int i = 0; i < costs.length; i++) {
                int cost = costs[i];

                // [continue 활용] 헬스체크(비용 0) 요청은 무상 통과
                if (cost == 0) {
                    bypass++;
                    continue;
                }

                if (tokens >= cost) {
                    tokens -= cost;
                    allowed++;
                } else {
                    dropped++;
                }
            }

            System.out.printf("[%s] 처리 결과: 허용 %d건 / 차단 %d건 / 바이패스 %d건 (잔여 토큰: %d)\n", tenantId, allowed, dropped, bypass, tokens);
            totalAllowed += allowed;
            totalDropped += dropped;
            totalBypass += bypass;
        }

        System.out.println("=== 전체 시스템 트래픽 집계 ===");
        System.out.printf("총 테넌트: %d개사 | 총 허용: %d건 | 총 차단: %d건 | 총 바이패스: %d건\n", tCount, totalAllowed, totalDropped, totalBypass);
    }
}

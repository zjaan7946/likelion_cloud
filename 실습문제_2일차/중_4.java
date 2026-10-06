package 실습문제_2일차;

import java.util.Scanner;

/*
## 풀이 실패
- 해당 코드는 정답 예시 코드

분산 네트워크 환경에서 서버 장애 시 재시도 간격을 점진적으로 늘려 서버 과부하를 막는 '지수 백오프(Exponential Backoff)' 알고리즘을 1차원 정수 배열을 활용하여 시뮬레이션하세요.
기본 대기 시간은 100ms이며, 실패할 때마다 대기 시간이 2배씩 증가합니다(100ms, 200ms, 400ms, 800ms, 1600ms, ...).
최대 재시도 횟수 N을 입력받은 뒤, N개의 통신 결과(1: 성공, 0: 실패)를 크기 N인 1차원 정수 배열(int[] results)에 먼저 저장하세요.
그 후 배열을 순회하면서:
- 성공(1)을 만나면 해당 회차에서 성공 메시지를 출력하고 break로 즉시 루프를 탈출합니다.
- 실패(0)하면 현재 대기 시간을 누적 대기 시간에 더하고 다음 회차 대기 시간을 2배로 증가시킵니다.
- N회 동안 한 번도 성공하지 못하면 '최종 전송 실패' 메시지를 출력합니다.

[입력]
첫째 줄에 최대 재시도 횟수 N이 주어집니다.
둘째 줄에 N개의 결과(0 또는 1)가 공백으로 주어집니다.

[출력]
매 회차마다 다음 서식으로 출력합니다:
- 성공 시: "[회차] 전송 성공! (총 대기 시간: {total}ms)" 출력 후 즉시 종료
- 실패 시: "[회차] 전송 실패 -> 대기 시간: {delay}ms"
- N회 모두 실패 시: "제한 횟수({N}회) 초과로 최종 전송 실패! (총 대기 시간: {total}ms)"

※ 조기 성공, 1회차 성공, 최대 회차 초과 실패 등 다양한 실행 케이스는 아래 [예제 1, 2, 3]을 참고하세요.

예제 입력1
4
0 0 1 0

예제 출력1
[1회차] 전송 실패 -> 대기 시간: 100ms
[2회차] 전송 실패 -> 대기 시간: 200ms
[3회차] 전송 성공! (총 대기 시간: 300ms)
 */
public class 중_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxAttempts = sc.nextInt(); // 최대 재시도 횟수 입력
        int[] results = new int[maxAttempts]; // 재시도 횟수 만큼 배열 생성

        for (int i = 0; i < maxAttempts; i++) { // 생성된 배열
            results[i] = sc.nextInt();
        }

        int currentDelay = 100;
        int totalDelay = 0;
        boolean success = false;

        // 배열 순회하며 지수 백오프 시뮬레이션
        for (int i = 0; i < results.length; i++) {
            int attemptNum = i + 1;
            if (results[i] == 1) {
                System.out.printf("[%d회차] 전송 성공! (총 대기 시간: %dms)\n", attemptNum, totalDelay);
                success = true;
                break;
            } else {
                System.out.printf("[%d회차] 전송 실패 -> 대기 시간: %dms\n", attemptNum, currentDelay);
                totalDelay += currentDelay;
                currentDelay *= 2;
            }
        }
        if (!success) {
            System.out.printf("제한 횟수(%d회) 초과로 최종 전송 실패! (총 대기 시간: %dms)\n", maxAttempts, totalDelay);
        }
    }
}

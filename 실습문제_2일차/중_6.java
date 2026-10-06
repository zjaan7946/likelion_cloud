package 실습문제_2일차;

import java.util.Scanner;

/*
## 풀이 실패
- 해당 코드는 정답 예시 코드

운영체제(OS)의 대표적인 선점형 CPU 스케줄링 기법인 라운드 로빈(Round Robin) 방식을 프로세스 버스트 타임 배열(int[] burst)과 다중 루프로 시뮬레이션하세요.
두 프로세스 P1과 P2의 초기 잔여 작업 시간(Burst Time, ms)을 크기 2인 정수 배열 `int[] burst = new int[]{ p1, p2 };`에 저장하고, 타임 퀀텀 Q(ms)를 입력받습니다.
- P1과 P2를 번갈아가며 CPU에 할당합니다 (외부 while 루프 + 내부 배열 순회 for 루프).
- 매 턴마다 실행 가능한 프로세스는 최대 Q만큼 작업을 처리하고 잔여 시간을 줄입니다. (잔여 시간이 Q보다 작으면 남은 만큼만 처리하고 0으로 완료)
- 한 프로세스가 완료되면 남은 다른 프로세스만 단독으로 턴을 진행합니다.
- 모든 프로세스의 잔여 작업이 0이 되면 스케줄링을 종료합니다.

[입력]
첫째 줄에 P1의 작업 시간, P2의 작업 시간, 타임 퀀텀 Q(모두 정수, ms 단위)가 공백으로 주어집니다.

[출력]
=== CPU 라운드 로빈 스케줄링 시뮬레이션 ===
[턴 {t}] {프로세스} 실행 ({처리}ms 처리, {남은작업 또는 완료})
...
-----------------------------------------
총 실행 턴: {총턴수}턴 | 모든 프로세스 처리 완료

※ 두 프로세스의 버스트 타임 차이에 따른 스케줄링 결과는 아래 [예제 1, 2, 3]을 참고하세요.

예제 입력1
15 25 10

예제 출력1
=== CPU 라운드 로빈 스케줄링 시뮬레이션 ===
[턴 1] P1 실행 (10ms 처리, 남은 작업: 5ms)
[턴 2] P2 실행 (10ms 처리, 남은 작업: 15ms)
[턴 3] P1 실행 (5ms 처리, P1 완료!)
[턴 4] P2 실행 (10ms 처리, 남은 작업: 5ms)
[턴 5] P2 실행 (5ms 처리, P2 완료!)
-----------------------------------------
총 실행 턴: 5턴 | 모든 프로세스 처리 완료
 */
public class 중_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 프로세스 버스트 타임과 프로세스 이름을 배열로 관리
        int[] burst = new int[]{ sc.nextInt(), sc.nextInt() };
        String[] pNames = new String[]{ "P1", "P2" };
        int q = sc.nextInt();

        System.out.println("=== CPU 라운드 로빈 스케줄링 시뮬레이션 ===");
        int turn = 0;

        // 외부 while 루프: 모든 프로세스가 완료될 때까지 반복
        while (burst[0] > 0 || burst[1] > 0) {
            // 내부 for 루프: 프로세스 배열을 순회하며 퀀텀 할당
            for (int i = 0; i < burst.length; i++) {
                if (burst[i] > 0) {
                    turn++;
                    int exec = Math.min(burst[i], q);
                    burst[i] -= exec;
                    if (burst[i] == 0) {
                        System.out.printf("[턴 %d] %s 실행 (%dms 처리, %s 완료!)\n", turn, pNames[i], exec, pNames[i]);
                    } else {
                        System.out.printf("[턴 %d] %s 실행 (%dms 처리, 남은 작업: %dms)\n", turn, pNames[i], exec, burst[i]);
                    }
                }
            }
        }
        System.out.println("-----------------------------------------");
        System.out.printf("총 실행 턴: %d턴 | 모든 프로세스 처리 완료\n", turn);
    }
}

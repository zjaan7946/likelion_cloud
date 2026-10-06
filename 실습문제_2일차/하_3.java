package 실습문제_2일차;
import jdk.jshell.execution.JdiDefaultExecutionControl;

import java.util.Scanner;

/*
서버 모니터링 시스템에서 측정한 CPU 사용률(%), 메모리 사용률(%), 디스크 잔여 공간(GB)의 3가지 지표를 공백으로 구분하여 입력받아 서버의 건전성 상태를 판정하세요.

[경보 판정 조건 (우선순위: 긴급 > 위험 > 주의 > 정상)]
1. 긴급 조치 [EMERGENCY]: (CPU >= 95 AND 메모리 >= 95) OR 디스크 <= 5GB
-> 종합 판정: "[EMERGENCY] 긴급 조치 - 즉각적인 리소스 확보가 필요합니다."
2. 위험 경보 [CRITICAL]: CPU >= 85 OR 메모리 >= 85 OR 디스크 <= 15GB
-> 종합 판정: "[CRITICAL] 위험 경보 - 관리자 점검이 필요합니다."
3. 주의 관찰 [WARNING]: CPU >= 70 OR 메모리 >= 70 OR 디스크 <= 30GB
-> 종합 판정: "[WARNING] 주의 관찰 - 리소스 사용량을 모니터링하세요."
4. 정상 운영 [NORMAL]: 그 외 모든 경우
-> 종합 판정: "[NORMAL] 정상 운영 - 모든 리소스가 안정적입니다."

[입력]
첫째 줄에 CPU 사용률(정수), 메모리 사용률(정수), 디스크 잔여량(정수)이 공백으로 주어집니다.

[출력]
=== 서버 리소스 상태 진단 보고서 ===
CPU 사용률: {cpu}% | 메모리 사용률: {mem}% | 디스크 잔여량: {disk}GB
종합 판정: [{ALERT_LEVEL}] {경보 안내}

※ 긴급, 위험, 디스크 고갈 등 다양한 상황에 대한 입출력은 아래 [예제 1, 2, 3]을 참고하세요.

예제 입력1
88 65 50

예제 출력1
=== 서버 리소스 상태 진단 보고서 ===
CPU 사용률: 88% | 메모리 사용률: 65% | 디스크 잔여량: 50GB
종합 판정: [CRITICAL] 위험 경보 - 관리자 점검이 필요합니다.
 */
public class 하_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cpuUse = sc.nextInt();
        int memUse = sc.nextInt();
        int diskUse = sc.nextInt();

        if ((cpuUse >= 95 && memUse >= 95) || diskUse <= 5) {
            System.out.printf("=== 서버 리소스 상태 진단 보고서 ===\n");
            System.out.printf("CPU 사용률: %d%% | 메모리 사용률: %d%% | 디스크 잔여량: %dGB\n",cpuUse,memUse,diskUse);
            System.out.printf("종합 판정: [EMERGENCY] 긴급 조치 - 즉각적인 리소스 확보가 필요합니다.");
        }
        else if (cpuUse >= 85 || memUse >= 85 || diskUse <= 15) {
            System.out.printf("=== 서버 리소스 상태 진단 보고서 ===\n");
            System.out.printf("CPU 사용률: %d%% | 메모리 사용률: %d%% | 디스크 잔여량: %dGB\n",cpuUse,memUse,diskUse);
            System.out.printf("종합 판정: [CRITICAL] 위험 경보 - 관리자 점검이 필요합니다.");
        }
        else if (cpuUse >= 70 || memUse >= 70 || diskUse <= 30){
            System.out.printf("=== 서버 리소스 상태 진단 보고서 ===\n");
            System.out.printf("CPU 사용률: %d%% | 메모리 사용률: %d%% | 디스크 잔여량: %dGB\n",cpuUse,memUse,diskUse);
            System.out.printf("종합 판정: [WARNING] 주의 관찰 - 리소스 사용량을 모니터링하세요.");
        }
        else {
            System.out.printf("=== 서버 리소스 상태 진단 보고서 ===\n");
            System.out.printf("CPU 사용률: %d%% | 메모리 사용률: %d%% | 디스크 잔여량: %dGB\n",cpuUse,memUse,diskUse);
            System.out.printf("종합 판정: [NORMAL] 정상 운영 - 모든 리소스가 안정적입니다.");
        }
    }
}

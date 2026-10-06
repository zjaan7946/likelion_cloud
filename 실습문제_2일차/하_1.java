package 실습문제_2일차;
import java.util.Scanner;

/*
데이터 접근에 소요된 지연 시간(Latency, 단위: ns, 나노초)을 입력받아, 컴퓨터 메모리 계층 구조(Memory Hierarchy) 피라미드에서 어느 계층에서 데이터를 가져왔는지 판정하고, 캐시 히트(Cache Hit) 여부를 서식에 맞게 출력하세요.

[메모리 계층 및 지연 시간 기준표]
- 1ns 이하 (latency <= 1): "L1 캐시 (L1 Cache)" | 판정: "초고속 캐시 히트"
- 10ns 이하 (latency <= 10): "L2/L3 캐시 (L2/L3 Cache)" | 판정: "캐시 히트"
- 100ns 이하 (latency <= 100): "메인 메모리 (DRAM RAM)" | 판정: "캐시 미스 (메모리 접근)"
- 100,000ns 이하 (latency <= 100000): "초고속 SSD (NVMe Storage)" | 판정: "스토리지 I/O"
- 100,000ns 초과: "하드디스크 / 원격 네트워크 (Disk / Network)" | 판정: "고지연 I/O 발생"

[입력]
첫째 줄에 데이터 접근 지연 시간(ns, 정수)이 주어집니다.

[출력]
지연 시간에 따라 판정된 계층과 캐시 히트 상태를 분석표 서식에 맞추어 출력하세요.
=== 메모리 계층 접근 분석표 ===
소요 지연 시간: {latency}ns
데이터 위치: {layer}
접근 상태 판정: {status}

※ 다양한 상황(캐시 히트, DRAM 접근, 스토리지 I/O 등)에 대한 구체적인 입출력은 아래 [예제 1, 2, 3]을 참고하세요.

예제 입력1
8

예제 출력1
=== 메모리 계층 접근 분석표 ===
소요 지연 시간: 8ns
데이터 위치: L2/L3 캐시 (L2/L3 Cache)
접근 상태 판정: 캐시 히트
 */
public class 하_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long latency = sc.nextLong();

        String layer;
        String status;

        if (latency <= 1){
            layer = "L1 캐시 (L1 Cache)";
            status = "초고속 캐시 히트";
        }
        else if (latency <= 10){
            layer = "L2/L3 캐시 (L2/L3 Cache)";
            status = "캐시 히트";
        }
        else if (latency <= 100){
            layer = "메인 메모리 (DRAM RAM)";
            status = "캐시 미스 (메모리 접근)";
        }
        else if (latency <= 100000){
            layer = "초고속 SSD (NVMe Storage)";
            status = "스토리지 I/O";
        }
        else {
            layer = "하드디스크 / 원격 네트워크 (Disk / Network)";
            status = "고지연 I/O 발생";
        }
        System.out.println("=== 메모리 계층 접근 분석표 ===");
        System.out.printf("소요 지연 시간: %dns\n", latency);
        System.out.printf("데이터 위치: %s\n", layer);
        System.out.printf("접근 상태 판정: %s\n", status);
    }
}

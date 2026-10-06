package 실습문제_2일차;

import java.util.Scanner;

/*
## 풀이 실패
- 해당 코드는 정답 예시 코드

컴퓨터 네트워크 데이터 링크 계층에서 전송되는 프레임(Frame) 시퀀스의 다중 패킷 무결성을 2차원 체크섬(Checksum) 알고리즘으로 검증하세요.
수신된 총 패킷 프레임 개수 P가 주어집니다.
외부 반복문으로 P개의 패킷을 순회하고, 각 패킷의 B개 1바이트 데이터를 1차원 배열(int[] bytes)에 저장한 뒤 배열을 순회하며 합산 및 2차원 체크섬을 계산합니다.

[각 패킷 입력 정보]
- 첫 줄: 패킷 식별자(문자열 ID, 예: PKT-01), 데이터 바이트 개수 B
- 둘째 줄: B개의 바이트 데이터(0~255)와 해당 패킷의 수신 체크섬 C(0~255)가 공백으로 주어집니다.

[체크섬 계산 및 판정 규칙]
- 해당 패킷의 B개 바이트 총합 sum을 구합니다.
- 계산된 체크섬 = (256 - (sum % 256)) % 256
- 계산된 체크섬 == 수신된 체크섬 C:
정상 패킷 통과(PASS) 카운트 +1
출력: "[{ID}] PASS (합계: {sum} | 체크섬: {calcChecksum})"
- 계산된 체크섬 != 수신된 체크섬 C:
손상 패킷 감지(FAIL) 카운트 +1
출력: "[{ID}] FAIL: 손상 감지 (계산: {calcChecksum} != 수신: {recvChecksum})"
- 모든 패킷(P개) 검증이 끝나면 종합 무결성 분석 보고서를 출력합니다:
"=== 네트워크 프레임 무결성 분석 보고서 ==="
"총 패킷: {P}개 | 정상: {정상수}개 | 손상: {손상수}개"

예제 입력1
2
PKT-01 3
10 20 30 196
PKT-02 4
50 50 50 50 56

예제 출력1
[PKT-01] PASS (합계: 60 | 체크섬: 196)
[PKT-02] PASS (합계: 200 | 체크섬: 56)
=== 네트워크 프레임 무결성 분석 보고서 ===
총 패킷: 2개 | 정상: 2개 | 손상: 0개
 */
public class 도전_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pCount = sc.nextInt();

        int passCount = 0;
        int failCount = 0;

        for (int p = 1; p <= pCount; p++) {
            String pktId = sc.next();
            int bCount = sc.nextInt();

            // 패킷 페이로드 바이트들을 1차원 배열에 저장
            int[] bytes = new int[bCount];
            for (int b = 0; b < bCount; b++) {
                bytes[b] = sc.nextInt();
            }

            int recvChecksum = sc.nextInt();

            // 바이트 배열을 순회하며 합산
            int sum = 0;
            for (int b = 0; b < bytes.length; b++) {
                sum += bytes[b];
            }

            int calcChecksum = (256 - (sum % 256)) % 256;

            if (calcChecksum == recvChecksum) {
                passCount++;
                System.out.printf("[%s] PASS (합계: %d | 체크섬: %d)\n", pktId, sum, calcChecksum);
            } else {
                failCount++;
                System.out.printf("[%s] FAIL: 손상 감지 (계산: %d != 수신: %d)\n", pktId, calcChecksum, recvChecksum);
            }
        }

        System.out.println("=== 네트워크 프레임 무결성 분석 보고서 ===");
        System.out.printf("총 패킷: %d개 | 정상: %d개 | 손상: %d개\n", pCount, passCount, failCount);
    }
}

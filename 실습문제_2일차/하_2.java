package 실습문제_2일차;
import java.util.Scanner;
/*
웹 백엔드 서버가 클라이언트에게 전달할 HTTP 응답 상태 코드(Status Code, 정수)를 입력받아 switch-case 문을 사용하여 상태 메시지와 처리 조치를 서식에 맞게 출력하세요.

[상태 코드 매핑 기준]
- 200: 메시지 "200 OK" | 조치 "요청이 성공적으로 처리되었습니다."
- 201: 메시지 "201 Created" | 조치 "새로운 리소스가 정상 생성되었습니다."
- 400: 메시지 "400 Bad Request" | 조치 "잘못된 요청 구문 또는 유효하지 않은 파라미터입니다."
- 401: 메시지 "401 Unauthorized" | 조치 "인증 자격 증명이 유효하지 않거나 누락되었습니다."
- 403: 메시지 "403 Forbidden" | 조치 "접근 권한이 없는 보호된 리소스입니다."
- 404: 메시지 "404 Not Found" | 조치 "요청한 경로의 리소스를 찾을 수 없습니다."
- 500: 메시지 "500 Internal Server Error" | 조치 "서버 내부 처리 중 예기치 않은 오류가 발생했습니다."
- 그 외: 메시지 "UNKNOWN STATUS" | 조치 "정의되지 않은 HTTP 상태 코드입니다."

[입력]
첫째 줄에 HTTP 상태 코드 정수가 주어집니다.

[출력]
=== HTTP 응답 라우팅 결과 ===
상태 코드: {code}
응답 메시지: {statusMessage}
처리 안내: {actionGuide}

※ 구체적인 상태 코드별 입출력 결과는 아래 [예제 1, 2, 3]을 참고하세요.

예제 입력1
404

예제 출력1
=== HTTP 응답 라우팅 결과 ===
상태 코드: 404
응답 메시지: 404 Not Found
처리 안내: 요청한 경로의 리소스를 찾을 수 없습니다.
 */
public class 하_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int statusCode = sc.nextInt();

        switch (statusCode) {
            case 200:
                System.out.printf("=== HTTP 응답 라우팅 결과 ===\n");
                System.out.printf("상태 코드: %d\n", statusCode);
                System.out.printf("응답 메시지: 200 OK\n");
                System.out.printf("처리 안내: 요청이 성공적으로 처리되었습니다.");
                break;
            case 201:
                System.out.printf("=== HTTP 응답 라우팅 결과 ===\n");
                System.out.printf("상태 코드: %d\n", statusCode);
                System.out.printf("응답 메시지: 201 Created\n");
                System.out.printf("처리 안내: 새로운 리소스가 정상 생성되었습니다.");
                break;
            case 400:
                System.out.printf("=== HTTP 응답 라우팅 결과 ===\n");
                System.out.printf("상태 코드: %d\n", statusCode);
                System.out.printf("응답 메시지: 400 Bad Request\n");
                System.out.printf("처리 안내: 잘못된 요청 구문 또는 유효하지 않은 파라미터입니다.");
                break;
            case 401:
                System.out.printf("=== HTTP 응답 라우팅 결과 ===\n");
                System.out.printf("상태 코드: %d\n", statusCode);
                System.out.printf("응답 메시지: 401 Unauthorized\n");
                System.out.printf("처리 안내: 인증 자격 증명이 유효하지 않거나 누락되었습니다.");
                break;
            case 403:
                System.out.printf("=== HTTP 응답 라우팅 결과 ===\n");
                System.out.printf("상태 코드: %d\n", statusCode);
                System.out.printf("응답 메시지: 403 Forbidden\n");
                System.out.printf("처리 안내: 접근 권한이 없는 보호된 리소스입니다.");
                break;
            case 404:
                System.out.printf("=== HTTP 응답 라우팅 결과 ===\n");
                System.out.printf("상태 코드: %d\n", statusCode);
                System.out.printf("응답 메시지: 404 Not Found\n");
                System.out.printf("처리 안내: 요청한 경로의 리소스를 찾을 수 없습니다.");
                break;
            case 500:
                System.out.printf("=== HTTP 응답 라우팅 결과 ===\n");
                System.out.printf("상태 코드: %d\n", statusCode);
                System.out.printf("응답 메시지: 500 Internal Server Error\n");
                System.out.printf("처리 안내: 서버 내부 처리 중 예기치 않은 오류가 발생했습니다.");
                break;
            default:
                System.out.printf("=== HTTP 응답 라우팅 결과 ===\n");
                System.out.printf("상태 코드: %d\n", statusCode);
                System.out.printf("응답 메시지: UNKNOWN STATUS\n");
                System.out.printf("처리 안내: 정의되지 않은 HTTP 상태 코드입니다.");
                break;
        }
    }
}

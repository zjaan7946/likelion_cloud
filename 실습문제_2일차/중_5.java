package 실습문제_2일차;

import java.util.Scanner;

/*
## 풀이 실패
- 해당 코드는 정답 예시 코드

정답 숫자 target(1~100)과 최대 시도 횟수 K, 그리고 플레이어가 입력한 K개의 추측 숫자를 1차원 정수 배열(int[] guesses)에 저장하여 Up-Down 게임 판정을 진행하세요.
배열에 저장된 추측값들을 순차적으로 순회하며 판정합니다:
- 추측값 > 정답: "[i회차] 추측: X -> DOWN! 더 작은 수를 입력하세요."
- 추측값 < 정답: "[i회차] 추측: X -> UP! 더 큰 수를 입력하세요."
- 추측값 == 정답: "[i회차] 추측: X -> 정답입니다! i회 만에 맞추셨습니다!" 출력 후 break로 즉시 루프 탈출
- K회 내에 맞추지 못하면: "아쉽습니다. 제한 횟수(K회) 초과로 실패! 정답은 target였습니다." 출력

[입력]
첫째 줄에 정답 숫자 target과 최대 시도 횟수 K가 공백으로 주어집니다.
둘째 줄에 K개의 추측 숫자가 공백으로 주어집니다.

[출력]
각 회차별 추측 결과 및 최종 성공/실패 여부를 서식에 맞추어 출력합니다.

※ 중간 정답 성공, 빠른 회차 성공, 횟수 초과 실패 등 다양한 게임 시뮬레이션은 아래 [예제 1, 2, 3]을 참고하세요.

예제 입력1
50 4
30 70 45 50

예제 출력1
[1회차] 추측: 30 -> UP! 더 큰 수를 입력하세요.
[2회차] 추측: 70 -> DOWN! 더 작은 수를 입력하세요.
[3회차] 추측: 45 -> UP! 더 큰 수를 입력하세요.
[4회차] 추측: 50 -> 정답입니다! 4회 만에 맞추셨습니다!
 */
public class 중_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int attempts = sc.nextInt();

        // 플레이어의 추측값들을 저장할 1차원 배열
        int[] guesses = new int[attempts];
        for (int i = 0; i < attempts; i++) {
            guesses[i] = sc.nextInt();
        }

        boolean isCorrect = false;

        // 추측값 배열을 순회하며 판정
        for (int i = 0; i < guesses.length; i++) {
            int attemptNum = i + 1;
            int guess = guesses[i];

            if (guess == target) {
                System.out.printf("[%d회차] 추측: %d -> 정답입니다! %d회 만에 맞추셨습니다!\n", attemptNum, guess, attemptNum);
                isCorrect = true;
                break;
            } else if (guess < target) {
                System.out.printf("[%d회차] 추측: %d -> UP! 더 큰 수를 입력하세요.\n", attemptNum, guess);
            } else {
                System.out.printf("[%d회차] 추측: %d -> DOWN! 더 작은 수를 입력하세요.\n", attemptNum, guess);
            }
        }

        if (!isCorrect) {
            System.out.printf("아쉽습니다. 제한 횟수(%d회) 초과로 실패! 정답은 %d였습니다.\n", attempts, target);
        }
    }
}

package 실습문제_1일차;
import java.util.Scanner;

public class 도전_6 {
    public static final int FLAG_CPU   = 1 << 0; // 1 (감점 25)
    public static final int FLAG_MEM   = 1 << 1; // 2 (감점 25)
    public static final int FLAG_DISK  = 1 << 2; // 4 (감점 20)
    public static final int FLAG_NET   = 1 << 3; // 8 (감점 15)
    public static final int FLAG_DB    = 1 << 4; // 16 (감점 30)
    public static final int FLAG_PWR   = 1 << 5; // 32 (감점 40)
    public static final int FLAG_ISOL  = 1 << 7; // 128 (격리 플래그)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int statusCode = sc.nextInt();

        boolean isCpu = (statusCode & FLAG_CPU) != 0;
        boolean isMem = (statusCode & FLAG_MEM) != 0;
        boolean isDisk = (statusCode & FLAG_DISK) != 0;
        boolean isNet = (statusCode & FLAG_NET) != 0;
        boolean isDb = (statusCode & FLAG_DB) != 0;
        boolean isPwr = (statusCode & FLAG_PWR) != 0;

        int penalty = (isCpu ? 25 : 0)
                + (isMem ? 25 : 0)
                + (isDisk ? 20 : 0)
                + (isNet ? 15 : 0)
                + (isDb ? 30 : 0)
                + (isPwr ? 40 : 0);

        int healthScore = 100 - penalty;
        healthScore = (healthScore < 0) ? 0 : healthScore;

        String grade = (healthScore >= 80) ? "정상 (HEALTHY)" : ((healthScore >= 50) ? "주의 (WARNING)" : "위험 (CRITICAL)");

        boolean needsIsolation = (isCpu && isDb) || isPwr;
        int newStatusCode = needsIsolation ? (statusCode | FLAG_ISOL) : statusCode;

        String binInitial = String.format("%8s", Integer.toBinaryString(statusCode)).replace(' ', '0');
        String binNew = String.format("%8s", Integer.toBinaryString(newStatusCode)).replace(' ', '0');

        System.out.println("=== 클라우드 인프라 8비트 관제 엔진 ===");
        System.out.printf("초기 상태 코드: %d (2진수: %s)\n", statusCode, binInitial);
        System.out.printf("- CPU 과부하 (1): %s\n", isCpu ? "감지 (감점 -25)" : "정상");
        System.out.printf("- 메모리 고갈 (2): %s\n", isMem ? "감지 (감점 -25)" : "정상");
        System.out.printf("- 디스크 부족 (4): %s\n", isDisk ? "감지 (감점 -20)" : "정상");
        System.out.printf("- 네트워크 손실 (8): %s\n", isNet ? "감지 (감점 -15)" : "정상");
        System.out.printf("- DB 락 (16): %s\n", isDb ? "감지 (감점 -30)" : "정상");
        System.out.printf("- 전원 불안정 (32): %s\n", isPwr ? "감지 (감점 -40)" : "정상");
        System.out.println("----------------------------------------");
        System.out.printf("시스템 건전성 점수: %d점 / 100점\n", healthScore);
        System.out.printf("종합 상태 등급: %s\n", grade);
        System.out.printf("긴급 페일오버 격리: %s\n", needsIsolation ? String.format("발령 (신규 코드: %d / %s)", newStatusCode, binNew) : "미발령 (정상 유지)");
    }
}
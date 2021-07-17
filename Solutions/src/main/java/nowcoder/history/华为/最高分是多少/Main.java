package nowcoder.history.华为.最高分是多少;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> r = new LinkedList<>();
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[] scores = new int[N];
            for (int i = 0; i < N; i++) scores[i] = scanner.nextInt();
            for (int i = 0; i < M; i++) {
                char O = scanner.next().toCharArray()[0];
                switch (O) {
                    case 'Q':
                        int start = scanner.nextInt() - 1, end = scanner.nextInt() - 1;
                        if (start > end) {
                            start = start + end;
                            end = start - end;
                            start = start - end;
                        }
                        int maxScore = 0;
                        for (int j = start; j <= end; j++) {
                            maxScore = Math.max(maxScore, scores[j]);
                        }
                        r.offer(maxScore);
                        break;
                    case 'U':
                        int id = scanner.nextInt() - 1, score = scanner.nextInt();
                        scores[id] = score;
                        break;
                    default:
                        break;
                }
            }
        }
        r.stream().forEach(x -> System.out.println(x));
    }
}

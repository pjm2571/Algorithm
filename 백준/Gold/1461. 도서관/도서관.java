import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 책의 개수
        int m = sc.nextInt(); // 한 번에 옮길 수 있는 최대 개수

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num > 0) positive.add(num);
            else negative.add(-num); // 음수를 절댓값으로 바꿔 저장
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative, Collections.reverseOrder());

        int max = 0;
        if (!positive.isEmpty()) max = Math.max(max, positive.get(0));
        if (!negative.isEmpty()) max = Math.max(max, negative.get(0));

        int sum = 0;

        // 왕복 이동 (양수 쪽)
        for (int i = 0; i < positive.size(); i += m) {
            sum += positive.get(i) * 2;
        }

        // 왕복 이동 (음수 쪽)
        for (int i = 0; i < negative.size(); i += m) {
            sum += negative.get(i) * 2;
        }

        // 마지막에 한 번은 편도로
        sum -= max;

        System.out.println(sum);
    }
}

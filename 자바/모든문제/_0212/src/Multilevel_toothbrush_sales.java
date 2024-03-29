import java.util.HashMap;
import java.util.Map;

public class Multilevel_toothbrush_sales {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> memberIndexMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            memberIndexMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            String now = seller[i];
            int profit = 100 * amount[i];

            while (!now.equals("-")) {
                int profileForParent = profit / 10;
                int nowProfit = profit - profileForParent;

                answer[memberIndexMap.get(now)] += nowProfit;
                now = parentMap.get(now);
                profit /= 10;

                if (profit < 1) {
                    break;
                }
            }
        }
        return answer;
    }
}

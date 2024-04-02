package view;

import constant.Reward;
import model.Lotto;
import model.Statistics;
import java.util.List;
import static constant.LottoConstants.*;

public class OutputView {

    private OutputView() {
    }

    public static void printPaymentAmount(int amount) {
        System.out.println(amount + AMOUNT_MESSAGE + "\n");
    }

    public static void printLottosNumbers(List<Lotto> lottos) {
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers().getNumbers());
        }
        System.out.println("\n");
    }

    public static void printResultList(Statistics statistics) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.printf(RESULT_LIST_MESSAGE, 3, Reward.FIFTH.getPrice(), statistics.getResult().get(Reward.FIFTH));
        System.out.printf(RESULT_LIST_MESSAGE, 4, Reward.FOURTH.getPrice(), statistics.getResult().get(Reward.FOURTH));
        System.out.printf(RESULT_LIST_MESSAGE, 5, Reward.THIRD.getPrice(), statistics.getResult().get(Reward.THIRD));
        System.out.printf(RESULT_LIST_MESSAGE, 5, Reward.SECOND.getPrice(), statistics.getResult().get(Reward.SECOND));
        System.out.printf(RESULT_LIST_MESSAGE, 6, Reward.FIRST.getPrice(), statistics.getResult().get(Reward.FIRST));
        System.out.printf(RESULT_REWARD_RATE, statistics.getStatistics());
    }
}

package model;

import constant.Reward;
import java.util.*;

import static constant.LottoConstants.*;

public class Statistics {
    private Map<Reward, Integer> result;
    private int paymentAmount;

    private Statistics() {
    }

    public Statistics(int paymentAmount) {
        result = new HashMap<>();
        generateResultMap();
        this.paymentAmount = paymentAmount;
    }

    private void generateResultMap() {
        result.put(Reward.FIRST, 0);
        result.put(Reward.SECOND, 0);
        result.put(Reward.THIRD, 0);
        result.put(Reward.FOURTH, 0);
        result.put(Reward.FIFTH, 0);
    }

    public void updateResult(int correctNumbersCount, boolean bonus){
        Arrays.stream(Reward.values())
                .filter(reward -> (reward.getMatchCount() == correctNumbersCount) && (!reward.getBonus() || bonus))
                .findFirst()
                .ifPresent(reward -> result.put(reward, result.get(reward) + 1));
    }


    public double getStatistics() {
        if (paymentAmount < LOTTO_PRICE) {
            return 0;
        }

        int rewardAmount = Arrays.stream(Reward.values())
                .mapToInt(reward -> reward.getPrice() * result.get(reward))
                .sum();

        return (double) rewardAmount / paymentAmount;
    }

    public Map<Reward, Integer> getResult(){
        return Collections.unmodifiableMap(result);
    }
}

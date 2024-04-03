package model;

import constant.LottoRankInfo;
import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<LottoRankInfo, Integer> result;

    public LottoResult() {
        result = Arrays.stream(LottoRankInfo.values())
            .collect(Collectors.toMap(lottoRankInfo -> lottoRankInfo, lottoRankInfo -> 0));
    }

    public void updateResult(int correctNumbersCount, boolean bonus){
        Arrays.stream(LottoRankInfo.values())
            .sorted(Comparator.comparingInt(LottoRankInfo::getPrize).reversed())
            .filter(lottoRankInfo -> (lottoRankInfo.getMatchCount() == correctNumbersCount) && (!lottoRankInfo.getBonus() || bonus))
            .findFirst()
            .ifPresent(lottoRankInfo -> result.put(lottoRankInfo, result.get(lottoRankInfo) + 1));
    }

    public Money getLottoPrize() {
        return new Money(Arrays.stream(LottoRankInfo.values())
            .mapToInt(lottoRankInfo -> lottoRankInfo.getPrize() * result.get(lottoRankInfo))
            .sum());
    }

    public Map<LottoRankInfo, Integer> getResult(){
        return Collections.unmodifiableMap(result);
    }
}

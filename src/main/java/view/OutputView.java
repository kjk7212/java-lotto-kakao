package view;

import constant.LottoRankInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static constant.LottoConstants.*;

public class OutputView {

	public static void printNumOfLotto(int numOfLotto) {
		System.out.println(numOfLotto + LOTTO_AMOUNT_MESSAGE);
	}

	public static void printLottoNumbers(List<List<Integer>> lottolist) {
		lottolist.forEach(System.out::println);
		System.out.println();
	}

	public static void printLottoResult(Map<LottoRankInfo, Integer> lottoResult, double ratio) {
		System.out.println(STATISTICS_MESSAGE);

		Arrays.stream(LottoRankInfo.values())
			.forEach(rank -> printRankAggregation(rank, lottoResult.get(rank)));

		System.out.printf(RESULT_REWARD_RATE, ratio);
	}

	private static void printRankAggregation(LottoRankInfo rankInfo, int numOfWinning){
		if (rankInfo.getBonus()){
			System.out.printf(LOTTO_RESULT_WITH_BONUS, rankInfo.getMatchCount(), rankInfo.getPrize(), numOfWinning);
		}
		if (!rankInfo.getBonus()){
			System.out.printf(LOTTO_RESULT_WITHOUT_BONUS, rankInfo.getMatchCount(), rankInfo.getPrize(), numOfWinning);
		}
	}
}

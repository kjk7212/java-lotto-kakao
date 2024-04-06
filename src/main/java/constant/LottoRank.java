package constant;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoRank {

	BLANK(0,0,false),
	FIFTH(5_000, 3, false),
	FOURTH(50_000, 4, false),
	THIRD(1_500_000, 5, false),
	SECOND(30_000_000, 5, true),
	FIRST(2_000_000_000, 6, false);

	private final int prize;
	private final int matchCount;
	private final boolean bonus;

	LottoRank(int prize, int matchCount, boolean bonus) {
		this.prize = prize;
		this.matchCount = matchCount;
		this.bonus = bonus;
	}

	public int getPrize() {
		return prize;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public boolean getBonus() {
		return bonus;
	}

	public static LottoRank rankMatch(int correctNumbersCount, boolean bonus){
		return Arrays.stream(values())
			.sorted(Comparator.comparingInt(LottoRank::getPrize).reversed())
			.filter(lottoRank -> (lottoRank.getMatchCount() == correctNumbersCount) && (!lottoRank.getBonus() || bonus))
			.findFirst().orElse(BLANK);
	}
}

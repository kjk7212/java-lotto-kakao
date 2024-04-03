package model;

public class LottoMatcher {
	private final WinningLottoNumbers winningLottoNumbers;
	private final LottoResult lottoResult;

	public LottoMatcher(WinningLottoNumbers winningLottoNumbers){
		this.winningLottoNumbers = winningLottoNumbers;
		this.lottoResult = new LottoResult();
	}

	public void matchLottoList(LottoList lottoList) {
		lottoList.getLottoList().forEach(this::matchLotto);
	}

	private void matchLotto(Lotto lotto){
		int matchResult = winningLottoNumbers.matchNumbers(lotto);
		boolean hasBonus = winningLottoNumbers.hasBonusNumber(lotto);
		lottoResult.updateResult(matchResult, hasBonus);
	}

	public LottoResult getLottoResult() {
		return lottoResult;
	}
}

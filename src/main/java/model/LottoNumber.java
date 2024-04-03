package model;

import static util.Validator.*;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
	private final int lottoNumber;

	public LottoNumber(String strLottoNumber) {
		validateIsNumber(strLottoNumber);
		int intLottoNumber = Integer.parseInt(strLottoNumber);
		validateLottoNumberRange(intLottoNumber);
		this.lottoNumber = intLottoNumber;
	}

	public LottoNumber(int lottoNumber) {
		validateLottoNumberRange(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	public boolean isSame(LottoNumber lottoNumber) {
		return this.lottoNumber == lottoNumber.lottoNumber;
	}

	public int getLottoNumber() {
		return lottoNumber;
	}

	@Override
	public int compareTo(LottoNumber number) {
		return this.lottoNumber - number.lottoNumber;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		LottoNumber lottoNumber = (LottoNumber) object;
		return this.lottoNumber == lottoNumber.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}
}

package model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
	LottoNumber lottoNumber;

	@Test
	@DisplayName("숫자_아닌걸_넣을때_테스트")
	void notNumberTest() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() ->
				lottoNumber = new LottoNumber("테스트")
			);

	}

	@Test
	@DisplayName("숫자_범위_넘었을때_테스트")
	void numberRangeTest() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() ->
				lottoNumber = new LottoNumber(46)
			);
	}

	@Test
	@DisplayName("같은_숫자_확인_테스트")
	void matchSameNumberTest() {
		lottoNumber = new LottoNumber(45);
		LottoNumber lottoNumber2 = new LottoNumber(45);

		assertThat(lottoNumber2.equals(lottoNumber)).isEqualTo(true);
	}

	@Test
	@DisplayName("다른_숫자_확인_테스트")
	void matchDifferentNumber() {
		lottoNumber = new LottoNumber(45);
		LottoNumber lottoNumber2 = new LottoNumber(44);

		assertThat(lottoNumber2.equals(lottoNumber)).isEqualTo(false);
	}

}
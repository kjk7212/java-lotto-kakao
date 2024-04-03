package model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoNumberTest {
	LottoNumber lottoNumber;

	@Test
	void 숫자_아닌걸_넣을때_테스트() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() ->
				lottoNumber = new LottoNumber("테스트")
			);

	}
	@Test
	void 숫자_범위_넘었을때_테스트() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() ->
				lottoNumber = new LottoNumber(46)
			);
	}
	@Test
	void 같은_숫자_확인_테스트() {
		lottoNumber = new LottoNumber(45);
		LottoNumber lottoNumber2 = new LottoNumber(45);

		assertThat(lottoNumber2.isSame(lottoNumber)).isEqualTo(true);
	}
	@Test
	void 다른_숫자_확인_테스트() {
		lottoNumber = new LottoNumber(45);
		LottoNumber lottoNumber2 = new LottoNumber(44);

		assertThat(lottoNumber2.isSame(lottoNumber)).isEqualTo(false);
	}

}
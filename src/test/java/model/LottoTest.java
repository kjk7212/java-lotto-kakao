package model;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class LottoTest {
	Lotto lotto;
	@Test
	void 로또_길이_테스트() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() ->
				lotto = new Lotto(IntStream.range(1,10).mapToObj(LottoNumber::new).collect(Collectors.toList()))
			);
	}

	@Test
	void 로또_숫자_중복_테스트() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() ->
				lotto = new Lotto(IntStream.generate(() -> 5).limit(5).mapToObj(LottoNumber::new).collect(Collectors.toList()))
			);
	}

	@Test
	void 로또_값_한_개_매칭_테스트() {
		lotto = new Lotto(IntStream.range(1,7).mapToObj(LottoNumber::new).collect(Collectors.toList()));

		assertThat(lotto.hasLottoNumber(new LottoNumber(1))).isEqualTo(true);
	}

	@Test
	void 로또끼리_매칭_테스트() {
		lotto = new Lotto(IntStream.range(1,7).mapToObj(LottoNumber::new).collect(Collectors.toList()));
		Lotto lotto2 = new Lotto(IntStream.range(1,7).mapToObj(LottoNumber::new).collect(Collectors.toList()));

		assertThat(lotto.matchLottoNumbers(lotto2)).isEqualTo(6);
	}
}
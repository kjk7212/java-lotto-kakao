package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {
	Money money;

	@BeforeEach
	void setUp() {
		money = new Money(1000);
	}

	@Test
	void 몇개_살_수_있는지_테스트() {
		assertThat(money.numOfLottoCanBuy()).isEqualTo(1);
	}

	@Test
	void 수익률_테스트() {
		assertThat(money.calculateReturnRatio(new Money(1000))).isEqualTo(1);
	}
}
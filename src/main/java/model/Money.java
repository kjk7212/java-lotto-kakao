package model;

import static constant.LottoConstants.*;
import static util.Validator.*;

import java.util.Objects;

public class Money {
	private final int money;

	public Money(String strMoney) {
		validateIsNumber(strMoney);
		int intMoney = Integer.parseInt(strMoney);
		validateCanNotBuyLotto(intMoney);
		this.money = intMoney;
	}

	public Money(int money){
		this.money = money;
	}

	public int numOfLottoCanBuy() {
		return money / LOTTO_PRICE;
	}

	public double calculateReturnRatio(Money money){
		return (double) this.money / (money.numOfLottoCanBuy() * LOTTO_PRICE);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		Money money = (Money) object;
		return this.money == money.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}

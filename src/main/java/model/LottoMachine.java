package model;

public interface LottoMachine {
    Lotto drawLotto();

    LottoList drawMaximumLottoByMoney(Money money);
}

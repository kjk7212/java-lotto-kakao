package model;

public interface LottoMachine {
    Lotto drawLotto();

    Lottos drawMaximumLottoByMoney(Money money);
}

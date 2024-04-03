package controller;

import static view.InputView.*;
import static view.OutputView.*;

import model.LottoList;
import model.LottoMachine;
import model.LottoMachineImpl;
import model.LottoMatcher;
import model.LottoNumber;
import model.LottoResult;
import model.Money;
import model.WinningLottoNumbers;

public class LottoGame {
    private final LottoMachine lottoMachine;
    private LottoList lottoList;
    private WinningLottoNumbers winningLottoNumbers;

    public LottoGame() {
        lottoMachine = new LottoMachineImpl();
    }

    public void run (){
        Money money = settingMoney();
        settingAutoGeneratedLotto(money);
        settingWinningNumbers();
        lottoStart(money);
    }

    private Money settingMoney() {
        Money money = new Money(readPaymentAmount());
        printNumOfLotto(money.numOfLottoCanBuy());
        return money;
    }

    private void settingAutoGeneratedLotto(Money money){
        lottoList = lottoMachine.drawMaximumLottoByMoney(money);
        printLottoNumbers(lottoList.getLottoNumbersList());
    }

    private void settingWinningNumbers() {
        String winningNumbersUserInput = readWinningNumbers();
        LottoNumber bonus = new LottoNumber(readBonusNumber());
        winningLottoNumbers = new WinningLottoNumbers(winningNumbersUserInput, bonus);
    }

    private void lottoStart(Money money) {
        LottoMatcher lottoMatcher = new LottoMatcher(winningLottoNumbers);
        lottoMatcher.matchLottoList(lottoList);

        LottoResult lottoResult = lottoMatcher.getLottoResult();
        printLottoResult(lottoResult.getResult(), lottoResult.getLottoPrize().calculateReturnRatio(money));
    }
}

package model;

import static util.Validator.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private final LottoNumber bonus;
    private final Lotto winningNumbers;

    public WinningLottoNumbers(String winningNumbers, LottoNumber bonus) {
        String[] number = winningNumbers.replaceAll(" ", "").split(",");
        this.winningNumbers = new Lotto(Arrays.stream(number)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));

        validateBonusNotInWinningNumbers(this.winningNumbers, bonus);
        this.bonus = bonus;
    }

    public int matchNumbers(Lotto lotto){
        return this.winningNumbers.matchLottoNumbers(lotto);
    }

    public boolean hasBonusNumber(Lotto lotto){
        return lotto.hasLottoNumber(bonus);
    }
}

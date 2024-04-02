package model;

public class WinningNumbers {
    private final Bonus bonus;
    private final Numbers winningNumbers;

    public WinningNumbers(Numbers winningNumbers, Bonus bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public int matchNumbers(Numbers numbers){
        return this.winningNumbers.matchNumbers(numbers);
    }

    public boolean hasBonusNumber(Numbers numbers){
        return numbers.hasNumber(bonus.getBonus());
    }

}

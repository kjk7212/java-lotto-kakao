package model;
import view.ExceptionMessage;

import static constant.LottoConstants.*;

public class Bonus {
    private int bonus;

    private Bonus(){
    }

    public Bonus(String number) {
        this(Integer.parseInt(number));
    }

    public Bonus(int number) {
        rangeNumberCheck(number);
        this.bonus = number;
    }

    private void rangeNumberCheck(int number) {
        if (number < NUMBER_LOWER_BOUND || number > NUMBER_UPPER_BOUND) {
            ExceptionMessage.rangeException();
            throw new IllegalArgumentException();
        }
    }

    public int getBonus() {
        return this.bonus;
    }

}

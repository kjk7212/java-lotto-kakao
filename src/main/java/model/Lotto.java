package model;

import view.Validator;

import static constant.LottoConstants.*;
public class Lotto {
    private Numbers numbers;

    private Lotto(){
    }

    public Lotto(Numbers numbers) {
        Validator.numberSizeCheck(numbers);
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }
}

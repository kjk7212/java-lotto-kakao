package model;

import view.ExceptionMessage;
import view.Validator;

import java.util.Collections;
import java.util.List;

public class Numbers {
    private List<Integer> numbers;

    private Numbers() {
    }

    public Numbers(List<Integer> numbers, boolean isUserInput){
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getSize(){
        return this.numbers.size();
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int matchNumbers(Numbers numbers){
        return (int) this.numbers.stream().filter(numbers.numbers::contains).count();
    }

    private void validateNumbers(List<Integer> numbers) {
        Validator.numberSizeCheck(numbers);

        for (int number : numbers) {
            Validator.rangeNumberCheck(number);
        }
    }

    public void shuffle() {
        Collections.shuffle(numbers);
    }
}

package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static constant.LottoConstants.*;

public class LottoMachineImpl implements LottoMachine {
    private Numbers numbers;

    public LottoMachineImpl() {
        numbers = new Numbers(generateNumbers());
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = NUMBER_LOWER_BOUND; i <= NUMBER_UPPER_BOUND; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public Numbers extractLottoNumbers() {
        numbers.shuffle();
        List<Integer> extractNumbers = new ArrayList<>(numbers.getNumbers().subList(0, NUMBER_COUNT));
        Collections.sort(extractNumbers);
        return new Numbers(extractNumbers);
    }
}

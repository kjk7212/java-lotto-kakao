package view;

import java.util.List;

import static constant.LottoConstants.*;
import model.*;

public class Validator {

    private Validator() {
    }

    public static void checkZeroNumber(int paymentAmount) {
        if (paymentAmount == 0) {
            ExceptionMessage.naturalNmberException();
            throw new IllegalArgumentException();
        }
    }

    public static void checkUnitNumber(int paymentAmount) {
        if (paymentAmount % LOTTO_PRICE != 0) {
            ExceptionMessage.inputPriceException();
            throw new IllegalArgumentException();
        }
    }

    public static int checkTypeNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }

    public static void numberSizeCheck(Numbers numbers) {
        if (numbers.getSize() != NUMBER_COUNT) {
            ExceptionMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }

    public static void numberSizeCheck(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            ExceptionMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }

    public static void rangeNumberCheck(int number) {
        if (number < NUMBER_LOWER_BOUND || number > NUMBER_UPPER_BOUND) {
            ExceptionMessage.rangeException();
            throw new IllegalArgumentException();
        }
    }
}

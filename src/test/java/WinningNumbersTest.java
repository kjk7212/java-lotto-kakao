import model.Bonus;
import model.Numbers;
import model.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {
    WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(new Numbers(Arrays.asList(1,2,3,4,5,6)), new Bonus(45));
    }

    @Test
    void 숫자_매칭_테스트(){
        Numbers numbers = new Numbers(Arrays.asList(1,2,3,4,5,45));
        assertThat(winningNumbers.matchNumbers(numbers)).isEqualTo(5);
    }

    @Test
    void 보너스_매칭_테스트(){
        Numbers numbers = new Numbers(Arrays.asList(1,2,3,4,5,45));
        assertThat(winningNumbers.hasBonusNumber(numbers)).isEqualTo(true);
    }
}

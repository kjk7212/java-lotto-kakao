import org.junit.jupiter.api.Test;
import model.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.*;


public class NumbersTest {
    Numbers numbers;

    @Test
    void 숫자_생성_테스트() {
        numbers = new Numbers(Arrays.asList(1,2,3,4,5,45));

        assertThat(numbers.getNumbers()).isEqualTo(Arrays.asList(1,2,3,4,5,45));
    }

    @Test
    void 숫자_범위_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        numbers = new Numbers(Arrays.asList(1,2,3,4,5,46), true)
                );
    }

    @Test
    void 숫자_길이_테스트() {
        numbers = new Numbers(Arrays.asList(1,2,3,4,5,45));
        assertThat(numbers.getSize()).isEqualTo(6);
    }

    @Test
    void 숫자_매치_테스트() {
        numbers = new Numbers(Arrays.asList(1,2,3,4,5,45));
        Numbers numbers2 = new Numbers(Arrays.asList(1,2,3,4,5,45));

        assertThat(numbers.matchNumbers(numbers2)).isEqualTo(6);
    }
    @Test
    void 숫자_포함_테스트() {
        numbers = new Numbers(Arrays.asList(1,2,3,4,5,45));

        assertThat(numbers.hasNumber(3)).isEqualTo(true);
    }

}

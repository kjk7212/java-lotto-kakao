import model.Lotto;
import model.Numbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoTest {
    Lotto lotto;

    @Test
    void 로또_길이_테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        lotto = new Lotto(new Numbers(Arrays.asList(1,2,3,4,5,45,43)))
                );
    }
}

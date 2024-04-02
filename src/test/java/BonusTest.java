import model.Bonus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class BonusTest {
    Bonus bonus;

    @Test
    void 보너스_범위_테스트(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        bonus = new Bonus(46)
                );
    }
}

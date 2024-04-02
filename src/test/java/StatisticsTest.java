import constant.Reward;
import model.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class StatisticsTest {

    Statistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new Statistics(1000);
    }
    @Test
    void 집계_테스트() {
        statistics.updateResult(6,false);
        statistics.updateResult(5,true);
        statistics.updateResult(5,false);

        Map<Reward, Integer> result = statistics.getResult();

        assertThat(result.get(Reward.FIRST)).isEqualTo(1);
        assertThat(result.get(Reward.SECOND)).isEqualTo(1);
        assertThat(result.get(Reward.THIRD)).isEqualTo(1);
    }

    @Test
    void 통계_테스트() {
        statistics.updateResult(6, false);
        statistics.updateResult(5, true);
        statistics.updateResult(5, false);

        double result = statistics.getStatistics();

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(2031500);
        });
    }
}

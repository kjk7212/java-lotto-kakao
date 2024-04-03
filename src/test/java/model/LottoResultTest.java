package model;

import constant.LottoRankInfo;
import model.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class LottoResultTest {

    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    void 집계_테스트() {
        lottoResult.updateResult(6,false);
        lottoResult.updateResult(5,true);
        lottoResult.updateResult(5,false);

        Map<LottoRankInfo, Integer> result = lottoResult.getResult();
        System.out.println(result);
        assertThat(result.get(LottoRankInfo.FIRST)).isEqualTo(1);
        assertThat(result.get(LottoRankInfo.SECOND)).isEqualTo(1);
        assertThat(result.get(LottoRankInfo.THIRD)).isEqualTo(1);
    }

    @Test
    void 통계_테스트() {
        lottoResult.updateResult(3, false);

        assertThat(lottoResult.getLottoPrize()).isEqualTo(new Money(5000));
    }
}

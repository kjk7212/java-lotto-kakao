package model;

import model.WinningLottoNumbers;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoNumbersTest {
    WinningLottoNumbers winningLottoNumbers;

    @BeforeEach
    void setUp() {
        winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,6", new LottoNumber(8));
    }

    @Test
    void 보너스_매칭_테스트() {
        Lotto lotto = new Lotto(IntStream.range(3,9).mapToObj(LottoNumber::new).collect(Collectors.toList()));

        assertThat(winningLottoNumbers.hasBonusNumber(lotto)).isEqualTo(true);
    }

    @Test
    void 로또_매칭_테스트() {
        Lotto lotto = new Lotto(IntStream.range(1,7).mapToObj(LottoNumber::new).collect(Collectors.toList()));

        assertThat(winningLottoNumbers.matchNumbers(lotto)).isEqualTo(6);
    }
}

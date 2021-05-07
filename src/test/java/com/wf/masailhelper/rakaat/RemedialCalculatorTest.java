package com.wf.masailhelper.rakaat;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.wf.masailhelper.rakaat.Action.SECOND_SUJOOD;
import static com.wf.masailhelper.rakaat.Salaat.DHUHR;
import static org.assertj.core.api.Assertions.assertThat;

class RemedialCalculatorTest {

    @Test
    public void
    considerThirdAndOneUnitOfIhtiyatIfConflictedBetween2And3AfterSecondSujoodIn4UnitPrayer() {
        Doubt doubt = new Doubt(DHUHR, List.of(2, 3), SECOND_SUJOOD);

        List<RemedialAction> expected = List.of(
                new RemedialAction(3, RemedialActionType.SALAATUL_IHTIYAAT_STANDING, 1)
        );
        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

}
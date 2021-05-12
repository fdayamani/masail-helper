package com.wf.masailhelper.rakaat;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.wf.masailhelper.rakaat.Action.SECOND_SUJOOD;
import static org.assertj.core.api.Assertions.assertThat;

class RemedialCalculatorTest {

    @Test
    public void
    considerThirdAndOneUnitOfIhtiyatIfConflictedBetween2And3AfterSecondSujoodIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(2, 3), SECOND_SUJOOD);

        Remedy expected = new Remedy(3, List.of(new RemedialAction(RemedialActionType.SALAATUL_IHTIYAAT_STANDING, 1)));

        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatIfConflictedBetween2And4AfterSecondSujoodIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(2, 4), SECOND_SUJOOD);

        Remedy expected = new Remedy(4, List.of(new RemedialAction(RemedialActionType.SALAATUL_IHTIYAAT_STANDING, 2)));

        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatSittingAndTwoStandingIfConflictedBetween2And3And4AfterSecondSujoodIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(2, 3, 4), SECOND_SUJOOD);

        Remedy expected = new Remedy(4,
                List.of(new RemedialAction(RemedialActionType.SALAATUL_IHTIYAAT_STANDING, 2),
                        new RemedialAction(RemedialActionType.SALAATUL_IHTIYAAT_SITTING, 2)));
        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatSittingOrOneStandingIfConflictedBetween3And4AfterSecondSujoodIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(3, 4), SECOND_SUJOOD);

        Remedy expected = new Remedy(4,
                List.of(new RemedialAction(RemedialActionType.SALAATUL_IHTIYAAT_EITHER, 1)));
        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

}
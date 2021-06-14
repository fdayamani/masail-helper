package com.wf.masailhelper.rakaat;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.wf.masailhelper.rakaat.Action.QIYAM;
import static com.wf.masailhelper.rakaat.Action.SECOND_SUJOOD;
import static com.wf.masailhelper.rakaat.RemedialActionType.*;
import static org.assertj.core.api.Assertions.assertThat;

class RemedialCalculatorTest {

    @Test
    public void
    considerThirdAndOneUnitOfIhtiyatIfConflictedBetween2And3AfterSecondSujoodIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(2, 3), SECOND_SUJOOD);

        Remedy expected = new Remedy(3, List.of(new RemedialAction(SALAATUL_IHTIYAAT_STANDING, 1)));

        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatIfConflictedBetween2And4AfterSecondSujoodIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(2, 4), SECOND_SUJOOD);

        Remedy expected = new Remedy(4, List.of(new RemedialAction(SALAATUL_IHTIYAAT_STANDING, 2)));

        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatSittingAndTwoStandingIfConflictedBetween2And3And4AfterSecondSujoodIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(2, 3, 4), SECOND_SUJOOD);

        Remedy expected = new Remedy(4,
                List.of(new RemedialAction(SALAATUL_IHTIYAAT_STANDING, 2),
                        new RemedialAction(SALAATUL_IHTIYAAT_SITTING, 2)));

        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatSittingOrOneStandingIfConflictedBetween3And4AfterSecondSujoodIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(3, 4), SECOND_SUJOOD);

        Remedy expected = new Remedy(4,
                List.of(new RemedialAction(SALAATUL_IHTIYAAT_EITHER, 1)));

        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatSittingOrOneStandingIfConflictedBetween4And5AfterSecondSujoodIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(4, 5), SECOND_SUJOOD);

        Remedy expected = new Remedy(4,
                List.of(new RemedialAction(SALAATUL_IHTIYAAT_EITHER, 1),
                        new RemedialAction(SAJDATUS_SAHW, 2)
                        ));
        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatSittingOrOneStandingIfConflictedBetween3And4InQiyamIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(3, 4), QIYAM);

        Remedy expected = new Remedy(4,
                List.of(new RemedialAction(SALAATUL_IHTIYAAT_EITHER, 1)));

        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatSittingOrOneStandingIfConflictedBetween4And5InQiyamIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(4, 5), QIYAM);

        Remedy expected = new Remedy(4,
                List.of(new RemedialAction(SALAATUL_IHTIYAAT_EITHER, 1)));

        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatStandingIfConflictedBetween3And5InQiyamIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(3, 5), QIYAM);

        Remedy expected = new Remedy(4,
                List.of(new RemedialAction(SALAATUL_IHTIYAAT_STANDING, 2)));

        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoUnitsOfIhtiyatStandingAndTwoSittingIfConflictedBetween3And4And5InQiyamIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(3, 4, 5), QIYAM);

        Remedy expected = new Remedy(4,
                List.of(new RemedialAction(SALAATUL_IHTIYAAT_STANDING, 2),
                        new RemedialAction(SALAATUL_IHTIYAAT_SITTING, 2)
                        ));
        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

    @Test
    public void
    considerFourthAndTwoSajdatusSahwIfConflictedBetween5And5InQiyamIn4UnitPrayer() {
        Doubt doubt = new Doubt(4, List.of(5, 6), QIYAM);

        Remedy expected = new Remedy(4,
                List.of(new RemedialAction(SAJDATUS_SAHW, 2)));

        assertThat(RemedialCalculator.calculate(doubt)).isEqualTo(expected);
    }

}
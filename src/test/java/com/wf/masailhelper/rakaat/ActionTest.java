package com.wf.masailhelper.rakaat;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static com.wf.masailhelper.rakaat.Action.from;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ActionTest {
//    QIYAM("Qiyam"),
//    SECOND_SUJOOD ("During or after second Sujood"),
//    AFTER_SALAAT("After Salaat"),
//    OTHER ("None of the above");

    @Test public void
    returnsQiyamFromQiyam() {
        assertThat(from("Qiyam")).isEqualTo(Action.QIYAM);
    }

    @Test public void
    returnsSecondSujoodFromItsDescription() {
        assertThat(from("During or after second Sujood")).isEqualTo(Action.SECOND_SUJOOD);
    }

    @Test public void
    returnsAfterSalaatFromItsDescription() {
        assertThat(from("After Salaat")).isEqualTo(Action.AFTER_SALAAT);
    }

    @Test public void
    returnsOtherFromNoneOfTheAbove() {
        assertThat(from("None of the above")).isEqualTo(Action.OTHER);
    }

    @Test public void
    throwsIllegalArgumentExceptionIfStringIsNotRecognised() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> from("Unrecognised string"));
    }

}
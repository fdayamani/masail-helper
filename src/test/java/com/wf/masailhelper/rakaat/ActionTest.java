package com.wf.masailhelper.rakaat;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static com.wf.masailhelper.rakaat.Action.from;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ActionTest {
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
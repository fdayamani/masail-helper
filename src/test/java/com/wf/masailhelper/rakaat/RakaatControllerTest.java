package com.wf.masailhelper.rakaat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RakaatControllerTest {

    RakaatController underTest = new RakaatController();

    @Test public void
    addsOptionToList() {
        String option = "2";
        underTest.options(option);
        assertThat(underTest.options).contains(Integer.valueOf(option));
    }

    @Test public void
    removesOptionFromListIfItIsAlreadyThere() {
        String option = "2";
        underTest.options(option);
        underTest.options(option);
        assertThat(underTest.options).doesNotContain(Integer.valueOf(option));
    }

    @Test public void
    throwsExceptionIfThereAreAlreadyThreeOptions() {
        String option1 = "2";
        String option2 = "3";
        String option3 = "4";
        underTest.options(option1);
        underTest.options(option2);
        underTest.options(option3);
        assertThat(underTest.options).contains(Integer.valueOf(option1), Integer.valueOf(option2), Integer.valueOf(option3));
        assertThatThrownBy(() -> underTest.options("5"))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("You already have three options! Please deselect one first [2, 3, 4]");
    }

    @Test public void
    allowsDeselectionIfThereAreAlreadyThreeOptions() {
        String option1 = "2";
        String option2 = "3";
        String option3 = "4";
        underTest.options(option1);
        underTest.options(option2);
        underTest.options(option3);
        assertThat(underTest.options).contains(Integer.valueOf(option1), Integer.valueOf(option2));
        assertDoesNotThrow(() -> underTest.options(option3));
    }

}
package com.wf.masailhelper.rakaat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    throwsExceptionIfThereAreAlreadyTwoOptions() {
        String option1 = "2";
        String option2 = "4";
        underTest.options(option1);
        underTest.options(option2);
        assertThat(underTest.options).contains(Integer.valueOf(option1), Integer.valueOf(option2));
        assertThatThrownBy(() -> underTest.options("3"))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("You already have two options! Please deselect one first [2, 4]");
    }

    @Test public void
    doesNothingIfThereAreAlreadyTwoOptions() {
        String option1 = "2";
        String option2 = "4";
        underTest.options(option1);
        underTest.options(option2);
        underTest.options("3");
        assertThat(underTest.options).contains(Integer.valueOf(option1), Integer.valueOf(option2));
    }

}
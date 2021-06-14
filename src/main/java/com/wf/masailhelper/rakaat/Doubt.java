package com.wf.masailhelper.rakaat;

import java.util.List;
import java.util.Objects;

public class Doubt {
    private final int numberOfRakah;
    private final List<Integer> options;

    private final Action action;

    public Doubt(int numberOfRakah, List<Integer> options, Action action) {
        this.numberOfRakah = numberOfRakah;
        this.options = options;
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Doubt{" +
                "numberOfRakah=" + numberOfRakah +
                ", options=" + options +
                ", action=" + action +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doubt doubt = (Doubt) o;
        return numberOfRakah == doubt.numberOfRakah &&
                Objects.equals(options, doubt.options) &&
                action == doubt.action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfRakah, options, action);
    }
}

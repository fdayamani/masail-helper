package com.wf.masailhelper.rakaat;

import java.util.List;
import java.util.Objects;

public class Doubt {
    private final Salaat salaat;
    private final List<Integer> options;
    private final Action action;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doubt doubt = (Doubt) o;
        return salaat == doubt.salaat &&
                Objects.equals(options, doubt.options) &&
                action == doubt.action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salaat, options, action);
    }

    public Doubt(Salaat salaat, List<Integer> options, Action action) {
        this.salaat = salaat;
        this.options = options;
        this.action = action;
    }

    @Override
    public String toString() {
        return "Doubt{" +
                "salaat=" + salaat +
                ", options=" + options +
                ", action=" + action +
                '}';
    }
}

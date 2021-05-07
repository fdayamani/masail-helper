package com.wf.masailhelper.rakaat;

import java.util.List;

public class Doubt {
    private final Salaat salaat;
    private final List<Integer> options;
    private final Action action;

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

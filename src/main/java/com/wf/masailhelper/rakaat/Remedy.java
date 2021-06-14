package com.wf.masailhelper.rakaat;

import java.util.List;
import java.util.Objects;

import static com.wf.masailhelper.rakaat.RemedialActionType.SALAAT_INVALID;

public class Remedy {
    private int assumption;
    private List<RemedialAction> actions;

    public Remedy(int assumption, List<RemedialAction> actions) {
        this.assumption = assumption;
        this.actions = actions;
    }

    public Remedy(RemedialActionType salaatInvalid) {
        this(0, List.of(new RemedialAction(SALAAT_INVALID, 0)));
    }

    public int getAssumption() {
        return assumption;
    }

    public List<RemedialAction> getActions() {
        return actions;
    }

    @Override
    public String toString() {
        return "Remedy{" +
                "assumption=" + assumption +
                ", actions=" + actions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remedy remedy = (Remedy) o;
        return assumption == remedy.assumption &&
                Objects.equals(actions, remedy.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assumption, actions);
    }
}

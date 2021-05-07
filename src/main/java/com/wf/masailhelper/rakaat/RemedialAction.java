package com.wf.masailhelper.rakaat;

import java.util.Objects;

public class RemedialAction {
    private int assumption;
    private RemedialActionType actionType;
    private int number;

    public int getAssumption() {
        return assumption;
    }

    public RemedialActionType getActionType() {
        return actionType;
    }

    public int getNumber() {
        return number;
    }

    public RemedialAction(int assumption, RemedialActionType actionType, int number) {
        this.assumption = assumption;
        this.actionType = actionType;
        this.number = number;
    }

    @Override
    public String toString() {
        return "RemedialAction{" +
                "assumption=" + assumption +
                ", actionType=" + actionType +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemedialAction that = (RemedialAction) o;
        return assumption == that.assumption &&
                number == that.number &&
                actionType == that.actionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(assumption, actionType, number);
    }
}

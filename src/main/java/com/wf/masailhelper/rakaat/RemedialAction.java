package com.wf.masailhelper.rakaat;

import java.util.Objects;

public class RemedialAction {
    private RemedialActionType actionType;
    private int number;

    public RemedialAction(RemedialActionType actionType, int number) {
        this.actionType = actionType;
        this.number = number;
    }

    public RemedialActionType getActionType() {
        return actionType;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "RemedialAction{" +
                "actionType=" + actionType +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemedialAction that = (RemedialAction) o;
        return number == that.number &&
                actionType == that.actionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionType, number);
    }
}

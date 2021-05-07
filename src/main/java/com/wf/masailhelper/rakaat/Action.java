package com.wf.masailhelper.rakaat;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public enum Action {
    QIYAM("Qiyam"),
    SECOND_SUJOOD ("During or after second Sujood"),
    AFTER_SALAAT("After Salaat"),
    OTHER ("None of the above");

    public String getDescription() {
        return description;
    }

    private String description;

    Action(String description) {
        this.description = description;
    }

    public static Action from(String actionString) {
        return Optional.ofNullable(descriptionToAction.get(actionString)).orElseThrow(NoSuchElementException::new);
    }

    private static final Map<String, Action> descriptionToAction;
    static {
        descriptionToAction = new HashMap<>();
        for (Action action : Action.values()) {
            descriptionToAction.put(action.description, action);
        }
    }
}

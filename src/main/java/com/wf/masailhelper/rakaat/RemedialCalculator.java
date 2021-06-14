package com.wf.masailhelper.rakaat;

import static com.wf.masailhelper.rakaat.Action.AFTER_SALAAT;
import static com.wf.masailhelper.rakaat.RemedialActionType.IGNORE_DOUBT;
import static com.wf.masailhelper.rakaat.RemedialActionType.SALAAT_INVALID;
import static com.wf.masailhelper.rakaat.Rules.rules;

public class RemedialCalculator {
    public static Remedy calculate(Doubt doubt) {
        if (AFTER_SALAAT.equals(doubt.getAction())) {
            return new Remedy(IGNORE_DOUBT);
        }

        return rules.getOrDefault(doubt, new Remedy(SALAAT_INVALID));
    }
}

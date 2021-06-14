package com.wf.masailhelper.rakaat;

import static com.wf.masailhelper.rakaat.RemedialActionType.SALAAT_INVALID;
import static com.wf.masailhelper.rakaat.Rules.rules;

public class RemedialCalculator {
    public static Remedy calculate(Doubt doubt) {
        return rules.getOrDefault(doubt, new Remedy(SALAAT_INVALID));
    }
}

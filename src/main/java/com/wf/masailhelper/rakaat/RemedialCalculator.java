package com.wf.masailhelper.rakaat;

import static com.wf.masailhelper.rakaat.Rules.rules;

public class RemedialCalculator {
    public static Remedy calculate(Doubt doubt) {
        return rules.get(doubt);
    }
}

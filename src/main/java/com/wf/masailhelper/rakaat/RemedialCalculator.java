package com.wf.masailhelper.rakaat;

import java.util.ArrayList;
import java.util.List;

import static com.wf.masailhelper.rakaat.Action.SECOND_SUJOOD;

public class RemedialCalculator {
    public static List<RemedialAction> calculate(Doubt doubt) {
        List<RemedialAction> remedialActions = new ArrayList<>();
        if (new Doubt(Salaat.DHUHR, List.of(2, 3), SECOND_SUJOOD).equals(doubt)) {
            remedialActions.add(new RemedialAction(3, RemedialActionType.SALAATUL_IHTIYAAT_STANDING, 1));
        } else {
            remedialActions.add(new RemedialAction(4, RemedialActionType.SALAATUL_IHTIYAAT_STANDING, 2));
        }
        return remedialActions;
    }
}

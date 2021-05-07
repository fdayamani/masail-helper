package com.wf.masailhelper.rakaat;

import java.util.ArrayList;
import java.util.List;

public class RemedialCalculator {
    public static List<RemedialAction> calculate(Doubt doubt) {
        List<RemedialAction> remedialActions = new ArrayList<RemedialAction>();
        remedialActions.add(new RemedialAction(3, RemedialActionType.SALAATUL_IHTIYAAT_STANDING, 1));
        return remedialActions;
    }
}

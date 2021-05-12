package com.wf.masailhelper.rakaat;

import java.util.List;
import java.util.Map;

import static com.wf.masailhelper.rakaat.Action.SECOND_SUJOOD;
import static com.wf.masailhelper.rakaat.RemedialActionType.SALAATUL_IHTIYAAT_SITTING;
import static com.wf.masailhelper.rakaat.RemedialActionType.SALAATUL_IHTIYAAT_STANDING;

public class Rules {
    public static final Map<Doubt, Remedy> rules = Map.of(
        new Doubt(4, List.of(2, 3), SECOND_SUJOOD),
                new Remedy(3, List.of(new RemedialAction(SALAATUL_IHTIYAAT_STANDING, 1))),
        new Doubt(4, List.of(2, 4), SECOND_SUJOOD),
                new Remedy(4, List.of(new RemedialAction(SALAATUL_IHTIYAAT_STANDING, 2))),
        new Doubt(4, List.of(2, 3, 4), SECOND_SUJOOD),
                new Remedy(4, List.of(new RemedialAction(SALAATUL_IHTIYAAT_STANDING, 2),
                                                new RemedialAction(SALAATUL_IHTIYAAT_SITTING, 2)))
    );
}

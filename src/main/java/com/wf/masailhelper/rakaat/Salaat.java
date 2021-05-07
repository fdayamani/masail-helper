package com.wf.masailhelper.rakaat;

public enum Salaat {
    FAJR(2),
    DHUHR(4),
    ASR(4),
    MAGHRIB(3),
    ISHA(4);

    private int numberOfRakaat;

    Salaat(int numberOfRakaat) {
        this.numberOfRakaat = numberOfRakaat;
    }

    public int getNumberOfRakaat() {
        return numberOfRakaat;
    }
}

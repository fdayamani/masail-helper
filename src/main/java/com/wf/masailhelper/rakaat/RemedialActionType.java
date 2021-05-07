package com.wf.masailhelper.rakaat;

import java.util.Optional;

public enum RemedialActionType {
    SALAAT_INVALID("Invalid Salaat", "Pray again", Optional.empty()),
    IGNORE_DOUBT("Ignore Doubt", "Do nothing", Optional.empty()),
    SAJDATUS_SAHW("Sajdatus Sahw", Constants.SAJDATUS_SAHW_MATHOD, Optional.empty()),
    SALAATUL_IHTIYAAT_STANDING("Salaatul Ihtiyaat", Constants.SALAATUL_IHTIYAAT_METHOD, Optional.of(true)),
    SALAATUL_IHTIYAAT_SITTING("Salaatul Ihtiyaat", Constants.SALAATUL_IHTIYAAT_METHOD, Optional.of(false));

    private final String name;
    private final String method;
    private final Optional<Boolean> standing;

    RemedialActionType(String name, String method, Optional<Boolean> standing) {
        this.name = name;
        this.method = method;
        this.standing = standing;
    }

    private static class Constants {
        public static final String SAJDATUS_SAHW_MATHOD =
                "Intention\n" +
                "Go into sujood and recite:\n" +
                "Bismillahi wa billahi as salaami alayka ayyuhan nabiyyu wa rahmatullahi wa barakatuh\n" +
                "Then sit up, go back into sujood and recite the same\n" +
                "Complete with tashahhud and salaam (As salaamu alaykum wa rahmatullahi wa barakatuh";
        public static final String SALAATUL_IHTIYAAT_METHOD = "Intention: I am praying Salaatul Ihtiyat one (or two) rak’ats wajib qurbatan ilallah. \n" +
                "Immediately after completing the Salaat (in which the doubt had occurred and which requires Salaatul Ihtiyat to be performed for its completion and validation), without turning away from Qiblah or doing anything which invalidates Salat, stand up and make niyyah (intention) in your mind (without uttering).  If the Salaatul Ihtiyat is to be performed in a sitting position, then remain seated and make niyyah in your mind. \n" +
                "Say Takbiratul Ehram.  \n" +
                "Recite Bismillahr-Rahmanir-Rahim and recite only Surah Al-Hamd (both in low whisper). " +
                "Perform ruku’u and the two sajdah.  " +
                "If only one rak’at of Salatul Ihtiyat is to be performed, recite Tashahhud and Salaam of the prayers after the two sajdah and complete the Salaat.  " +
                "If it is obligatory to perform two rak’ats, then after the two sajdah, perform another rak’at like the first one, and then complete with Tashahhud and Salaam. \n" +
                "Note: Salatul Ihtiyat does not have a second Surah or Qunuut.\n" +
                "Caution: If any act is performed which invalidates the prayer before starting Salaatul Ihtiyat, for example, turning away from Qiblah, then the prayer should be repeated.";
    }
}

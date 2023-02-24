public enum Starter {
    I("I", "SWR"),
    YOU("you", "KPWR"),
    HE("he", "KWHR", StarterCase.THIRD_SINGULAR),
    SHE("she", "SKWHR", StarterCase.THIRD_SINGULAR),
    IT("it","KPWH", StarterCase.THIRD_SINGULAR),
    THEY("they","TWH"),
    THIS("this","STKH", StarterCase.THIRD_SINGULAR),
    THAT("that","STWH", StarterCase.THIRD_SINGULAR),
    THERE_SINGULAR("there","STHR", StarterCase.THIRD_SINGULAR),
    THERE_PLURAL("there","STPHR", StarterCase.THIRD_PLURAL),
    EMPTY_SINGULAR("","STKPWHR", StarterCase.THIRD_SINGULAR),
    EMPTY_PLURAL("","STWR", StarterCase.THIRD_PLURAL);


    public final String word;
    public final String chord;
    public final StarterCase starterCase;

    Starter(String word, String chord) {
        this(word, chord, StarterCase.NONE);
    }

    Starter(String word, String chord, StarterCase starterCase) {
        this.word = word;
        this.chord = chord;
        this.starterCase = starterCase;
    }

    public enum StarterCase {
        NONE,
        THIRD_SINGULAR,
        THIRD_PLURAL
    }

}

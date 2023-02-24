public enum Verb {
    ___NONE___("{empty}", "", Constants.MANUAL_MODE, Constants.MANUAL_MODE) {
        @Override
        public String conjugate(Phrase phrase) {
            return "";
        }
    },

    BE("To be (a)", "B", Constants.MANUAL_MODE, Constants.MANUAL_MODE) {
        @Override
        public String conjugate(Phrase phrase) {
            if (phrase.prefix != Prefix.DO) return "be";

            switch (phrase.starter) {
                case I -> {
                    return "am";
                }
                case YOU, THEY, EMPTY_PLURAL -> {
                    return "are";
                }
                case HE, SHE, IT, THIS, THAT, THERE_SINGULAR, THERE_PLURAL, EMPTY_SINGULAR -> {
                    return "is";
                }

            }
            throw new IllegalArgumentException(phrase.toString());
        }
    },

    BECOME("To become (a)", "RPBG", "become", "becomes"),
    BELIEVE("To believe (that)", "BL", "believe", "believes"),
    CALL("To call", "RBLG", "call", "calls"),

    CAN("Can/Could", "BGS", Constants.MANUAL_MODE, Constants.MANUAL_MODE) {
        @Override
        public String conjugate(Phrase phrase) {
            return "can";
        }
    },
    CARE("To care", "RZ", "care", "cares"),
    COME("To come (to)", "BG", "come", "comes"),
    DO("To do (it)", "RP", "do", "does"),
    EXPECT("To expect (that)", "PGS", "expect", "expects"),
    FEEL("To feel (like)", "LT", "feel", "feels"),
    FIND("To find (that)", "PBLG", "find", "finds"),
    FORGET("To forget (to)", "RG", "forget", "forgets"),
    GET("To get (to)", "GS", "get", "gets"),
    GIVE("To give", "GZ", "give", "gives"),
    GO("To go (to)", "G", "go", "goes"),
    HAPPEN("To happen", "PZ", "happen", "happens"),
    HAVE("To have (to)", "T", "have", "has"),
    HEAR("To hear (that)", "PG", "hear", "hears"),
    HOPE("To hope (to)", "RPS", "hope", "hopes"),
    IMAGINE("To imagine (that)", "PLG", "imagine", "imagines"),
    KEEP("To keep", "PBGS", "keep", "keeps"),
    KNOW("To know (that)", "PB", "know", "knows"),
    LEARN("To learn (to)", "RPBS", "learn", "learns"),
    LEAVE("To leave", "LGZ", "leave", "leaves"),
    LIKE("To like (to)", "BLG", "like", "likes"),
    LIVE("To live", "LZ", "live", "lives"),
    LOOK("To look", "L", "look", "looks"),
    LOVE("To love (to)", "LG", "love", "loves"),
    LET("To let", "LS", "let", "lets"),
    MAKE("To make (the)", "RPBL", "make", "makes"),
    MAY("May/Might (be)", "PL", "may", "might"),
    MEAN("To mean (to)", "PBL", "mean", "means"),
    MOVE("To move", "PLZ", "move", "moves"),
    MUST("Must (be)", "PBLGS", "must", "must"), // TODO
    NEED("To need (to)", "RPG", "need", "needs"),
    PUT("To put (it)", "PS", "put", "puts"),
    READ("To read", "RS", "read", "reads"),
    REALIZE("To realize (that)", "RLS", "realize", "realizes"),
    REALLY("really", "RLG", "really", "really"), // TODO
    RECALL("To recall", "RL", "recall", "recalls"),
    REMEMBER("To remember (that)", "RPL", "remember", "remembers"),
    REMAIN("To remain", "RPLS", "remain", "remains"),
    RUN("To run", "R", "run", "runs"),
    SAY("To say (that)", "BS", "say", "says"),
    SEE("To see", "S", "see", "sees"),
    SEEM("To seem (to)", "PLS", "seem", "seems"),
    SET("To set", "BLS", "set", "sets"),
    SHALL("Shall/Should", "RBL", "shall", "shall"), // TODO?
    SHOW("To show", "RBZ", "show", "shows"),

    TAKE("To take", "RBT", "take", "takes"),
    TELL("To tell", "RLT", "tell", "tells"),
    THINK("To think (that)", "PBG", "think", "thinks"),
    TRY("To try (to)", "RT", "try", "tries"),
    UNDERSTAND("To understand (the)", "RPB", "understand", "understands"),
    USE("To use", "Z", "use", "uses"),
    WANT("To want (to)", "P", "want", "wants"),
    WILL("Will/Would", "RBGS", "will", "will"),
    WISH("To wish (to)", "RBS", "wish", "wishes"),
    WORK("To work (on)", "RBG", "work", "works");

    public final String verb;
    public final String chord;
    private final String rootWord;
    private final String thirdSingularWord;

    Verb(String verb, String chord, String rootWord, String thirdSingularWord) {
        this.verb = verb;
        this.chord = chord;
        this.rootWord = rootWord;
        this.thirdSingularWord = thirdSingularWord;
    }

    public String conjugate(Phrase phrase) {
        if (phrase.prefix != Prefix.DO) return rootWord;
        return phrase.starter.starterCase == Starter.StarterCase.THIRD_SINGULAR ? thirdSingularWord : rootWord;

    }

    public static void main(String[] args) {
        for (Verb value : Verb.values()) {
            System.out.println(value.chord + "\t" + value.verb);
        }
    }

    private static class Constants {
        public static final String MANUAL_MODE = "XX";
    }
}

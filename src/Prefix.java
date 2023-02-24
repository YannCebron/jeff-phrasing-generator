public enum Prefix {
    DO("do/does/did","-") {
        @Override
        public String conjugate(Phrase phrase) {
            return "";
          //  return phrase.starter.starterCase == Starter.StarterCase.THIRD_SINGULAR ? "does" : "do";
        }
    },
    CAN("can/could","A") {
        @Override
        public String conjugate(Phrase phrase) {
            return "can";
        }
    },
    SHALL("shall/should","O") {
        @Override
        public String conjugate(Phrase phrase) {
            return "shall";
        }
    },
    WILL("will/would","AO"){
        @Override
        public String conjugate(Phrase phrase) {
            return "will";
        }
    }
    ;
    public final String word;
    public final String chord;

    Prefix(String word,String chord) {
        this.word=word;
        this.chord = chord;
    }

    public abstract String conjugate(Phrase phrase);

}

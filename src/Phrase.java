import java.util.EnumSet;
import java.util.Set;

public class Phrase {

    public final Starter starter;
    public final Prefix prefix;
    public final Verb verb;

    public Phrase(Starter starter, Prefix prefix, Verb verb) {
        this.starter = starter;
        this.prefix = prefix;
        this.verb = verb;
    }

    private static final Set<Verb> THERE_VERBS = EnumSet.of(
            Verb.___NONE___,
            Verb.BE, Verb.COME, Verb.GO, Verb.HAPPEN,
            Verb.HAVE, Verb.LIVE, Verb.MAY, Verb.MUST,
            Verb.NEED, Verb.REALLY, Verb.SEEM, Verb.USE
    );


    private static final Set<String> INVALID_CHORDS = Set.of(
            "STHR",
            "STHRET",
            "STHREUPLT",
            "STPHREFPLT",
            "SKPUR",
            "SKPUL",
            "SKPEUT",
            "SKP*"
    );

    public boolean isValid() {
        if (INVALID_CHORDS.contains(getChord())) {
            return false;
        }

        if (starter != Starter.THERE_SINGULAR && starter != Starter.THERE_PLURAL) {
            return true;
        }

        return THERE_VERBS.contains(verb);
    }

    public String getChord() {
        if (verb == Verb.___NONE___ && prefix == Prefix.DO) {
            return starter.chord;
        }
        return starter.chord + prefix.chord + verb.chord;
    }

    public String getSentence() {
        String conjugatePrefix = prefix.conjugate(this);
        String finalPrefix = conjugatePrefix.isEmpty() ? "" : " " + conjugatePrefix;
        String finalVerb = verb.conjugate(this);
        return starter.word + finalPrefix + " " + finalVerb;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "starter=" + starter +
                ", prefix=" + prefix +
                ", verb=" + verb +
                '}';
    }
}

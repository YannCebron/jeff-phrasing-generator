import java.util.EnumSet;
import java.util.Set;

public class GeneratorConfig {

    public  Set<Starter> starterSet = EnumSet.allOf(Starter.class);
    public Set<Prefix> prefixSet = EnumSet.allOf(Prefix.class);
    public Set<Verb> verbSet = EnumSet.allOf(Verb.class);

    public boolean dumpInvalidPhrases = false;

    @Override
    public String toString() {
        return "GeneratorConfig{" +
                "starterSet=" + starterSet +
                ", prefixSet=" + prefixSet +
                ", verbSet=" + verbSet +
                '}';
    }
}

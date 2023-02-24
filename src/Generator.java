import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Generator {

    private static int dumpCount = 0;

    public static void main(String[] args) {
        GeneratorConfig generatorConfig =
//                all();
//                allDumpInvalid(); // 379
                onlyIYouAndFun();
        run(generatorConfig);
    }

    private static GeneratorConfig all() {
        return new GeneratorConfig();
    }

    private static GeneratorConfig allDumpInvalid() {
        GeneratorConfig config = new GeneratorConfig();
        config.dumpInvalidPhrases = true;
        return config;
    }

    private static GeneratorConfig onlyIYouAndFun() {
        GeneratorConfig config = new GeneratorConfig();
        config.starterSet = EnumSet.of(Starter.I, Starter.YOU, Starter.HE, Starter.SHE, Starter.IT, Starter.THEY);
        return config;
    }

    private static void run(GeneratorConfig generatorConfig) {
        System.out.println(generatorConfig);
        System.out.println();

        List<Phrase> invalidPhrases = new ArrayList<>();

        for (Prefix prefix : generatorConfig.prefixSet) {
            for (Verb verb : generatorConfig.verbSet) {
                for (Starter starter : generatorConfig.starterSet) {
                    Phrase phrase = new Phrase(starter, prefix, verb);

                    if (!phrase.isValid() || phrase.getSentence().isBlank()) {
                        invalidPhrases.add(phrase);
                        continue;
                    }

                    dump(phrase);
                }
            }
        }

        System.out.println();
        System.out.println(dumpCount);

        if (generatorConfig.dumpInvalidPhrases) {
            System.out.println("Invalid Phrases: " + invalidPhrases.size());
            for (Phrase phrase : invalidPhrases) {
                System.out.println(phrase.getChord() + "\t" + phrase.getSentence() + "\t\t" + phrase);
            }
        }
    }

    private static void dump(Phrase phrase) {
        System.out.println(phrase.getChord() + "\t" + phrase.getSentence() + "\t\t" + phrase);
        dumpCount++;
    }
}

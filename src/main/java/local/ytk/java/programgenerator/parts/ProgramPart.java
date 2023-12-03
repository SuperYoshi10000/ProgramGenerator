package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.lang.Language;

public class ProgramPart {
    ProgramString convertTo(Language lang) {
        return new ProgramString(lang.generate(null));
    }
}

package local.ytk.java.programgenerator.old.parts;

import local.ytk.java.programgenerator.old.lang.Language;

public class ProgramPart {
    ProgramString convertTo(Language lang) {
        return new ProgramString(lang.generate(null));
    }
}

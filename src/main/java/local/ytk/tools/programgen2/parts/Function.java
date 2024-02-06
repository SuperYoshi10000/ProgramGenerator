package local.ytk.tools.programgen2.parts;

import local.ytk.tools.programgen2.type.Typed;

public interface Function extends Identifiable, Typed {
    ParameterList argumentList();
}

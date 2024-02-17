package local.ytk.tools.programgen2.parts;

import local.ytk.tools.programgen2.type.Typed;

public interface Function extends Scope, Identifiable, Typed {
    ParameterList argumentList();
}

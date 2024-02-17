package local.ytk.tools.programgen2.parts;

import java.util.Collection;

import local.ytk.tools.programgen2.parts.declarations.ParameterDeclaration;

public interface ParameterList extends ProgramPart {
    Collection<ParameterDeclaration> parameters();
}

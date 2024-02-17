package local.ytk.tools.programgen2.parts.declarations;

import local.ytk.tools.programgen2.parts.ThrowsList;

public interface MethodDeclaration extends MemberDeclaration, FunctionDeclaration {
    ThrowsList throwsList();
}

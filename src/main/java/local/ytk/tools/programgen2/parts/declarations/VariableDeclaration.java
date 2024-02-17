package local.ytk.tools.programgen2.parts.declarations;

import local.ytk.tools.programgen2.parts.ModifierList;
import local.ytk.tools.programgen2.parts.Variable;
import local.ytk.tools.programgen2.type.Type;

public interface VariableDeclaration extends Declaration {
    ModifierList mods();
    @Override
    Variable component();
    default Type type() {
        return component().type();
    }
}

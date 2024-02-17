package local.ytk.tools.programgen2.parts.literal;

import java.util.Collection;

import local.ytk.tools.programgen2.parts.declarations.PropertyDeclaration;

public interface ObjectLiteral extends DynamicLiteral {
    Collection<PropertyDeclaration> properties();
}

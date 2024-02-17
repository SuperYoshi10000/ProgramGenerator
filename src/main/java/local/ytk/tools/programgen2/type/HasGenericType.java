package local.ytk.tools.programgen2.type;

import java.util.Collection;

public interface HasGenericType extends Type {
    Collection<GenericType> generics();
}

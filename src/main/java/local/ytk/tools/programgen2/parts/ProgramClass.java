package local.ytk.tools.programgen2.parts;

import java.util.Collection;

import local.ytk.tools.programgen2.type.ObjectType;

public interface ProgramClass extends Member, ObjectType {
    Collection<Member> members();
    void member(Member... members);
}

package local.ytk.tools.programgen2.parts;

import java.util.Collection;

public interface MemberContainer extends ProgramPart {
    Collection<Member> members();
    void member(Member... members);
}
